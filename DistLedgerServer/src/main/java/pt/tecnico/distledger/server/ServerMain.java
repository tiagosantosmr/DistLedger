package pt.tecnico.distledger.server;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import pt.tecnico.distledger.server.domain.ReplicaManager;
import pt.tecnico.distledger.server.domain.ServerState;
import pt.tecnico.distledger.server.services.AdminServiceImpl;
import pt.tecnico.distledger.server.services.CrossServerServiceImpl;
import pt.tecnico.distledger.server.services.PrimaryUserServiceImpl;
import pt.tecnico.distledger.server.domain.NamingServerManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import org.apache.logging.log4j.Level;
import pt.tecnico.distledger.server.services.SecondaryUserServiceImpl;

public class ServerMain {
    // Server info
    private static int port;
    private static String qual;

    // Service name
    private static final String SERVICE_NAME = "DistLedger";

    // Naming Server info
    private static final String NAMING_HOSTNAME = "localhost";
    private static final int NAMING_PORT_NUMBER = 5001;

    /** Set flag to true to print debug messages.
     * The flag can be set using the -Ddebug command line option. */
    private static final boolean DEBUG_FLAG = (System.getProperty("debug") != null);

    /** Set flag to true to start server as a secondary server.
     * The flag can be set using the -Dsecondary command line option. */
    private static final boolean SECONDARY_FLAG = (System.getProperty("secondary") != null);

    private static final Logger logger = LogManager.getLogger("GLOBAL");

    private static void print_usage() {
        logger.info("INIT. Printing usage...");
        System.out.println("Usage: mvn exec:java [-Dexec.args='port qual'] [-Ddebug] [-Dsecondary]" + System.lineSeparator() +
                           "\tport: port number on which to run the server (integer between 1024 and 49151)." + System.lineSeparator() +
                           "\tqual: server qualifier. Defaults to 'A'.");
    }

    private static String buildAddress(int port){
        return "localhost:" + Integer.toString(port);
    }

    public static void main(String[] args) {
        if(DEBUG_FLAG) {
            Configurator.setAllLevels(LogManager.getRootLogger().getName(), Level.INFO);
        }

        if(args.length != 2) {
            logger.error("INIT. Incorrect number of arguments.");
            print_usage();
            logger.info("Exiting...");
            return;
        }

        try {
             port = Integer.valueOf(args[0]);
             if (port < 1024 || port > 49151) {
                 throw new NumberFormatException();
             }
        } catch (NumberFormatException e) {
            logger.error("INIT. Invalid port (must be an integer between 1024 and 49151).");
            print_usage();
            logger.info("Exiting...");
            return;
        }

        NamingServerManager nsManager = new NamingServerManager(NAMING_HOSTNAME, NAMING_PORT_NUMBER);

        qual = args[1];

        nsManager.register(SERVICE_NAME, qual, buildAddress(port));

        logger.info(String.format("INIT. Server started with arguments: port=%d qualifier=%s.", port, qual));
        ServerState state = new ServerState(qual);

        ReplicaManager replicaManager = new ReplicaManager(state);

        final BindableService impl1 = new AdminServiceImpl(state, nsManager, replicaManager);
        final BindableService impl2 = SECONDARY_FLAG ?
                new SecondaryUserServiceImpl(state, nsManager) :
                new PrimaryUserServiceImpl(state, nsManager, replicaManager);
        final BindableService impl3 = new CrossServerServiceImpl(state, replicaManager);
        
        ServerBuilder serverBuilder = ServerBuilder.forPort(port)
                .addService(impl1)
                .addService(impl2)
                .addService(impl3);
        Server server = serverBuilder.build();

        try {
            // start the server
            server.start();

            // reads from stdin until a newline is read
            System.out.println("Press Enter to stop the server...");
            System.in.read();

            // shut down the server
            server.shutdownNow();
            server.awaitTermination();

            // unregister the server from the naming server and close the connection
            nsManager.delete(qual);
            nsManager.shutdown(qual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
