package pt.tecnico.distledger.userclient;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

import pt.tecnico.UserNamingServerManager;
import pt.tecnico.distledger.userclient.grpc.UserService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserClientMain {
    
    private static final boolean DEBUG_FLAG = (System.getProperty("debug") != null);

    private static final Logger logger = LogManager.getLogger("GLOBAL");

    private static UserNamingServerManager namingServer;

    private final static String host = "localhost";

    private final static int port = 5001;

    
    public static void main(String[] args) {

        if(DEBUG_FLAG){ Configurator.setAllLevels(LogManager.getRootLogger().getName(), Level.INFO); }

        namingServer = new UserNamingServerManager(host, port);

        logger.info("Creating stub ...");

        CommandParser parser = new CommandParser(new UserService(namingServer));
        parser.parseInput();

    }
}
