package pt.tecnico.distledger.server.domain.operation;

import pt.tecnico.distledger.utils.VectorClock;

import java.util.UUID;

public class CreateOp extends Operation {

    public CreateOp(UUID id, String account, VectorClock prev) {
        super(id, account, prev);
        this.setType(OperationType.CREATE);
    }

}
