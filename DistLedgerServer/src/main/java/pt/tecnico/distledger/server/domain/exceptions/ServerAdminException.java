package pt.tecnico.distledger.server.domain.exceptions;

public class ServerAdminException extends ServerException {
    public ServerAdminException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
