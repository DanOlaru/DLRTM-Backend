package org.longmoneyoffshore.dlrtmweb.Controller;

/*
import org.longmoneyoffshore.dlrtmweb.Entities.models.entity.Transaction;
import org.longmoneyoffshore.dlrtmweb.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

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

        //more appropriately get the transactions for the current day or a specific date
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
    //public Collection<Transaction> insertTransaction(@RequestBody Transaction transaction) {
    //public boolean insertTransaction(@RequestBody Transaction transaction) {
    public void insertTransaction(@RequestBody Transaction transaction) {

        transactionService.insertTransaction(transaction);

        System.out.println("INSERTING TRANSACTION " + transaction.toString());
        //return transactionService.getAllTransactions();
    }

}*/

