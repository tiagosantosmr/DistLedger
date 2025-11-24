package pt.tecnico.distledger.userclient;

import pt.tecnico.distledger.userclient.grpc.UserService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;



public class CommandParser {

    private static final String SPACE = " ";
    private static final String CREATE_ACCOUNT = "createAccount";
    private static final String DELETE_ACCOUNT = "deleteAccount";
    private static final String TRANSFER_TO = "transferTo";
    private static final String BALANCE = "balance";
    private static final String HELP = "help";
    private static final String EXIT = "exit";

    private final UserService userService;

    // Set flag to true to print debug messages
    private static final boolean DEBUG_FLAG = (System.getProperty("debug") != null);

    private static final Logger logger = LogManager.getLogger("GLOBAL");


    public CommandParser(UserService userService) {
        this.userService = userService;
    }

    void parseInput() {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.print("> ");
            String line = scanner.nextLine().trim();
            String cmd = line.split(SPACE)[0];

            try{
                switch (cmd) {
                    case CREATE_ACCOUNT:
                        this.createAccount(line);
                        break;

                    case DELETE_ACCOUNT:
                        this.deleteAccount(line);
                        break;

                    case TRANSFER_TO:
                        this.transferTo(line);
                        break;

                    case BALANCE:
                        this.balance(line);
                        break;

                    case HELP:
                        this.printUsage();
                        break;

                    case EXIT:
                        exit = true;
                        this.exit();
                        scanner.close();
                        break;

                    default:
                        break;
                }
            }
            catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }

    private void createAccount(String line){
        String[] split = line.split(SPACE);

        if (split.length != 3){
            this.printUsage();
            return;
        }

        String qual = split[1];
        String username = split[2];

        logger.info("Creating account: " + username);
        userService.createAccount(username, qual);
    
    }

    private void deleteAccount(String line){
        String[] split = line.split(SPACE);

        if (split.length != 3){
            this.printUsage();
            return;
        }
        String qual = split[1];
        String username = split[2];

        logger.info("Deleting account: " + username);
        userService.deleteAccount(username, qual);

    }


    private void balance(String line){
        String[] split = line.split(SPACE);

        if (split.length != 3){
            this.printUsage();
            return;
        }
        String qual = split[1];
        String username = split[2];

        logger.info("Checking balance of account: " + username);
        userService.balance(username, qual);

    }

    private void transferTo(String line){
        String[] split = line.split(SPACE);

        if (split.length != 5){
            this.printUsage();
            return;
        }
        String qual = split[1];
        String from = split[2];
        String dest = split[3];
        Integer amount = Integer.valueOf(split[4]);

        logger.info("Transferring " + amount + " from " + from + " to " + dest);
        userService.transferTo(from, dest, amount, qual);
  
    }

    private void exit(){
        userService.getNamingServer().shutdown();
    }

    private void printUsage() {
        System.out.println("Usage:\n" +
                        "- createAccount <qual> <username>\n" +
                        "- deleteAccount <qual> <username>\n" +
                        "- balance <qual> <username>\n" +
                        "- transferTo <qual> <username_from> <username_to> <amount>\n" +
                        "- exit\n");
    }
}
