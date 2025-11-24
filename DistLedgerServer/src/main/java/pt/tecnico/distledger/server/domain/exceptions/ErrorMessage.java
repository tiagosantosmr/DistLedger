package pt.tecnico.distledger.server.domain.exceptions;

public enum ErrorMessage {
    THREAD_INTERRUPTED("The thread was interrupted."),
    SERVER_IS_UNAVAILABLE("The server is unavailable."),
    ACCOUNT_DOES_NOT_EXIST("The account %s does not exist."),
    ACCOUNT_ALREADY_EXISTS("The account %s already exists."),
    DELETE_BALANCE_IS_NOT_ZERO("The balance of account %s is not zero, and thus cannot be deleted. Balance: %d."),
    TRANSACTION_INVALID_AMOUNT("The amount requested to transaction is non-positive. Amount: %d."),
    TRANSACTION_SENDER_IS_THE_SAME_AS_RECEIVER("The transaction sender %s is the same as the receiver."),
    TRANSACTION_INSUFFICIENT_BALANCE("The balance of the account %s is insufficient. Balance: %d, Needed: %d."),
    SERVER_IS_ALREADY_ACTIVE("The server is already active."),
    SERVER_IS_ALREADY_INACTIVE("The server is already deactivated."),
    WRITE_NOT_ALLOWED("The server is secondary, and as such, no write operations are allowed"),
    UNABLE_TO_CONNECT_TO_NAMING_SERVER("Unable to connect to naming server"),
    PROPAGATION_FAILED("Unable to propagate changes to secondary server"),
    UNEXPECTED_ERROR("An unexpected error occurred");

    public final String label;

    ErrorMessage(String label) { this.label = label; }
}
