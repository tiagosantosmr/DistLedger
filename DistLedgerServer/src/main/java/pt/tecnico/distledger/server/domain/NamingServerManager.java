package pt.tecnico.distledger.server.domain;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import pt.tecnico.distledger.contract.distledgerserver.DistLedgerCrossServerServiceGrpc;
import pt.tecnico.distledger.contract.distledgerserver.DistLedgerCrossServerServiceGrpc.*;
import pt.tecnico.distledger.contract.namingserver.*;
import pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.*;
import pt.tecnico.distledger.server.domain.exceptions.ErrorMessage;
import pt.tecnico.distledger.server.domain.exceptions.ServerAdminException;
import pt.tecnico.distledger.server.domain.exceptions.ServerUserException;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class NamingServerManager{

    private ManagedChannel channel;
    private NamingServiceGrpc.NamingServiceBlockingStub namingServerStub;
    private ConcurrentHashMap<String, DistLedgerCrossServerServiceBlockingStub> stubMap;
    private ConcurrentHashMap<String, String> addressMap;

    private final static String SERVICE_NAME = "DistLedger";

    // New hashmap between quals and address on gossip check update on Naming Server, if new or changed address, update stub

     /**
     * Naming Server constructor.
     * @param host the naming server's host.
     * @param port the naming server's port.
     */
    public NamingServerManager(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        
        namingServerStub = NamingServiceGrpc.newBlockingStub(channel);
        stubMap = new ConcurrentHashMap<>();
        addressMap = new ConcurrentHashMap<>();
    }

    public String chooseServer(List<String> serverAddresses){
        return serverAddresses.get(0);
    }

    public String getHost(String address){
        return address.split(":")[0];
    }

    public int getPort(String address){
        return Integer.parseInt(address.split(":")[1]);
    }

    public void register(String serviceName, String qualifier, String address) throws IllegalArgumentException{
        RegisterRequest request = RegisterRequest.newBuilder().setServiceName(serviceName).setQualifier(qualifier).setAddress(address).build();
        namingServerStub.register(request);
    }

    public DistLedgerCrossServerServiceBlockingStub lookup(String serviceName, String qualifier){
        DistLedgerCrossServerServiceBlockingStub stub = stubMap.get(qualifier);
        if (stub == null) {
            stub = refresh(serviceName, qualifier);
        }
        return stub;
    }

    public DistLedgerCrossServerServiceBlockingStub refresh(String serviceName, String qualifier) {
        LookupRequest request = LookupRequest.newBuilder().setServiceName(serviceName).setQualifier(qualifier).build();
        LookupResponse response= namingServerStub.lookup(request);

        String address = new String();
        switch(response.getResponseCase()) {
            case SUCCESS -> { address = response.getSuccess().getAddress(); }
            case ERROR -> { throw new ServerUserException(ErrorMessage.PROPAGATION_FAILED); }
        }
        ManagedChannel channel = connect(address);
        DistLedgerCrossServerServiceBlockingStub stub = DistLedgerCrossServerServiceGrpc.newBlockingStub(channel);
        stubMap.put(qualifier, stub);
        return stub;
    }

    public List<DistLedgerCrossServerServiceBlockingStub> getAllGossip(String serviceName){
        SubscriberResponse response = namingServerStub.getSubscribers(SubscriberRequest.newBuilder()
            .setService(serviceName)
            .build());

        switch(response.getResponseCase()) {
            case SUCCESS -> {
                response.getSuccess().getServerList().forEach(serverInfo -> {
                    String address = addressMap.get(serverInfo.getQualifier());
                    if (address == null || address != serverInfo.getAddress()) {
                        addressMap.put(serverInfo.getQualifier(), serverInfo.getAddress());
                        ManagedChannel channel = connect(serverInfo.getAddress());
                        DistLedgerCrossServerServiceBlockingStub stub = DistLedgerCrossServerServiceGrpc.newBlockingStub(channel);
                        stubMap.put(serverInfo.getAddress(), stub);
                    }
                });
                return new ArrayList<>(stubMap.values());
            }
            case ERROR -> throw new ServerAdminException(ErrorMessage.UNABLE_TO_CONNECT_TO_NAMING_SERVER);
            default -> throw new ServerAdminException(ErrorMessage.UNEXPECTED_ERROR);
        }
    }

    public void delete(String qualifier){
        DeleteRequest request = DeleteRequest.newBuilder().setServiceName(SERVICE_NAME).setQualifier(qualifier).build();
        namingServerStub.delete(request);
    }

    public void shutdown(String qualifier) {
        this.delete(qualifier);
        channel.shutdown();
    }

    

    public ManagedChannel connect(String address){
        String host = getHost(address);
        int port = getPort(address);
        return ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
    }

}