package pt.tecnico.distledger.server.domain.operation;

import pt.tecnico.distledger.utils.VectorClock;

import java.util.UUID;

public class TransferOp extends Operation {
    private String destAccount;
    private int amount;

    public TransferOp(UUID id, String fromAccount, String destAccount, int amount, VectorClock prev) {
        super(id, fromAccount, prev);
        this.setType(OperationType.TRANSFER);
        this.destAccount = destAccount;
        this.amount = amount;
    }

    @Override
    public String getDestAccount() {
        return destAccount;
    }

    public int getAmount() {
        return amount;
    }
}
