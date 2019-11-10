package org.longmoneyoffshore.dlrtmweb.repository;


import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Transaction;
import org.longmoneyoffshore.dlrtmweb.view.TransactionCommandObject;

import java.util.Collection;
import java.util.Date;

public interface TransactionDao {

    Collection<Transaction> getAllTransactions();

    //more general get method
    Collection<Transaction> getTransactionsByField(Object field);
    //more specific get methods
    Collection<Transaction> getAllTransactionsByDate(Date date);

    Transaction getTransactionById(String transactionId);

    void removeTransactionById(String transactionId);

    public void removeAllTransactions ();

    void updateTransaction(Transaction transaction);

    void insertTransaction (Transaction transaction);

}

