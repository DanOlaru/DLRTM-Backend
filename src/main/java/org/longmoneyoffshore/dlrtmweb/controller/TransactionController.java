package org.longmoneyoffshore.dlrtmweb.controller;

import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Transaction;
import org.longmoneyoffshore.dlrtmweb.service.TransactionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private TransactionService transactionService;

    public TransactionService getTransactionService() {
        return transactionService;
    }

    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    //@RequestMapping(value = "/", method = RequestMethod.GET)
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();

    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Transaction getTransactionById(@PathVariable ("id") String id) {
        return transactionService.getTransactionById(id);
    }

    //TODO: unclear how the date can be passed via the url — NEEDS SORTING OUT
    @RequestMapping(value = "/{date}",method = RequestMethod.GET)
    public Collection<Transaction> getTransactionByDate(@PathVariable ("date") Date date) {

        //transactions for the current day or a specific date
        return transactionService.getTransactionsByDate(date);

    }

    @RequestMapping(value = "{id}" , method = RequestMethod.DELETE)
    //public Collection<Transaction> deleteTransactionById(@PathVariable("id") String id) {
    public void deleteTransactionById(@PathVariable("id") String id) {
        transactionService.removeTransactionById(id);
        //return transactionService.getAllTransactions();
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    //public Collection<Transaction> updateTransactionById(@RequestBody Transaction transaction) {
    public void updateTransactionById(@RequestBody Transaction transaction) {
        transactionService.updateTransaction(transaction);

        System.out.println("UPDATING TRANSACTION " + transaction.toString());
        //return transactionService.getAllTransactions();
    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    //public boolean insertTransaction(@RequestBody Transaction transaction) {
    public void insertTransaction(@RequestBody Transaction transaction) {

        transactionService.insertTransaction(transaction);

        System.out.println("INSERTING TRANSACTION " + transaction.toString());
        //return transactionService.getAllTransactions();
    }

    @RequestMapping(value = "/newTransaction", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertNewTransaction(@RequestBody String clientId, @RequestBody String productIds) {

        transactionService.insertTransaction(new Transaction(clientId, productIds));

        //System.out.println("INSERTING TRANSACTION " + transaction.toString());
        //return transactionService.getAllTransactions();

    }

}

