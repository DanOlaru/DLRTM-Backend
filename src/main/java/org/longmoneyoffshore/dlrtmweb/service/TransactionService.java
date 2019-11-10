package org.longmoneyoffshore.dlrtmweb.service;


import org.longmoneyoffshore.dlrtmweb.repository.TransactionDao;
import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Transaction;
import org.longmoneyoffshore.dlrtmweb.view.TransactionCommandObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

@Service
@Qualifier("transactionService")
public class TransactionService {

    private TransactionDao transactionDao;

    //constructor
    public TransactionService (TransactionDao transactionDao) { this.transactionDao = transactionDao; }

    public TransactionDao getTransactionDao() {
        return transactionDao;
    }

    public void setTransactionDao(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    public Collection<Transaction> getAllTransactions() {
        return this.transactionDao.getAllTransactions();
    }

    public Collection<Transaction> getTransactionsByField(Object field) {
        return this.transactionDao.getTransactionsByField(field);
    }

    public Collection<Transaction> getTransactionsByDate (Date date) {
        return this.transactionDao.getAllTransactionsByDate(date);
    }

    public Transaction getTransactionById (String id) {
        return this.transactionDao.getTransactionById(id);
    }


    public void removeTransactionById (String id) {
        this.transactionDao.removeTransactionById(id);
    }

    public void removeAllTransactions () { this.transactionDao.removeAllTransactions(); }


    public void updateTransaction (Transaction transaction) {

        this.transactionDao.updateTransaction(transaction);
    }

    public void insertTransaction (Transaction transaction) {
        this.transactionDao.insertTransaction(transaction);
    }

    public void insertTransaction (TransactionCommandObject transactionCommandObject) {

        this.transactionDao.insertTransaction(new Transaction(transactionCommandObject));
    }

}

