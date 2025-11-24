package pt.tecnico.distledger.userclient.grpc;

import pt.tecnico.UserNamingServerManager;
import pt.tecnico.distledger.contract.DistLedgerCommonDefinitions.*;
import pt.tecnico.distledger.contract.user.UserServiceGrpc;
import pt.tecnico.distledger.contract.user.UserDistLedger.*;
import pt.tecnico.distledger.utils.VectorClock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// É preciso mudar a estructura. Tudo o que é gRPC, devia estar aqui, enquanto que o tratamento da resposta devia estar
// no CommandParser? -> Perguntar ao professor
public class UserService extends UserServiceGrpc.UserServiceImplBase{

    private static final Logger logger = LogManager.getLogger("GLOBAL");

    private static final String SERVICE_NAME = "DistLedger";

    private VectorClock timeStamp;

    private UserNamingServerManager namingServer;
    
    public UserService(UserNamingServerManager namingServer) { 
        this.namingServer = namingServer;
        timeStamp = new VectorClock(Collections.nCopies(3, 0));
    }

    public UserNamingServerManager getNamingServer(){
        return this.namingServer;
    }

    
    public void balance(String account, String qual) {
        try{
            UserServiceGrpc.UserServiceBlockingStub stub = namingServer.lookup(qual);
            BalanceRequest request;
            try{
                request = BalanceRequest.newBuilder()
                    .setPrevTS(Timestamp.newBuilder()
                        .addAllValue(timeStamp)
                        .build())
                    .setUserId(account)
                    .build();
                BalanceResponse response = stub.balance(request);
                switch(response.getResponseCase()) {
                    case SUCCESS -> {
                        System.out.println(response.getSuccess().getValue());
                        timeStamp.merge(new VectorClock(response.getSuccess().getNewTS().getValueList()));
                        logger.info("New Timestamp: " + timeStamp);
                    }
                    case ERROR -> {
                        switch (response.getError().getErrorCode()) {
                            case NONEXISTENT_ACCOUNT -> {
                                System.out.println("User does not exist");
                                timeStamp.merge(VectorClock.fromString(response.getError().getMetadataMap().get("newTs")));
                                logger.info("New Timestamp: " + timeStamp);
                            }
                            case UNAVAILABLE -> {
                                System.out.println("Server is unavailable.");
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("Error connecting to server: " + stub.getChannel().authority());
                try {
                    namingServer.refresh(qual);
                } catch (Exception ex) {
                    System.out.println("Server with qualifier " + qual + " not registered");
                }
            }
        } catch(Exception e) {
            System.out.println("Server with qualifier " + qual + " not registered");
        }
    }


    public void createAccount(String account, String qual) {
        try{
            UserServiceGrpc.UserServiceBlockingStub stub = namingServer.lookup(qual);
            CreateAccountRequest request;
            try{
                request = CreateAccountRequest.newBuilder()
                    .setId(UUID.randomUUID().toString())
                    .setPrevTS(Timestamp.newBuilder()
                        .addAllValue(timeStamp)
                        .build())
                    .setUserId(account)
                    .build();
                CreateAccountResponse response = stub.createAccount(request);
                switch (response.getResponseCase()) {
                    case SUCCESS -> {
                        System.out.println("Create operation registered");
                        timeStamp.merge(new VectorClock(response.getSuccess().getNewTS().getValueList()));
                        logger.info("New Timestamp: " + timeStamp);
                    }
                    case ERROR -> {
                        switch (response.getError().getErrorCode()) {
                            case UNAVAILABLE -> System.out.println("Server is unavailable"); // change server
                        }
                    }
                }
            } catch (Exception e) {
                logger.error("Error connecting to server: " + stub.getChannel().authority());
                try {
                    namingServer.refresh(qual);
                } catch (Exception ex) {
                    System.out.println("Server with qualifier " + qual + " not registered");
                }
            }
        } catch(Exception e) {
            System.out.println("Server with qualifier " + qual + " not registered");
        }
    }

    public void deleteAccount(String account, String qual) {
        try{
            UserServiceGrpc.UserServiceBlockingStub stub = namingServer.lookup(qual);
            DeleteAccountRequest request;
            try{
                request = DeleteAccountRequest.newBuilder()
                    .setId(UUID.randomUUID().toString())
                    .setPrevTS(Timestamp.newBuilder()
                        .addAllValue(timeStamp)
                        .build())
                    .setUserId(account)
                    .build();
                DeleteAccountResponse response = stub.deleteAccount(request);
                switch (response.getResponseCase()) {
                    case SUCCESS -> {
                        System.out.println("Delete operation registered");
                        timeStamp.merge(new VectorClock(response.getSuccess().getNewTS().getValueList()));
                        logger.info("New Timestamp: " + timeStamp);
                    }
                    case ERROR -> {
                        switch (response.getError().getErrorCode()) {
                            case UNAVAILABLE -> System.out.println("Server is unavailable");
                        }
                    }
                }
            } catch (Exception e) {
                logger.error("Error connecting to server: " + stub.getChannel().authority());
                try {
                    namingServer.refresh(qual);
                } catch (Exception ex) { // TODO: Mudar por exceção de dominio
                    System.out.println("Server with qualifier " + qual + " not registered");
                }
            }
        } catch(Exception e) {
            System.out.println("Server with qualifier " + qual + " not registered");
        }
    }


    public void transferTo(String from, String to, int value, String qual) {
        try{
            UserServiceGrpc.UserServiceBlockingStub stub = namingServer.lookup(qual);
            TransferToRequest request;
            try{
                request = TransferToRequest.newBuilder()
                    .setId(UUID.randomUUID().toString())
                    .setPrevTS(Timestamp.newBuilder()
                        .addAllValue(timeStamp)
                        .build())
                    .setAccountFrom(from)
                    .setAccountTo(to)
                    .setAmount(value)
                    .build();
                TransferToResponse response = stub.transferTo(request);
                switch (response.getResponseCase()){
                    case SUCCESS -> {
                        System.out.println("Transfer operation registered");
                        timeStamp.merge(new VectorClock(response.getSuccess().getNewTS().getValueList()));
                        logger.info("New Timestamp: " + timeStamp);
                    }
                    case ERROR -> {
                        switch (response.getError().getErrorCode()) {
                            case UNAVAILABLE -> System.out.println("Server is unavailable");
                        }
                    }
                }
            } catch (Exception e) {
                logger.error("Error connecting to server: " + stub.getChannel().authority());
                try {
                    namingServer.refresh(qual);
                } catch (Exception ex) {
                    System.out.println("Server with qualifier " + qual + " not registered");
                }
            }
        } catch(Exception e) {
            System.out.println("Server with qualifier " + qual + " not registered");
        }
    }
}

