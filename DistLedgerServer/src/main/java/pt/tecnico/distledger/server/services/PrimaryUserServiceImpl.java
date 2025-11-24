package pt.tecnico.distledger.server.services;

import io.grpc.stub.StreamObserver;

import pt.tecnico.distledger.utils.VectorClock;
import pt.tecnico.distledger.contract.DistLedgerCommonDefinitions.*;
import pt.tecnico.distledger.server.domain.NamingServerManager;
import pt.tecnico.distledger.server.domain.ReplicaManager;
import pt.tecnico.distledger.server.domain.ServerState;
import pt.tecnico.distledger.contract.user.*;
import pt.tecnico.distledger.contract.user.UserDistLedger.*;
import pt.tecnico.distledger.server.domain.exceptions.ErrorMessage;
import pt.tecnico.distledger.server.domain.exceptions.ServerUserException;
import pt.tecnico.distledger.server.domain.operation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrimaryUserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    private ServerState state;

    private static final String SERVICE_NAME = "DistLedger";
    private NamingServerManager namingServerManager;
    private ReplicaManager replicaManager;

    public ServerState getServerState() { return state; }
    public void setServerState(ServerState state) { this.state = state; }

    private static final Logger logger = LogManager.getLogger("GLOBAL");

    public PrimaryUserServiceImpl(ServerState state, NamingServerManager namingServerManager, ReplicaManager replicaManager) {
        setServerState(state);
        this.namingServerManager = namingServerManager;
        this.replicaManager = replicaManager;
    }

    public ErrorResponse buildErrorResponse(ServerUserException exception) {
        logger.warn("USER_EXCEPTION: " + exception.getMessage());
        Map<String, String> responseMetadata = new HashMap<>();

        ErrorCode errorCode = ErrorCode.UNRECOGNIZED;
        switch (exception.getErrorMessage()) {
            case SERVER_IS_UNAVAILABLE:
                errorCode = ErrorCode.UNAVAILABLE;
                break;
            case ACCOUNT_DOES_NOT_EXIST:
                errorCode = ErrorCode.NONEXISTENT_ACCOUNT;
                responseMetadata.put("newTS", exception.getNewTS().toString());
                responseMetadata.put("account", exception.getAccount());
                break;
        }

        ErrorResponse errorResponse = ErrorResponse.newBuilder()
                .setErrorCode(errorCode)
                .putAllMetadata(responseMetadata)
                .setNewTS(Timestamp.newBuilder()
                        .addAllValue(replicaManager.getValueTimestamp())
                        .build())
                .build();

        return errorResponse;
    }

    @Override
    public void balance(BalanceRequest request, StreamObserver<BalanceResponse> responseObserver) {
        BalanceResponse.Builder responseBuilder = BalanceResponse.newBuilder();
        try {
            if(!state.getActive()) {
                logger.warn(String.format("UNAVAILABLE. Received balance(%s) request. Ignoring...", request.getUserId()));
                throw new ServerUserException(ErrorMessage.SERVER_IS_UNAVAILABLE);
            }
            // The replica manager should return both the balance and the nexTS
            List<Object> response = replicaManager.balance(request.getUserId(), new VectorClock(request.getPrevTS().getValueList()));
            responseBuilder.setSuccess(SuccessBalanceResponse.newBuilder()
                    .setNewTS(Timestamp.newBuilder().addAllValue((VectorClock) response.get(0)))
                    .setValue((Integer) response.get(1))
            );
        } catch (ServerUserException exception1) {
            ErrorResponse errorResponse = buildErrorResponse(exception1);
            responseBuilder.setError(errorResponse);
        } catch (InterruptedException exception2) {
            ErrorResponse errorResponse = buildErrorResponse(new ServerUserException(ErrorMessage.THREAD_INTERRUPTED));
            responseBuilder.setError(errorResponse);
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void createAccount(CreateAccountRequest request, StreamObserver<CreateAccountResponse> responseObserver) {
        CreateAccountResponse.Builder responseBuilder = CreateAccountResponse.newBuilder();
        try {
            if (!state.getActive()) {
                logger.warn(String.format("UNAVAILABLE. Received createAccount(%s) request. Ignoring...", request.getUserId()));
                throw new ServerUserException(ErrorMessage.SERVER_IS_UNAVAILABLE);
            }
            VectorClock newTS = replicaManager.processUpdate(new CreateOp(
                    UUID.fromString(request.getId()),
                    request.getUserId(),
                    new VectorClock(request.getPrevTS().getValueList()))
            );
            responseBuilder.setSuccess(SuccessCreateAccountResponse.newBuilder()
                    .setNewTS(Timestamp.newBuilder().addAllValue(newTS).build())
                    .build());
        } catch (ServerUserException exception) { // Throw a contract exception for already existing account
            ErrorResponse errorResponse = buildErrorResponse(exception);
            responseBuilder.setError(errorResponse);
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void deleteAccount(DeleteAccountRequest request, StreamObserver<DeleteAccountResponse> responseObserver) {
        DeleteAccountResponse.Builder responseBuilder = DeleteAccountResponse.newBuilder();
        try {
            if (!state.getActive()) {
                logger.warn(String.format("UNAVAILABLE. Received createAccount(%s) request. Ignoring...", request.getUserId()));
                throw new ServerUserException(ErrorMessage.SERVER_IS_UNAVAILABLE);
            }
            VectorClock newTS = replicaManager.processUpdate(new DeleteOp(
                    UUID.fromString(request.getId()),
                    request.getUserId(),
                    new VectorClock(request.getPrevTS().getValueList()))
            );
            responseBuilder.setSuccess(SuccessDeleteAccountResponse.newBuilder()
                    .setNewTS(Timestamp.newBuilder().addAllValue(newTS).build())
                    .build());
        } catch (ServerUserException exception) { // Throw a contract exception for nonexistent account
            ErrorResponse errorResponse =  buildErrorResponse(exception);
            responseBuilder.setError(errorResponse);
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void transferTo(TransferToRequest request, StreamObserver<TransferToResponse> responseObserver) {
        TransferToResponse.Builder responseBuilder = TransferToResponse.newBuilder();
        try {
            if (!state.getActive()) {
                logger.warn(String.format("UNAVAILABLE. Received transferTo(%s, %s, %d) request. Ignoring...", request.getAccountFrom(), request.getAccountTo(), request.getAmount()));
                throw new ServerUserException(ErrorMessage.SERVER_IS_UNAVAILABLE);
            }
            VectorClock newTS = replicaManager.processUpdate(new TransferOp(
                    UUID.fromString(request.getId()),
                    request.getAccountFrom(),
                    request.getAccountTo(),
                    request.getAmount(),
                    new VectorClock(request.getPrevTS().getValueList())
            ));
            responseBuilder.setSuccess(SuccessTransferToResponse.newBuilder()
                    .setNewTS(Timestamp.newBuilder().addAllValue(newTS).build())
                    .build());
        } catch (ServerUserException exception) { // Throw a contract exception for nonexistent account
            ErrorResponse errorResponse = buildErrorResponse(exception);
            responseBuilder.setError(errorResponse);
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }
}
