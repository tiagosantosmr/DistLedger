package pt.tecnico.distledger.server.domain.exceptions;

import pt.tecnico.distledger.utils.VectorClock;

public class ServerUserException extends ServerException {
    private String account;
    private Integer balance;
    private Integer requested;
    private VectorClock newTS;

    public String getAccount() {
        return account;
    }

    public Integer getBalance() {
        return balance;
    }

    public Integer getRequested() {
        return requested;
    }

    public VectorClock getNewTS() { return newTS; }

    public ServerUserException(ErrorMessage errorMessage) { super(errorMessage); }

    public ServerUserException(ErrorMessage errorMessage, String account) {
        super(errorMessage, account);
        this.account = account;
    }

    public ServerUserException(ErrorMessage errorMessage, String account, VectorClock ts) {
        super(errorMessage, account);
        this.newTS = ts;
    }

    public ServerUserException(ErrorMessage errorMessage, Integer requested) {
        super(errorMessage, requested);
        this.requested = requested;
    }

    public ServerUserException(ErrorMessage errorMessage, String account, Integer balance) {
        super(errorMessage, account, balance);
        this.account = account;
        this.balance = balance;
    }

    public ServerUserException(ErrorMessage errorMessage, String account, Integer balance, Integer requested) {
        super(errorMessage, account, balance, requested);
        this.account = account;
        this.balance = balance;
        this.requested = requested;
    }
}
