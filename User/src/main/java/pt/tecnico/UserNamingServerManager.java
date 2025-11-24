package pt.tecnico;

import java.util.HashMap;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger;
import pt.tecnico.distledger.contract.namingserver.NamingServiceGrpc;
import pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest;
import pt.tecnico.distledger.contract.user.UserServiceGrpc;
import pt.tecnico.distledger.contract.user.UserServiceGrpc.*;

public class UserNamingServerManager {

    private ManagedChannel channel;
    private NamingServiceGrpc.NamingServiceBlockingStub namingServerStub;
    private HashMap<String, UserServiceBlockingStub> stubMap;

    private final static String SERVICE_NAME = "DistLedger";

     /**
     * Naming Server constructor.
     * @param host the naming server's host.
     * @param port the naming server's port.
     */
    public UserNamingServerManager(String host, int port) {
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

    public UserServiceGrpc.UserServiceBlockingStub lookup(String qualifier) {
        UserServiceGrpc.UserServiceBlockingStub stub = stubMap.get(qualifier);
        if (stub == null) {
            stub = refresh(qualifier);
        }
        return stub;
    }

    // When a channel goes down, lookup the naming server and if a new answer is given, create new stub and update the stub map.
    public UserServiceGrpc.UserServiceBlockingStub refresh(String qualifier) {
        LookupRequest request = LookupRequest.newBuilder().setServiceName(SERVICE_NAME).setQualifier(qualifier).build();
        NamingServerDistLedger.LookupResponse response= namingServerStub.lookup(request);

        String address = new String();
        switch(response.getResponseCase()) {
            case SUCCESS -> { address = response.getSuccess().getAddress(); }
            case ERROR -> { throw new RuntimeException(); }
        }
        System.out.println(address);
        ManagedChannel channel = connect(address);
        UserServiceGrpc.UserServiceBlockingStub stub = UserServiceGrpc.newBlockingStub(channel);
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
