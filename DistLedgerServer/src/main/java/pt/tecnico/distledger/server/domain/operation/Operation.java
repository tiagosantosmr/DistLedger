package pt.tecnico.distledger.server.domain.operation;

import pt.tecnico.distledger.utils.VectorClock;

import java.util.List;
import java.util.UUID;

public class Operation {
    private String account;

    private OperationType type;

    private UUID id;

    private VectorClock valueTimestamp;

    public UUID getId() { return id; }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public VectorClock getValueTimestamp() {
        return valueTimestamp;
    }

    public void setValueTimestamp(VectorClock valueTimestamp) {
        this.valueTimestamp = valueTimestamp;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDestAccount() { return ""; }

    public int getAmount() { return 0; }

    public Operation(UUID id, String fromAccount, VectorClock prev) {
        this.id = id;
        this.account = fromAccount;
        this.valueTimestamp = prev;
    }
}
