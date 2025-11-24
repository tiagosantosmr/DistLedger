package pt.tecnico.distledger.server.domain.exceptions;

public class ServerException extends RuntimeException {

    private final ErrorMessage errorMessage;

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public ServerException(ErrorMessage errorMessage) {
        super(errorMessage.label);
        this.errorMessage = errorMessage;
    }

    public ServerException(ErrorMessage errorMessage, String value) {
        super(String.format(errorMessage.label, value));
        this.errorMessage = errorMessage;
    }

    public ServerException(ErrorMessage errorMessage, Integer value) {
        super(String.format(errorMessage.label, value));
        this.errorMessage = errorMessage;
    }

    public ServerException(ErrorMessage errorMessage, String value1, Integer value2) {
        super(String.format(errorMessage.label, value1, value2));
        this.errorMessage = errorMessage;
    }

    public ServerException(ErrorMessage errorMessage, String value1, Integer value2, Integer value3) {
        super(String.format(errorMessage.label, value1, value2, value3));
        this.errorMessage = errorMessage;
    }
}
