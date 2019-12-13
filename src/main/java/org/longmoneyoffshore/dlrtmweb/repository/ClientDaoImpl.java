package org.longmoneyoffshore.dlrtmweb.repository;

import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.longmoneyoffshore.dlrtmweb.entities.entity.Client;

import java.util.List;

@Data
public class ClientDaoImpl implements ClientDao {

    @Override
    public List<Client> getAllClients() {
        return null;
    }

    @Override
    public List<Client> getAllClientsByField(Object field) {
        return null;
    }

    @Override
    public Client getClientById(String clientId) {
        return null;
    }

    @Override
    public void removeClientById(String clientId) { }

    @Override
    public void updateClient(Client client) { }

    @Override
    public void clearTables() {
        System.out.println("TEST: CLEARING CLIENTS TABLE");
    }


    @Override
    public void insertClients(List<Client> clients) {


        //clients.stream().forEach(c -> insertClient(c));

        Session session = null;

        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();

            for (Client c : clients) {
                System.out.println("SAVING CLIENT: " + c.smallToString());
                session.save(c);
            }

            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }

    }

    @Override
    public void insertClient(Client client) {
        System.out.println("TESTING: DAOIMPL HIBERNATE: INSERTING CLIENT: " + client.smallToString());
        //client.setClientID(4);

        Session session = null;

        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }

    }
}