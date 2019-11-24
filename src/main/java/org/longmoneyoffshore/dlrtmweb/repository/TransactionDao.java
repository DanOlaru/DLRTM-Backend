package org.longmoneyoffshore.dlrtmweb.repository;


import org.longmoneyoffshore.dlrtmweb.entities.entity.Transaction;

import java.util.Date;
import java.util.List;

public interface TransactionDao {

    List<Transaction> getAllTransactions();

    //more general get method
    List<Transaction> getTransactionsByField(Object field);
    //more specific get methods
    List<Transaction> getAllTransactionsByDate(Date date);

    Transaction getTransactionById(String transactionId);

    void removeTransactionById(String transactionId);

    public void removeAllTransactions ();

    void updateTransaction(Transaction transaction);

    void insertTransaction (Transaction transaction);

    void insertTransactionHibernate (Transaction transaction);

}

