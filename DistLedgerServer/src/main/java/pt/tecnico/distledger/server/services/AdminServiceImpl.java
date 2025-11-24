package pt.tecnico.distledger.server.services;

import io.grpc.stub.StreamObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pt.tecnico.distledger.server.domain.NamingServerManager;
import pt.tecnico.distledger.server.domain.ReplicaManager;
import pt.tecnico.distledger.server.domain.ServerState;
import pt.tecnico.distledger.contract.DistLedgerCommonDefinitions.*;
import pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger;
import pt.tecnico.distledger.contract.admin.*;
import pt.tecnico.distledger.contract.admin.AdminDistLedger.*;
import pt.tecnico.distledger.contract.distledgerserver.DistLedgerCrossServerServiceGrpc.DistLedgerCrossServerServiceBlockingStub;
import pt.tecnico.distledger.server.domain.exceptions.ServerAdminException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



public class AdminServiceImpl extends AdminServiceGrpc.AdminServiceImplBase {
    private ServerState state;
    private static final Logger logger = LogManager.getLogger("GLOBAL");

    private static final String SERVICE_NAME = "DistLedger";
    private NamingServerManager namingServerManager;
    private ReplicaManager replicaManager;

    public ServerState getServerState() { return state; }

    public void setServerState(ServerState state) { this.state = state; }

    public AdminServiceImpl(ServerState state, NamingServerManager namingServerManager, ReplicaManager replicaManager) {
        setServerState(state);
        this.namingServerManager = namingServerManager;
        this.replicaManager = replicaManager;
    }

    private ErrorResponse buildErrorResponse(ServerAdminException e) {
        logger.warn("ADMIN_EXCEPTION: " + e.getMessage());
        Map<String, String> responseMetadata = new HashMap<>();

        ErrorCode errorCode = ErrorCode.UNRECOGNIZED;
        switch (e.getErrorMessage()) {
            case SERVER_IS_ALREADY_ACTIVE:
                errorCode = ErrorCode.ALREADY_ACTIVATED;
                break;
            case SERVER_IS_ALREADY_INACTIVE:
                errorCode = ErrorCode.ALREADY_DEACTIVATED;
                break;
        }

        ErrorResponse errorResponse = ErrorResponse.newBuilder()
                .setErrorCode(errorCode)
                .putAllMetadata(responseMetadata)
                .build();

        return errorResponse;
    }

