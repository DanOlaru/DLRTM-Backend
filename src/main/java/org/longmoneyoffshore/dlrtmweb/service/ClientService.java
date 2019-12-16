package org.longmoneyoffshore.dlrtmweb.service;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.entities.atomic.PaymentCard;
import org.longmoneyoffshore.dlrtmweb.repository.ClientDao;
import org.longmoneyoffshore.dlrtmweb.entities.entity.Client;
import org.longmoneyoffshore.dlrtmweb.repository.PaymentCardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Qualifier("ClientService")
@Data
public class ClientService {

    @Autowired
    private ClientDao clientDao;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private PaymentCardDao cardDao;

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


    public void updateClient(Client client) {

        this.clientDao.save(client);
    }

    @Transactional
    public void insertClient(Client client) {
        /*
        Parent parent = new Parent();
        ...
        Child c1 = new Child();
        ...
        c1.setParent(parent);

        List<Child> children = new ArrayList<Child>();
        children.add(c1);
        parent.setChilds(children);

        session.save(parent);
         */
        List<PaymentCard> cards = client.getCards();
        client.setCards(new ArrayList<>());
        for (PaymentCard card : cards) {
            //entityManager.persist(card);
            client.addCard(card);
            System.out.println("Adding card ---" + card);
        }
        clientDao.save(client);
//        entityManager.persist(client);
//        System.out.println("Client ----"+client);
    }

    public void insertClients(List<Client> clients) {
        this.clientDao.saveAll(clients);
    }

    public void clearTables() {
        this.clientDao.deleteAll();
    }
}

