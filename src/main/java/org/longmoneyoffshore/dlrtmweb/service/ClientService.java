package org.longmoneyoffshore.dlrtmweb.service;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.repository.ClientDao;
import org.longmoneyoffshore.dlrtmweb.entities.entity.Client;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("clientService")
@Data
public class ClientService {

    private ClientDao clientDao;

    public List<Client> getAllClients() {
        return this.clientDao.getAllClients();
    }

    public Client getClientById(String id) {
        return this.clientDao.getClientById(id);
    }


    public void removeClientById(String id) {
        this.clientDao.removeClientById(id);
    }


    public void updateClient (Client client) {

        this.clientDao.updateClient(client);
    }

    public void insertClient (Client client) {
        this.clientDao.insertClient(client);
    }

    public void insertClients (List<Client> clients) {
        //System.out.println("INSIDE CLIENT SERVICE: ");

        this.clientDao.insertClients(clients);
    }

    public void clearTables() { this.clientDao.clearTables(); }
}