    @Override
    public void activate(ActivateRequest request, StreamObserver<ActivateResponse> responseObserver) {
        ActivateResponse.Builder responseBuilder = ActivateResponse.newBuilder();
        try {
            state.activate();
            responseBuilder.setSuccess(SuccessActivateResponse.newBuilder()
                    .build());
        } catch (ServerAdminException exception) {
            ErrorResponse errorResponse = buildErrorResponse(exception);
            responseBuilder.setError(errorResponse);
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void deactivate(DeactivateRequest request, StreamObserver<DeactivateResponse> responseObserver) {
        DeactivateResponse.Builder responseBuilder = DeactivateResponse.newBuilder();
        try {
            state.deactivate();
            responseBuilder.setSuccess(SuccessDeactivateResponse.newBuilder()
                    .build());
        } catch (ServerAdminException exception) {
            ErrorResponse errorResponse = buildErrorResponse(exception);
            responseBuilder.setError(errorResponse);
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    private Operation buildOperationMessage(pt.tecnico.distledger.server.domain.operation.Operation operation) {
        return Operation.newBuilder()
                .setId(operation.getId().toString())
                .setTimestamp(Timestamp.newBuilder()
                        .addAllValue(operation.getValueTimestamp())
                        .build())
                .setType(switch(operation.getType()){
                    case CREATE -> OperationType.OP_CREATE_ACCOUNT;
                    case DELETE -> OperationType.OP_DELETE_ACCOUNT;
                    case TRANSFER -> OperationType.OP_TRANSFER_TO;
                })
                .setUserId(operation.getAccount())
                .setDestUserId(operation.getDestAccount())
                .setAmount(operation.getAmount())
                .build();
    }

    private LogRecord buildRecordMessage(pt.tecnico.distledger.server.domain.LogRecord record) {
        return LogRecord.newBuilder()
                .setReplicaManagerNumber(state.getQualifierInt())
                .addAllNewTS(replicaManager.getValueTimestamp())
                .setOperation(buildOperationMessage(record.getOperation()))
                .build();
    }

    @Override
    public void gossip(GossipRequest request, StreamObserver<GossipResponse> responseObserver) {
        // Replica Manager get updateLog
        List<pt.tecnico.distledger.server.domain.LogRecord> updateLog = replicaManager.getUpdateLog();

        // Naming Server get subscribers (stubs)
        List<DistLedgerCrossServerServiceBlockingStub> stubs = namingServerManager.getAllGossip(SERVICE_NAME);

        // Send gossip to each subscriber
        for (DistLedgerCrossServerServiceBlockingStub stub : stubs) {
            try {
                replicaManager.getLock().lock();
                CrossServerDistLedger.GossipRequest newRequest = CrossServerDistLedger.GossipRequest
                        .newBuilder()
                        .setLog(UpdateLog
                                .newBuilder()
                                .addAllRecord(replicaManager.getUpdateLog().stream()
                                        .map(this::buildRecordMessage)
                                        .collect(Collectors.toList()))
                                .build())
                        .addAllReplicaTS(replicaManager.getValueTimestamp())
                        .build();
                replicaManager.getLock().unlock();
                CrossServerDistLedger.GossipResponse gossipResponse = stub.gossip(newRequest);
            } catch (RuntimeException e) {
                // Handle the exception, e.g., retry or log the error
                // For example, you can use the following code to log the error message:
                logger.error("Error sending gossip to subscriber: {}", e.getMessage());
            }
        }

        GossipResponse response = GossipResponse.newBuilder()
                .setSuccess(SuccessGossipResponse.newBuilder().build())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void getLedgerState(getLedgerStateRequest request, StreamObserver<getLedgerStateResponse> responseObserver) {
        List<pt.tecnico.distledger.server.domain.operation.Operation> ledger = state.getLedger();
        LedgerState ledgerState;
        synchronized (ledger) {
            ledgerState = LedgerState.newBuilder()
                    .addAllLedger(ledger.stream().map(op ->
                            switch (op.getType()) {
                                case CREATE:
                                    System.out.println("OP_CREATE_ACCOUNT: " + op.getAccount() + " " + op.getValueTimestamp() + " " + op.getId().toString());
                                    yield Operation.newBuilder()
                                            .setId(op.getId().toString())
                                            .setType(OperationType.OP_CREATE_ACCOUNT)
                                            .setUserId(op.getAccount())
                                            .setTimestamp(Timestamp.newBuilder()
                                                    .addAllValue(op.getValueTimestamp())
                                                    .build())
                                            .build();
                                case DELETE:
                                    yield Operation.newBuilder()
                                            .setId(op.getId().toString())
                                            .setType(OperationType.OP_DELETE_ACCOUNT)
                                            .setUserId(op.getAccount())
                                            .setTimestamp(Timestamp.newBuilder()
                                                    .addAllValue(op.getValueTimestamp())
                                                    .build())
                                            .build();
                                case TRANSFER:
                                    yield Operation.newBuilder()
                                            .setId(op.getId().toString())
                                            .setType(OperationType.OP_TRANSFER_TO)
                                            .setUserId(op.getAccount())
                                            .setDestUserId(op.getDestAccount())
                                            .setAmount(op.getAmount())
                                            .setTimestamp(Timestamp.newBuilder()
                                                    .addAllValue(op.getValueTimestamp())
                                                    .build())
                                            .build();
                            }).collect(Collectors.toList()))
                    .build();
        }
        getLedgerStateResponse response = getLedgerStateResponse.newBuilder()
                .setLedgerState(ledgerState)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
