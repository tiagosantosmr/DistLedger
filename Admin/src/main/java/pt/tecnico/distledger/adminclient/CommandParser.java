package pt.tecnico.distledger.adminclient;

import pt.tecnico.distledger.adminclient.exceptions.AdminException;
import pt.tecnico.distledger.adminclient.grpc.AdminService;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandParser {

    private static final String SPACE = " ";
    private static final String ACTIVATE = "activate";
    private static final String DEACTIVATE = "deactivate";
    private static final String GET_LEDGER_STATE = "getLedgerState";
    private static final String GOSSIP = "gossip";
    private static final String HELP = "help";
    private static final String EXIT = "exit";

    private static final Logger logger = LogManager.getLogger("GLOBAL");

    private final AdminService adminService;
    public CommandParser(AdminService adminService) {
        this.adminService = adminService;
    }
    void parseInput() {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.print("> ");
            String line = scanner.nextLine().trim();
            String cmd = line.split(SPACE)[0];

            switch (cmd) {
                case ACTIVATE:
                    this.activate(line);
                    break;

                case DEACTIVATE:
                    this.deactivate(line);
                    break;

                case GET_LEDGER_STATE:
                    this.dump(line);
                    break;

                case GOSSIP:
                    this.gossip(line);
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
    }

    private void exit(){
        adminService.getAdminNamingServer().shutdown();
    }

    private void activate(String line){
        String[] split = line.split(SPACE);

        if (split.length != 2){
            this.printUsage();
            return;
        }
        String server = split[1];
        logger.info("Activating ledger");
        try{
            System.out.println(adminService.activate(server));
        }catch (AdminException e){
            logger.error(e.getMessage());
        }catch (Exception e2){
            logger.error(e2.getStackTrace());
        }
    }

    private void deactivate(String line){
        String[] split = line.split(SPACE);

        if (split.length != 2){
            this.printUsage();
            return;
        }
        String server = split[1];

        logger.info("Deactivating ledger");
        try{
            System.out.println(adminService.deactivate(server));
        }catch (AdminException e){
            logger.error(e.getMessage());
        }catch (Exception e2){
            e2.printStackTrace();
        }
    }

    private void dump(String line){
        String[] split = line.split(SPACE);

        if (split.length != 2){
            this.printUsage();
            return;
        }
        String server = split[1];

        System.out.println(adminService.dump(server));
    }

    private void gossip(String line){
        String[] split = line.split(SPACE);

        if (split.length != 2){
            this.printUsage();
            return;
        }
        String server = split[1];

        //logger.info("Deactivating ledger");
        try{
            System.out.println(adminService.gossip(server));
        }/*catch (AdminException e){
            logger.error(e.getMessage());
        }*/catch (Exception e2){
            e2.printStackTrace();
        }
    }
    private void printUsage() {
        System.out.println("Usage:\n" +
                "- activate <server>\n" +
                "- deactivate <server>\n" +
                "- getLedgerState <server>\n" +
                "- gossip <server>\n" +
                "- exit\n");
    }

}
