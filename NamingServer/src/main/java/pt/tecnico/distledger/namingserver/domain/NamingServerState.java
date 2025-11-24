package pt.tecnico.distledger.namingserver.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pt.tecnico.distledger.namingserver.domain.exceptions.ErrorMessage;
import pt.tecnico.distledger.namingserver.domain.exceptions.NamingServerException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.ArrayList;

public class NamingServerState{

    private ConcurrentHashMap<String, ServiceEntry> services;

    private static final Logger logger = LogManager.getLogger("GLOBAL");

    public NamingServerState() {
        this.services = new ConcurrentHashMap<>();
    }

    // Métodos para adicionar, remover e obter serviços

    public void addService(String serviceName) {
        services.put(serviceName, new ServiceEntry(serviceName));
        logger.info("Service added: {}", serviceName);
    }

    public void removeService(String serviceName) {
        services.remove(serviceName);
        logger.info("Service removed: {}", serviceName);
    }

    public ServiceEntry getService(String serviceName) {
        return services.get(serviceName);
    }

    public Map<String, ServiceEntry> getServices() {
        return services;
    }

    public void setServices(ConcurrentHashMap<String, ServiceEntry> services) {
        this.services = services;
    }

    // print all service name and address
    public void printServices() {
        logger.info("Printing all services:");
        for (ServiceEntry serviceEntry : services.values()) {
            for (ServerEntry serverEntry : serviceEntry.getServers().values()) {
                System.out.println("\t" + serverEntry.getAddress());
            }
        }
    }

    public void register(String serviceName, String qualifier, String address) {
        // Verificar se o serviço já existe, caso contrário, adiciona-o
        ServiceEntry serviceEntry = services.get(serviceName);
        if(serviceEntry == null) {
            addService(serviceName);
            serviceEntry = services.get(serviceName);
        }
        serviceEntry.addServer(address, qualifier);
        logger.info("Service registered: {} with qualifier: {} and address: {}", serviceName, qualifier, address);
    }

    public String lookup(String serviceName, String qualifier) {
        ServiceEntry serviceEntry = services.get(serviceName);
        if (serviceEntry == null) {
            throw new NamingServerException(ErrorMessage.INEXISTENT_SERVICE, serviceName);
        }

        ServerEntry serverEntry = serviceEntry.getServer(qualifier);
        if (serverEntry == null) {
            throw new NamingServerException(ErrorMessage.INEXISTENT_SERVER, qualifier, serviceName);
        }
        logger.info("Lookup for service: {} with qualifier: {} found address: {}", serviceName, qualifier, serverEntry.getAddress());
        return serverEntry.getAddress();
    }

    public List<ServerEntry> lookupAll(String serviceName) {
        ServiceEntry serviceEntry = services.get(serviceName);
        if (serviceEntry == null) {
            throw new NamingServerException(ErrorMessage.INEXISTENT_SERVICE, serviceName);
        }
        
        logger.info("Lookup all for service: {}", serviceName);
        return new ArrayList<ServerEntry>(serviceEntry.getServers().values());
    }

    public void delete(String serviceName, String qualifier) {
        ServiceEntry serviceEntry = services.get(serviceName);
        if (serviceEntry == null) {
            throw new NamingServerException(ErrorMessage.INEXISTENT_SERVICE, serviceName);
        }
        if (serviceEntry.getServers().remove(qualifier) == null) {
            throw new NamingServerException(ErrorMessage.INEXISTENT_SERVER, qualifier, serviceName);
        }
        logger.info("Service deleted: {} with qualifier: {}", serviceName, qualifier);
    }
}
