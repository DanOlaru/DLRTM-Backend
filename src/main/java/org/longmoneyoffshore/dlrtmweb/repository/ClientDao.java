package org.longmoneyoffshore.dlrtmweb.repository;

import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface ClientDao {

    List<Client> getAllClients();

    //Collection<Client> getAllClientsByDate(Date date);

    List<Client> getAllClientsByField (Object field);

    Client getClientById(String clientId);

    void removeClientById(String clientId);

    void updateClient(Client client);

    void insertClient (Client client);

    public void insertClients (List<Client> clients);

    public void clearTables();


    //possible alternative where true is returned when insertion succeeds and false when it does not
    //boolean insertClient (Client client);


}
