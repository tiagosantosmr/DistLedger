package pt.tecnico.distledger.adminclient;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import pt.tecnico.distledger.adminclient.exceptions.AdminException;
import pt.tecnico.distledger.contract.admin.AdminServiceGrpc;
import pt.tecnico.distledger.contract.admin.AdminServiceGrpc.*;
import pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.*;
import pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest;
import pt.tecnico.distledger.adminclient.exceptions.ErrorMessage;
import pt.tecnico.distledger.contract.namingserver.NamingServiceGrpc;

import java.util.HashMap;

public class AdminNamingServerManager {

    private ManagedChannel channel;
    private NamingServiceGrpc.NamingServiceBlockingStub namingServerStub;
    private HashMap<String, AdminServiceBlockingStub> stubMap;
    
    private static final String serviceName = "DistLedger";


     /**
     * Naming Server constructor.
     * @param host the naming server's host.
     * @param port the naming server's port.
     */
    public AdminNamingServerManager(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        
        namingServerStub = NamingServiceGrpc.newBlockingStub(channel);
        stubMap = new HashMap<>();
    }

    public String getHost(String address){
        return address.split(":")[0];
    }

    public int getPort(String address){
        return Integer.parseInt(address.split(":")[1]);
    }

    public AdminServiceBlockingStub lookup(String qualifier) {
        AdminServiceBlockingStub stub = stubMap.get(qualifier);
        if (stub == null) {
            stub = refresh(qualifier);
        }
        return stub;
    }

    // When a channel goes down, lookup the naming server and if a new answer is given, create new stub and update the stub map.
    public AdminServiceBlockingStub refresh(String qualifier) {
        LookupRequest request = LookupRequest.newBuilder().setServiceName(serviceName).setQualifier(qualifier).build();
        LookupResponse response= namingServerStub.lookup(request);

        String address = new String();
        switch(response.getResponseCase()) {
            case SUCCESS -> { address = response.getSuccess().getAddress(); }
            case ERROR -> { throw new AdminException(ErrorMessage.SERVER_NOT_FOUND); }
        }
        ManagedChannel channel = connect(address);
        AdminServiceBlockingStub stub = AdminServiceGrpc.newBlockingStub(channel);
        stubMap.put(qualifier, stub);
        return stub;
    }

    public void shutdown() {
        channel.shutdown();
    }

    public ManagedChannel connect(String address) {
        String host = getHost(address);
        int port = getPort(address);
        return ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
    }

}