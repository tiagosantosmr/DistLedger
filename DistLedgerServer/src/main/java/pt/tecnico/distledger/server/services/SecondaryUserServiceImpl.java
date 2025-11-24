package pt.tecnico.distledger.server.services;

import io.grpc.stub.StreamObserver;
import pt.tecnico.distledger.server.domain.NamingServerManager;
import pt.tecnico.distledger.server.domain.ServerState;
import pt.tecnico.distledger.contract.user.*;
import pt.tecnico.distledger.contract.user.UserDistLedger.*;
import pt.tecnico.distledger.server.domain.exceptions.ErrorMessage;
import pt.tecnico.distledger.server.domain.exceptions.ServerUserException;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SecondaryUserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    private ServerState state;

    private static final String SERVICE_NAME = "DistLedger";
    private NamingServerManager namingServerManager;

    public ServerState getServerState() { return state; }

    public void setServerState(ServerState state) { this.state = state; }

    private static final Logger logger = LogManager.getLogger("GLOBAL");

    public SecondaryUserServiceImpl(ServerState state, NamingServerManager namingServerManager) {
        setServerState(state);
        this.namingServerManager = namingServerManager;
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
                responseMetadata.put("account", exception.getAccount());
                break;
            case WRITE_NOT_ALLOWED:
                errorCode = ErrorCode.WRITE_TO_SECONDARY;
                break;
        }

        ErrorResponse errorResponse = ErrorResponse.newBuilder()
                .setErrorCode(errorCode)
                .putAllMetadata(responseMetadata)
                .build();

        return errorResponse;
    }

    @Override
    public void balance(BalanceRequest request, StreamObserver<BalanceResponse> responseObserver) {
        BalanceResponse.Builder responseBuilder = BalanceResponse.newBuilder();
        Integer balance;
        try {
            balance = state.getBalance(request.getUserId());
            responseBuilder.setSuccess(SuccessBalanceResponse.newBuilder()
                    .setValue(balance));
        } catch (ServerUserException exception) {
            ErrorResponse errorResponse = buildErrorResponse(exception);
            responseBuilder.setError(errorResponse);
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void createAccount(CreateAccountRequest request, StreamObserver<CreateAccountResponse> responseObserver) {
        CreateAccountResponse.Builder responseBuilder = CreateAccountResponse.newBuilder();
        try {
            throw new ServerUserException(ErrorMessage.WRITE_NOT_ALLOWED);
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
            throw new ServerUserException(ErrorMessage.WRITE_NOT_ALLOWED);
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
            throw new ServerUserException(ErrorMessage.WRITE_NOT_ALLOWED);
        } catch (ServerUserException exception) { // Throw a contract exception for nonexistent account
            ErrorResponse errorResponse = buildErrorResponse(exception);
            responseBuilder.setError(errorResponse);
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }
}
