package org.longmoneyoffshore.dlrtmweb.view;

import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Client;

import java.util.List;

public class ClientCreationDto {

    private List<Client> clients;

    // default and parameterized constructor

    public void addClient(Client client) {
        this.clients.add(client);
    }

    // getter and setter
}
