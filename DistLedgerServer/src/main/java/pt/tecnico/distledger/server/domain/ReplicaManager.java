package pt.tecnico.distledger.server.domain;

import io.grpc.Server;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import pt.tecnico.distledger.server.domain.exceptions.ServerUserException;
import pt.tecnico.distledger.server.domain.operation.Operation;

import pt.tecnico.distledger.utils.VectorClock;

import java.util.*;
import java.util.concurrent.locks.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReplicaManager {
    private Lock lock;
    private VectorClock valueTimestamp;
    private VectorClock replicaTimestamp;
    private List<LogRecord> updateLog;
    private Set<UUID> executedOperations;
    private List<LogRecord.CompareByPrevVectorClockIndex> recordComparatorList = new ArrayList<>();

    private static final Logger logger = LogManager.getLogger("GLOBAL");

    private Condition externalUpdateCond;

    ServerState state;

    public Lock getLock() { return lock; }

    public VectorClock getValueTimestamp() {
        return valueTimestamp;
    }

    public List<LogRecord> getUpdateLog() {
        return updateLog;
    }

    public Set<UUID> getExecutedOperations() {
        return executedOperations;
    }

    public ReplicaManager(ServerState state) {
        valueTimestamp = new VectorClock(Collections.nCopies(3, 0));
        replicaTimestamp = new VectorClock(Collections.nCopies(3, 0));
        updateLog = Collections.synchronizedList(new ArrayList<>());
        executedOperations = Collections.synchronizedSet(new HashSet<>());
        this.state = state;
        lock = new ReentrantLock();
        externalUpdateCond = lock.newCondition();
        for(int i = 0; i < valueTimestamp.size(); ++i) {
            recordComparatorList.add(new LogRecord.CompareByPrevVectorClockIndex(i));
        }
    }

    // This returns both the balance and the newTS
    public List<Object> balance(String user, VectorClock prev) throws InterruptedException {
        VectorClock nextTS = prev.clone();
        nextTS.set(state.getQualifierInt(), replicaTimestamp.get(state.getQualifierInt()));

        logger.debug("nextTS: {}", nextTS);

        while(true) {
            lock.lock();
            if(prev.beforeEqual(valueTimestamp)) {
                Integer balance;
                try {
                    balance = state.getBalance(user);
                } catch (ServerUserException e) {
                    throw new ServerUserException(e.getErrorMessage(), e.getAccount(), valueTimestamp);
                }
                externalUpdateCond.signal();
                lock.unlock();
                List<Object> response = new ArrayList<>();
                response.add(nextTS);
                response.add(balance);
                return response;
            }
            externalUpdateCond.await();
        }
    }

    public void updateReplicaTS() {
        switch(state.getQualifier()) {
            case "A":
                replicaTimestamp.set(0, replicaTimestamp.get(0) + 1);
                break;
            case "B":
                replicaTimestamp.set(1, replicaTimestamp.get(1) + 1);
                break;
            case "C":
                replicaTimestamp.set(2, replicaTimestamp.get(2) + 1);
                break;
        }
        logger.debug("Replica timestamp updated: {}", replicaTimestamp);
    }

    public void executeOperation(LogRecord record) {
        lock.lock();
        state.parseOperation(record.getOperation());
        valueTimestamp.merge(record.getTimestamp());
        executedOperations.add(record.getOperation().getId());
        logger.debug("Executed operation: {} with timestamp: {}", record.getOperation(), record.getTimestamp());
        lock.unlock();
    }

    public VectorClock processUpdate(Operation op) {
        lock.lock();
        if(executedOperations.contains(op.getId())) {
            lock.unlock();
            return op.getValueTimestamp();
        }
        updateReplicaTS();
        VectorClock recordNewTS = op.getValueTimestamp().clone();
        recordNewTS.set(state.getQualifierInt(), replicaTimestamp.get(state.getQualifierInt()));
        LogRecord record = new LogRecord(LogRecord.qualToInt(state.getQualifier()), op, recordNewTS);
        updateLog.add(record);
        if (op.getValueTimestamp().beforeEqual(valueTimestamp)) {
            executeOperation(record);
        }
        lock.unlock();
        logger.debug("Processed update operation: {} . New TimeStamp: {}", op, recordNewTS);
        return recordNewTS;
    }

    public void processGossip(List<LogRecord> externalLog, VectorClock externalTS) {
        lock.lock();
        externalLog.forEach(record -> {
            if (executedOperations.contains(record.getOperation().getId())) {
                valueTimestamp.merge(record.getTimestamp());
            }
            else { updateLog.add(record); }
        });
        logger.debug("Processing gossip: externalLog size = {}, externalTS = {}", externalLog.size(), externalTS);
        for (Integer i = 0; i < valueTimestamp.size(); ++i) {
            updateLog.sort(recordComparatorList.get(i));
        }
        updateLog.stream()
                .forEach(record -> {
                    if (!executedOperations.contains(record.getOperation().getId()) &&
                            record.getOperation().getValueTimestamp().beforeEqual(valueTimestamp)) {
                        executeOperation(record);
                    } else if (executedOperations.contains(record.getOperation().getId())) {
                        valueTimestamp.merge(record.getTimestamp());
                    }
                });
        replicaTimestamp.merge(externalTS);
        externalUpdateCond.signal();
        lock.unlock();
        logger.debug("Finished processing gossip: replicaTimestamp = {}", replicaTimestamp);
    }
}
