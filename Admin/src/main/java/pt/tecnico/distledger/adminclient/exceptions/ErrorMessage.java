package pt.tecnico.distledger.adminclient.exceptions;

public enum ErrorMessage {
    SERVER_NOT_FOUND("Server not found.");

    public final String label;

    ErrorMessage(String label) { this.label = label; }
}
