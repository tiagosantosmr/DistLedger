package pt.tecnico.distledger.adminclient.grpc;

import io.grpc.ManagedChannel;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pt.tecnico.distledger.adminclient.AdminNamingServerManager;
import pt.tecnico.distledger.adminclient.exceptions.AdminException;
import pt.tecnico.distledger.contract.DistLedgerCommonDefinitions;
import pt.tecnico.distledger.contract.admin.AdminDistLedger;
import pt.tecnico.distledger.contract.admin.AdminServiceGrpc;
import pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipRequest;
import pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipResponse;
import pt.tecnico.distledger.contract.admin.AdminServiceGrpc.AdminServiceBlockingStub;

import pt.tecnico.distledger.contract.namingserver.NamingServiceGrpc;


// TODO: As funções devem retornar uma resposta grpc, e a parte da lógica de depois mostrar o output no terminal + logging
// devem ficar no CommandParser
public class AdminService {

    /* TODO: The gRPC client-side logic should be here.
        This should include a method that builds a channel and stub,
        as well as individual methods for each remote operation of this service. */

    private static final Logger logger = LogManager.getLogger("GLOBAL");

    private static final String SERVICE_NAME = "DistLedger";

    private AdminNamingServerManager namingServerManager;

    public AdminService(AdminNamingServerManager namingServer){
        this.namingServerManager = namingServer;
    }

    public AdminNamingServerManager getAdminNamingServer(){
        return this.namingServerManager;
    }

    public String activate(String qual){
        AdminServiceGrpc.AdminServiceBlockingStub stub;
        try {
            stub = namingServerManager.lookup(qual);
        } catch (AdminException exception) {
            return exception.getMessage();
        }
        AdminDistLedger.ActivateRequest request = AdminDistLedger.ActivateRequest.newBuilder().build();
        AdminDistLedger.ActivateResponse response = stub.activate(request);
        switch(response.getResponseCase()){
            case SUCCESS -> {
                return "Operation Successful.";
            }
            case ERROR -> {
                return "Ledger already active.";
            }
            default ->{
                return "Unknown error.";
            }
        }
    }

    public String deactivate(String qual) {
        AdminServiceGrpc.AdminServiceBlockingStub stub;
        try {
            stub = namingServerManager.lookup(qual);
        } catch (AdminException exception) {
            return exception.getMessage();
        }
        AdminDistLedger.DeactivateRequest request = AdminDistLedger.DeactivateRequest.newBuilder().build();
        AdminDistLedger.DeactivateResponse response = stub.deactivate(request);
        switch(response.getResponseCase()){
            case SUCCESS -> {
                return "Operation Successful.";
            }
            case ERROR -> {
                return "Ledger already inactive.";
            }
            default ->{
                return "Unknown error.";
            }
        }
    }
    
    public String dump(String qual) {
        AdminServiceGrpc.AdminServiceBlockingStub stub;
        try {
            stub = namingServerManager.lookup(qual);
        } catch (AdminException exception) {
            return exception.getMessage();
        }
        AdminDistLedger.getLedgerStateRequest request = AdminDistLedger.getLedgerStateRequest.newBuilder().build();
        AdminDistLedger.getLedgerStateResponse response = stub.getLedgerState(request);
        String output = "ledgerState {\n";
        output.concat(response.getLedgerState().getLedgerList().stream().map(AdminService::opToString).collect(Collectors.joining()));
        return output + "}";
    }

    public String gossip(String server){
        AdminServiceGrpc.AdminServiceBlockingStub stub;
        try {
            stub = namingServerManager.lookup(server);
        } catch (AdminException exception) {
            return exception.getMessage();
        }
        GossipRequest request = GossipRequest.newBuilder().build();
        GossipResponse response = stub.gossip(request);
        switch(response.getResponseCase()){
            case SUCCESS -> {
                return "Operation Successful.";
            }
            case ERROR -> {
                return "Ledger already active.";
            }
            default ->{
                return "Unknown error.";
            }
        }
    }

    public static String opToString(DistLedgerCommonDefinitions.Operation op){
        return "\tledger {\n" +
                "\t\ttype: " + op.getType() + "\n" +
                switch(op.getType()){
                    case OP_CREATE_ACCOUNT, OP_DELETE_ACCOUNT -> "\t\tuserId: \"" + op.getUserId() + "\"";
                    case OP_TRANSFER_TO -> "\t\tuserId: \"" + op.getUserId() + "\"\n" +
                            "\t\tdestUserId: \"" + op.getDestUserId() + "\"\n" +
                            "\t\tamount: " + op.getAmount();
                    case OP_UNSPECIFIED, UNRECOGNIZED -> ""; //placeholder
                } + "\n\t}";
    }
}