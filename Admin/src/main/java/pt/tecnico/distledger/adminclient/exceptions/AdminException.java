package pt.tecnico.distledger.adminclient.exceptions;

public class AdminException extends RuntimeException {

    private final ErrorMessage errorMessage;

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public AdminException(ErrorMessage errorMessage) {
        super(errorMessage.label);
        this.errorMessage = errorMessage;
    }
}
