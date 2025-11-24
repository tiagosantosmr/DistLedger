package pt.tecnico.distledger.server.domain;

import pt.tecnico.distledger.utils.VectorClock;
import pt.tecnico.distledger.server.domain.operation.Operation;

import java.util.Comparator;

public class LogRecord {
    private Integer replicaManager;
    private VectorClock timestamp;
    private Operation operation;

    public Operation getOperation() {
        return operation;
    }

    public VectorClock getTimestamp() {
        return timestamp;
    }

    public static Integer qualToInt(String qual) {
        switch (qual){
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
        }
        throw new IllegalArgumentException("qualToInt: the qualifier must be A, B or C.");
    }

    public LogRecord(Integer qualInt, Operation op, VectorClock replicaTS) {
        replicaManager = qualInt;
        timestamp = op.getValueTimestamp().clone();
        timestamp.set(replicaManager, replicaTS.get(replicaManager));
        operation = op;
    }

    public static class CompareByPrevVectorClockIndex implements Comparator<LogRecord> {
        private Integer index;
        private VectorClock.CompareByIndex vectorComparator;

        public CompareByPrevVectorClockIndex(Integer index) {
            this.index = index;
            vectorComparator = new VectorClock.CompareByIndex(index);
        }

        public int compare(LogRecord a, LogRecord b) {
            return vectorComparator.compare(a.getOperation().getValueTimestamp(), a.getOperation().getValueTimestamp());
        }
    }
}
