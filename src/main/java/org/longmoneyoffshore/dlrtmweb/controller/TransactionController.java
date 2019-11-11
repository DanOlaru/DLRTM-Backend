package org.longmoneyoffshore.dlrtmweb.controller;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Transaction;
import org.longmoneyoffshore.dlrtmweb.service.ClientService;
import org.longmoneyoffshore.dlrtmweb.service.ProductService;
import org.longmoneyoffshore.dlrtmweb.service.TransactionService;
import org.longmoneyoffshore.dlrtmweb.view.TransactionCommandObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

@Controller
@Data
public class TransactionController {

    private TransactionService transactionService;

    private TransactionCommandObject transactionCommandObject;

    private OnlineStoreController onlineStoreController;
    private ProductService productService;
    private ClientService clientService;


    public TransactionService getTransactionService() {
        return transactionService;
    }

    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping(value = "/transactions")
    public Collection<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();

    }

    @RequestMapping(value = "/transaction/{id}", method = RequestMethod.GET)
    public Transaction getTransactionById(@PathVariable("id") String id) {
        return transactionService.getTransactionById(id);
    }

    //TODO: unclear how the date can be passed via the url
    @RequestMapping(value = "/transaction/{date}", method = RequestMethod.GET)
    public Collection<Transaction> getTransactionByDate(@PathVariable("date") Date date) {

        //transactions for the current day or a specific date
        return transactionService.getTransactionsByDate(date);

    }


    @DeleteMapping(value = "transaction/{selectedTransactionID}")
    public String deleteTransactionById(@PathVariable("selectedTransactionID") String id, Model model) {
        transactionService.removeTransactionById(id);

        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("transactions", transactionService.getAllTransactions());
        return "index";
    }


    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTransactionById(@RequestBody Transaction transaction) {
        transactionService.updateTransaction(transaction);
    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertTransaction(@RequestBody Transaction transaction) {

        transactionService.insertTransaction(transaction);

    }


    @RequestMapping(value = "/createNewTransaction", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createNewTransaction(@ModelAttribute("command") TransactionCommandObject command, Model model) {

        transactionService.insertTransaction(new Transaction(command.getClientId(), command.getProductIds()));

    }


}

