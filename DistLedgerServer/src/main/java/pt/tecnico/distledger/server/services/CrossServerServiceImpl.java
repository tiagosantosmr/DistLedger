package pt.tecnico.distledger.server.services;

import io.grpc.stub.StreamObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger;
import pt.tecnico.distledger.utils.VectorClock;
import pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.*;
import pt.tecnico.distledger.contract.distledgerserver.DistLedgerCrossServerServiceGrpc;
import pt.tecnico.distledger.server.domain.ReplicaManager;
import pt.tecnico.distledger.server.domain.ServerState;
import pt.tecnico.distledger.server.domain.LogRecord;
import pt.tecnico.distledger.server.domain.operation.CreateOp;
import pt.tecnico.distledger.server.domain.operation.DeleteOp;
import pt.tecnico.distledger.server.domain.operation.TransferOp;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CrossServerServiceImpl extends DistLedgerCrossServerServiceGrpc.DistLedgerCrossServerServiceImplBase {
    private ServerState state;
    private ReplicaManager replicaManager;

    public ServerState getServerState() { return state; }
    public void setServerState(ServerState state) { this.state = state; }

    private static final Logger logger = LogManager.getLogger("GLOBAL");

    public CrossServerServiceImpl(ServerState state, ReplicaManager replicaManager) {
        this.state = state;
        this.replicaManager = replicaManager;
    }

    @Override
    public void gossip(GossipRequest request, StreamObserver<GossipResponse> responseObserver) {
        try{
        List<LogRecord> newLog = request.getLog().getRecordList()
                .stream().map(record -> {
                    return new LogRecord(
                            record.getReplicaManagerNumber(),
                            switch (record.getOperation().getType()) {
                                case OP_UNSPECIFIED, UNRECOGNIZED:
                                    yield null;
                                case OP_TRANSFER_TO:
                                    yield new TransferOp(
                                            UUID.fromString(record.getOperation().getId()),
                                            record.getOperation().getUserId(),
                                            record.getOperation().getDestUserId(),
                                            record.getOperation().getAmount(),
                                            new VectorClock(record.getOperation().getTimestamp().getValueList())
                                    );
                                case OP_CREATE_ACCOUNT:
                                    yield new CreateOp(
                                            UUID.fromString(record.getOperation().getId()),
                                            record.getOperation().getUserId(),
                                            new VectorClock(record.getOperation().getTimestamp().getValueList())
                                    );
                                case OP_DELETE_ACCOUNT:
                                    yield new DeleteOp(
                                            UUID.fromString(record.getOperation().getId()),
                                            record.getOperation().getUserId(),
                                            new VectorClock(record.getOperation().getTimestamp().getValueList())
                                    );
                            },
                            new VectorClock(record.getNewTSList())
                    );
                })
                .collect(Collectors.toList());
        replicaManager.processGossip(newLog, new VectorClock(request.getReplicaTSList()));
        
        GossipResponse response = GossipResponse.newBuilder()
                .setSuccess(SuccessGossipResponse.newBuilder().build())
                .build();
        
        responseObserver.onNext(response);

        } catch (Exception e) { // Missing specific exceptions
            // Log the exception for debugging purposes
            logger.error("Exception in gossip", e);

            ErrorResponse errorResponse = ErrorResponse.newBuilder()
                    .setErrorCode(ErrorCode.UNAVAILABLE)
                    .build();

            GossipResponse errorPropagateStateResponse = GossipResponse.newBuilder()
                    .setError(errorResponse)
                    .build();

            responseObserver.onNext(errorPropagateStateResponse);
        } finally {
            responseObserver.onCompleted();
        }
    }
}
