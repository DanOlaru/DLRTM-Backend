package org.longmoneyoffshore.dlrtmweb.service;


import org.longmoneyoffshore.dlrtmweb.repository.ClientDao;
import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Client;

import java.util.Collection;

public class ClientService {

    //@Autowired
    //@Qualifier("dbData")
    private ClientDao clientDao;

    //constructor
    public ClientService (ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public Collection<Client> getAllClients() {
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
}

