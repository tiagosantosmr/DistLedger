package pt.tecnico.distledger.namingserver.domain;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceEntry{
    private String serviceName;
    private ConcurrentHashMap<String, ServerEntry> servers;

    public ServiceEntry(String serviceName) {
        this.serviceName = serviceName;
        this.servers = new ConcurrentHashMap<>();
    }

    // Métodos para adicionar, remover e obter servidores

    public void addServer(String address, String qualifier) {
        servers.put(qualifier, new ServerEntry(address, qualifier));
    }

    public void removeServer(String qualifier) {
        servers.remove(qualifier);
    }

    public ServerEntry getServer(String qualifier) {
        return servers.get(qualifier);
    }

    // Getters e setters

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Map<String, ServerEntry> getServers() {
        return servers;
    }

    public void setServers(ConcurrentHashMap<String, ServerEntry> servers) {
        this.servers = servers;
    }

}