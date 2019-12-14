package org.longmoneyoffshore.dlrtmweb.service;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.repository.TransactionDao;
import org.longmoneyoffshore.dlrtmweb.entities.entity.Transaction;
import org.longmoneyoffshore.dlrtmweb.view.TransactionCommandObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Qualifier("TransactionService")
@Data
public class TransactionService {

    @Autowired
    private TransactionDao transactionDao;

    public List<Transaction> getAllTransactions() {
        return this.transactionDao.findAll();
    }

   /* public List<Transaction> getTransactionsByDate (Date date) {
        return this.transactionDao.getAllTransactionsByDate(date);
    }*/

    public Transaction getTransactionById (int id) {
        return this.transactionDao.findById(id).get();
    }


    public void removeTransactionById (int id) {
        this.transactionDao.deleteById(id);
    }

    public void removeAllTransactions () { this.transactionDao.deleteAll(); }


    public void updateTransaction (Transaction transaction) {

        this.transactionDao.save(transaction);
    }

    public void insertTransaction (Transaction transaction) {
        System.out.println("TESTING: INSIDE TRANSACTION SERVICE: INSERTING TRANSACTION " + transaction.toString());
        this.transactionDao.save(transaction);
    }

    public void insertTransaction (TransactionCommandObject transactionCommandObject) {
        System.out.println("TESTING: INSIDE TRANSACTION SERVICE HIBERNATE: INSERTING TRANSACTION " + transactionCommandObject.toString());

        this.transactionDao.save(new Transaction(transactionCommandObject));

    }

    public void insertTransaction(TransactionCommandObject transactionCommandObject, ProductService productService) {
        System.out.println("TESTING: INSIDE TRANSACTION SERVICE HIBERNATE: INSERTING TRANSACTION " + transactionCommandObject.toString());

        //this.transactionDao.save(new Transaction(transactionCommandObject));
        this.transactionDao.save(new Transaction(transactionCommandObject, productService));

    }

}

