/*
package org.longmoneyoffshore.dlrtmweb.service;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.repository.TransactionDao;
import org.longmoneyoffshore.dlrtmweb.entities.entity.Transaction;
import org.longmoneyoffshore.dlrtmweb.view.TransactionCommandObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Qualifier("transactionService")
@Data
public class TransactionService {

    private TransactionDao transactionDao, transactionDaoHibernate;

    public List<Transaction> getAllTransactions() {
        return this.transactionDao.getAllTransactions();
    }

    public List<Transaction> getTransactionsByField(Object field) {
        return this.transactionDao.getTransactionsByField(field);
    }

    public List<Transaction> getTransactionsByDate (Date date) {
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
        System.out.println("TESTING: INSIDE TRANSACTION SERVICE: INSERTING TRANSACTION " + transaction.toString());
        this.transactionDao.insertTransaction(transaction);
    }

    public void insertTransaction (TransactionCommandObject transactionCommandObject) {
        //System.out.println("TESTING: INSIDE TRANSACTION SERVICE HIBERNATE: INSERTING TRANSACTION " + transactionCommandObject.toString());

        this.transactionDao.insertTransaction(new Transaction(transactionCommandObject));

        //write in the _hibernate table
        this.transactionDaoHibernate.insertTransaction(new Transaction(transactionCommandObject));
    }

}

*/
