package pt.tecnico.distledger.namingserver;

import pt.tecnico.distledger.namingserver.domain.NamingServerState;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;



import java.io.IOException;


// Add logging and
public class NamingServer {

    private static final int port = 5001;

    private static final boolean DEBUG_FLAG = (System.getProperty("debug") != null);

    private static final Logger logger = LogManager.getLogger("GLOBAL");


    public static void main(String[] args) {

        if(DEBUG_FLAG){ Configurator.setAllLevels(LogManager.getRootLogger().getName(), Level.INFO); }

        
        NamingServerState namingServer = new NamingServerState();
        final BindableService namingServerService = new NamingServerServiceImpl(namingServer);

        Server server = ServerBuilder.forPort(port)
            .addService(namingServerService)
            .build();

        try{
            server.start();
            logger.info("Naming Server started on port " + port);
            server.awaitTermination();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
