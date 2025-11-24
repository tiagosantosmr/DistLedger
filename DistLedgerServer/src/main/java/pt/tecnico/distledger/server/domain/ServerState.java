package pt.tecnico.distledger.server.domain;

import pt.tecnico.distledger.server.domain.exceptions.ErrorMessage;
import pt.tecnico.distledger.server.domain.exceptions.ServerAdminException;
import pt.tecnico.distledger.server.domain.exceptions.ServerUserException;
import pt.tecnico.distledger.server.domain.operation.CreateOp;
import pt.tecnico.distledger.server.domain.operation.DeleteOp;
import pt.tecnico.distledger.server.domain.operation.Operation;
import pt.tecnico.distledger.server.domain.operation.TransferOp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServerState {
    private class Account {
        private final ReadWriteLock lock;
        private final String userId;
        private Integer balance;

        public ReadWriteLock getLock() {
            return lock;
        }

        public String getUserId() {
            return userId;
        }

        public Integer getBalance() {
            lock.readLock().lock();
            Integer ret = balance;
            lock.readLock().unlock();
            return ret;
        }

        public void receiveAmount(Integer amount) {
            lock.writeLock().lock();
            balance += amount;
            lock.writeLock().unlock();
        }

        public void sendAmount(Integer amount) {
            lock.writeLock().lock();
            Integer balance = this.getBalance();
            if (balance - amount < 0) { // Made to take into account the balance
                throw new ServerUserException(ErrorMessage.TRANSACTION_INSUFFICIENT_BALANCE, userId, balance, amount);
            }
            this.balance -= amount;
            lock.writeLock().unlock();
        }

        public Account(String userId) {
            this.lock = new ReentrantReadWriteLock();
            this.userId = userId;
            this.balance = Integer.valueOf(0);
        }

        public Account(String userId, int balance) {
            this.lock = new ReentrantReadWriteLock(true);
            this.userId = userId;
            this.balance = Integer.valueOf(balance);
        }
    }

    private String qualifier;

    public String getQualifier() { return qualifier; }

    public Integer getQualifierInt() {
        return switch(qualifier) {
            case "A" -> 0;
            case "B" -> 1;
            case "C" -> 2;
            default -> throw new UnsupportedOperationException();
        };
    }

    private List<Operation> ledger;

    // The key is the userId
    private ConcurrentHashMap<String, Account> accounts = new ConcurrentHashMap<>();

    private Boolean active;

    public Boolean getActive() { return active; }

    private static final Logger logger = LogManager.getLogger("GLOBAL");

    public ServerState(String qualifier) {
        logger.info("INIT. Initializing server state...");
        ledger = Collections.synchronizedList(new ArrayList<>());
        accounts.put("broker", new Account("broker", 1000));
        logger.info("INIT. Activating server...");
        active = true;
        this.qualifier = qualifier;
    }

    public Integer getBalance(String id) {
        Account account = accounts.get(id);
        if (account == null) {
            logger.info("ACTIVE. Received balance request with invalid arguments. Ignoring...");
            throw new ServerUserException(ErrorMessage.ACCOUNT_DOES_NOT_EXIST, id);
        }
        logger.info(String.format("ACTIVE. Received balance(%s) request. Serving...", id));
        return account.getBalance();
    }

    public void createAccount(String id) {
        if (accounts.get(id) != null) {
            logger.info("ACTIVE. Received createAccount request with invalid arguments. Ignoring...");
            throw new ServerUserException(ErrorMessage.ACCOUNT_ALREADY_EXISTS, id);
        }
        logger.info(String.format("ACTIVE. Received createAccount(%s) request. Serving...", id));
        accounts.put(id, new Account(id));
    }

    public void deleteAccount(String id) {
        if (!active) {
            logger.warn(String.format("UNAVAILABLE. Received deleteAccount(%s) request. Ignoring...", id));
            throw new ServerUserException(ErrorMessage.SERVER_IS_UNAVAILABLE);
        }

        Account account = accounts.get(id);
        if (account == null) {
            logger.info("ACTIVE. Received delete request with invalid arguments. Ignoring...");
            throw new ServerUserException(ErrorMessage.ACCOUNT_DOES_NOT_EXIST, id);
        }
        account.getLock().writeLock().lock();
        Integer balance = account.getBalance();
        if (balance != 0) {
            logger.info("ACTIVE. Received delete request with invalid arguments. Ignoring...");
            throw new ServerUserException(ErrorMessage.DELETE_BALANCE_IS_NOT_ZERO, id, balance);
        }
        logger.info(String.format("ACTIVE. Received deleteAccount(%s) request. Serving...", id));
        accounts.remove(id);
        account.getLock().writeLock().lock();
    }

    public void transferTo(String accountFrom, String accountTo, Integer amount) {
        if (accountFrom.equals(accountTo)) {
            logger.info("ACTIVE. Received transfer request with invalid arguments. Ignoring...");
            throw new ServerUserException(ErrorMessage.TRANSACTION_SENDER_IS_THE_SAME_AS_RECEIVER, accountFrom);
        }
        if (amount <= 0) {
            logger.info("ACTIVE. Received transfer request with invalid arguments. Ignoring...");
            throw new ServerUserException(ErrorMessage.TRANSACTION_INVALID_AMOUNT, amount);
        }

        Account sender = accounts.get(accountFrom);
        if (sender == null) {
            logger.info("ACTIVE. Received transfer request with invalid arguments. Ignoring...");
            throw new ServerUserException(ErrorMessage.ACCOUNT_DOES_NOT_EXIST, accountFrom);
        }

        Account receiver = accounts.get(accountTo);
        if (receiver == null) {
            logger.info("ACTIVE. Received transfer request with invalid arguments. Ignoring...");
            throw new ServerUserException(ErrorMessage.ACCOUNT_DOES_NOT_EXIST, accountTo);
        }

        logger.info(String.format("ACTIVE. Received transferTo(%s, %s, %d) request. Serving...", accountFrom, accountTo, amount));
        sender.sendAmount(amount); // Discutir com o professor: Afinal os checks não precisam de lock...
        receiver.receiveAmount(amount);
    }

    public void activate() {
        if (active == true) {
            logger.info("ADMIN. Received activate request but server is already active. Ignoring...");
            throw new ServerAdminException(ErrorMessage.SERVER_IS_ALREADY_ACTIVE);
        }
        logger.info("ADMIN. Received activate request. Activating...");
        active = true;
    }

    public void deactivate() {
        if (active == false) {
            logger.info("ADMIN. Received deactivate request but server is already deactivated. Ignoring...");
            throw new ServerAdminException(ErrorMessage.SERVER_IS_ALREADY_INACTIVE);
        }
        logger.info("ADMIN. Received deactivate request. Deactivating...");
        active = false;
    }

    public List<Operation> getLedger() {
        logger.info("ADMIN. Received getLedger request. Serving...");
        return this.ledger;
    }

    public void parseOperation(Operation operation) {
        try {
            switch (operation.getType()) {
                case CREATE:
                    CreateOp createOp = (CreateOp) operation;
                    createAccount(createOp.getAccount());
                    ledger.add(createOp);
                    break;
                case TRANSFER:
                    TransferOp transferOp = (TransferOp) operation;
                    transferTo(transferOp.getAccount(), transferOp.getDestAccount(), transferOp.getAmount());
                    ledger.add(transferOp);
                    break;
                case DELETE:
                    DeleteOp deleteOp = (DeleteOp) operation;
                    deleteAccount(deleteOp.getAccount());
                    ledger.add(deleteOp);
                    break;
            }
        } catch (ServerUserException e) {
            logger.warn(String.format("Error while processing operation (%s): %s", operation.getType().label, e.getErrorMessage()));
        }
    }

}
