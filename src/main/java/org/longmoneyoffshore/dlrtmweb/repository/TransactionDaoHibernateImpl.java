package org.longmoneyoffshore.dlrtmweb.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.longmoneyoffshore.dlrtmweb.entities.entity.Transaction;

import java.util.Date;
import java.util.List;

public class TransactionDaoHibernateImpl implements TransactionDao {
    @Override
    public List<Transaction> getAllTransactions() {
        return null;
    }

    @Override
    public List<Transaction> getTransactionsByField(Object field) {
        return null;
    }

    @Override
    public List<Transaction> getAllTransactionsByDate(Date date) {
        return null;
    }

    @Override
    public Transaction getTransactionById(String transactionId) {
        return null;
    }

    @Override
    public void removeTransactionById(String transactionId) {

    }

    @Override
    public void removeAllTransactions() {

    }

    @Override
    public void updateTransaction(Transaction transaction) {

    }

    @Override
    public void insertTransaction(Transaction transaction) {
        System.out.println("TESTING: INSIDE TRANSACTION DAOIMPL HIBERNATE: INSERTING TRANSACTION " + transaction.toString());

        Session session = null;

        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(transaction);
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }

    }

}
