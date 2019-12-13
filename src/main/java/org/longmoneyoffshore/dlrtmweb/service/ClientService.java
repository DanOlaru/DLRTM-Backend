package org.longmoneyoffshore.dlrtmweb.service;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.repository.ClientDao;
import org.longmoneyoffshore.dlrtmweb.entities.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Qualifier("ClientService")
@Data
public class ClientService {

    @Autowired
    private ClientDao clientDao;

    public List<Client> getAllClients() {
        return clientDao.findAll();
    }

    public Client getClientById(int id) {
        return this.clientDao.findById(id).get();
    }


    public void removeClientById(int id) {
        this.clientDao.deleteById(id);
    }

    public void removeAllClients() {
        this.clientDao.deleteAll();
    }


    public void updateClient (Client client) {

        this.clientDao.save(client);
    }

    public void insertClient (Client client) {

        this.clientDao.save(client);

    }

    public void insertClients (List<Client> clients) {

        System.out.println("TRYING TO INPUT THESE CLIENTS: ");
        clients.stream().forEach(c -> System.out.println(c));

        this.clientDao.saveAll(clients);

        //clients.stream().forEach(c -> insertClient(c));
    }

    public void clearTables() {

    }
}

