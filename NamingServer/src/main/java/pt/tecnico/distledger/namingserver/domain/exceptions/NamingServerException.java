package pt.tecnico.distledger.namingserver.domain.exceptions;

public class NamingServerException extends RuntimeException {

    private final ErrorMessage errorMessage;

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public NamingServerException(ErrorMessage errorMessage, String service) {
        super(String.format(errorMessage.label, service));
        this.errorMessage = errorMessage;
    }

    public NamingServerException(ErrorMessage errorMessage, String service, String server) {
        super(String.format(errorMessage.label, service, server));
        this.errorMessage = errorMessage;
    }
}
