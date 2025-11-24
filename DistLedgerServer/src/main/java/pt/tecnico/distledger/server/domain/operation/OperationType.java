package pt.tecnico.distledger.server.domain.operation;

public enum OperationType {
    CREATE("Create"),
    DELETE("Delete"),
    TRANSFER("TransferTo");

    public final String label;

    OperationType(String label) {this.label = label;}

}
