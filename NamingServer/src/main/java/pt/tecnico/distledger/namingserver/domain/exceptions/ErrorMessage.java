package pt.tecnico.distledger.namingserver.domain.exceptions;

public enum ErrorMessage {
    INEXISTENT_SERVICE("The service %s is not registered."),
    INEXISTENT_SERVER("The server with qualifier %s for the service %s is not registered.");

    public final String label;

    ErrorMessage(String label) { this.label = label; }
}
