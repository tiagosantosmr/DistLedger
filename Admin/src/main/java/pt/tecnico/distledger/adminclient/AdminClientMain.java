package pt.tecnico.distledger.adminclient;

import pt.tecnico.distledger.adminclient.grpc.AdminService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.Level;

public class AdminClientMain {

    private static final Logger logger = LogManager.getLogger("GLOBAL");

    private static final boolean DEBUG_FLAG = (System.getProperty("debug") != null);

    private static AdminNamingServerManager namingServer;

    private final static String host = "localhost";

    private final static int port = 5001;

    public static void main(String[] args) {

        System.out.println(AdminClientMain.class.getSimpleName());

        if(DEBUG_FLAG) {
            Configurator.setAllLevels(LogManager.getRootLogger().getName(), Level.INFO);
            logger.info("Running in debug mode.");
        }
        logger.info(String.format("Connecting to:\nHost: %s, Port: %d%n", host, port));

        namingServer = new AdminNamingServerManager(host, port);
        CommandParser parser = new CommandParser(new AdminService(namingServer));
        parser.parseInput();
    }
}
