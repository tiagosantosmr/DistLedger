package pt.tecnico.distledger.namingserver;

import java.util.List;
import java.util.stream.Collectors;

import io.grpc.Server;
import io.grpc.stub.StreamObserver;
import pt.tecnico.distledger.contract.DistLedgerCommonDefinitions.ServerInfo;
import pt.tecnico.distledger.contract.distledgerserver.*;
import pt.tecnico.distledger.contract.namingserver.*;
import pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.*;
import pt.tecnico.distledger.namingserver.domain.*;
import pt.tecnico.distledger.namingserver.domain.exceptions.*;


public class NamingServerServiceImpl extends NamingServiceGrpc.NamingServiceImplBase {
    private NamingServerState namingServerState;

    public NamingServerServiceImpl(NamingServerState namingServer) {
        this.namingServerState = namingServer;
    }

    @Override
    public void register(RegisterRequest request, StreamObserver<RegisterResponse> responseObserver) {
        String serviceName = request.getServiceName();
        String qualifier = request.getQualifier();
        String address = request.getAddress();
    
        RegisterResponse.Builder responseBuilder = RegisterResponse.newBuilder();

        namingServerState.register(serviceName, qualifier, address);
        responseBuilder.setSuccess(
            SuccessRegisterResponse.newBuilder()
                .setMessage("")
                .build()
        );

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void lookup(LookupRequest request, StreamObserver<LookupResponse> responseObserver) {
        String serviceName = request.getServiceName();
        String qualifier = request.getQualifier();
        LookupResponse.Builder responseBuilder = LookupResponse.newBuilder();

        String address;
        try {
            address = namingServerState.lookup(serviceName, qualifier);
            responseBuilder.setSuccess(SuccessLookupResponse.newBuilder()
                    .setAddress(address));
        } catch (NamingServerException e) {
           responseBuilder.setError(ErrorResponse.newBuilder()
                    .setErrorCode(switch (e.getErrorMessage()) {
                        case INEXISTENT_SERVICE -> ErrorCode.SERVICE_NOT_REGISTERED;
                        case INEXISTENT_SERVER -> ErrorCode.SERVER_NOT_REGISTERED;
                    }).build());
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getSubscribers(SubscriberRequest request, StreamObserver<SubscriberResponse> responseObserver){
        String serviceName = request.getService();
        SubscriberResponse.Builder responseBuilder = SubscriberResponse.newBuilder();

        try {
            List<ServerEntry> servers = namingServerState.lookupAll(serviceName);
            responseBuilder.setSuccess(SuccessSubscriberResponse.newBuilder()
                .addAllServer(servers.stream().map(server -> {
                        return ServerInfo.newBuilder()
                            .setAddress(server.getAddress())
                            .setQualifier(server.getQualifier())
                            .build();
                    }).collect(Collectors.toList())));
        } catch (NamingServerException e) {
            responseBuilder.setError(ErrorResponse.newBuilder()
                    .setErrorCode(switch (e.getErrorMessage()) {
                        case INEXISTENT_SERVICE -> ErrorCode.SERVICE_NOT_REGISTERED;
                        case INEXISTENT_SERVER -> ErrorCode.SERVER_NOT_REGISTERED;
                    }).build());
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void delete(DeleteRequest request, StreamObserver<DeleteResponse> responseObserver) {
        String serviceName = request.getServiceName();
        String qualifier = request.getQualifier();

        DeleteResponse.Builder responseBuilder = DeleteResponse.newBuilder();

        try{
            namingServerState.delete(serviceName, qualifier);
            responseBuilder.setSuccess(
                SuccessDeleteResponse.newBuilder()
                    .setMessage("")
                    .build()
            );
        } catch (NamingServerException e) {
            responseBuilder.setError(
                ErrorResponse.newBuilder()
                    .setErrorCode(switch (e.getErrorMessage()) {
                        case INEXISTENT_SERVICE -> ErrorCode.SERVICE_NOT_REGISTERED;
                        case INEXISTENT_SERVER -> ErrorCode.SERVER_NOT_REGISTERED;
                    }).build()
            );
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }
}