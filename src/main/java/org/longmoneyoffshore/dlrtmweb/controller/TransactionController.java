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

//@RestController
@Controller
@Data
//@RequestMapping("/transaction")
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

    //@RequestMapping(value = "/", method = RequestMethod.GET)

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping(value = "/transaction")
    public Collection<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();

    }

    @RequestMapping(value = "/transaction/{id}", method = RequestMethod.GET)
    public Transaction getTransactionById(@PathVariable("id") String id) {
        return transactionService.getTransactionById(id);
    }

    //TODO: unclear how the date can be passed via the url — NEEDS SORTING OUT
    @RequestMapping(value = "/transaction/{date}", method = RequestMethod.GET)
    public Collection<Transaction> getTransactionByDate(@PathVariable("date") Date date) {

        //transactions for the current day or a specific date
        return transactionService.getTransactionsByDate(date);

    }

    @RequestMapping(value = "/transaction/{id}", method = RequestMethod.DELETE)
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

    //@RequestMapping(value = "/newTransaction", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/newTransaction", method = RequestMethod.POST)
    public void insertNewTransaction(@RequestParam("selectedProductIDs") String productIds,
                                     @RequestParam("transactionStatus") String transactionStatus,
                                     @RequestParam("transactionSpecialMentions") String transactionSpecialMentions) {

        transactionCommandObject.setProductIds(productIds);
        transactionCommandObject.setTransactionStatus(transactionStatus);
        transactionCommandObject.setTransactionSpecialMentions(transactionSpecialMentions);

        transactionService.insertTransaction(transactionCommandObject);

    }

    @RequestMapping(value = "/insertNewTransaction", method = RequestMethod.POST)
    public String insertNewTransactionAndRefresh(@RequestParam("selectedClientID") String clientID,
                                                 @RequestParam("selectedProductIDs") String productIds,
                                                 @RequestParam("transactionStatus") String transactionStatus,
                                                 @RequestParam("transactionSpecialMentions") String transactionSpecialMentions,
                                                 Model model) {

        transactionCommandObject.setClientId(clientID);
        transactionCommandObject.setProductIds(productIds);
        transactionCommandObject.setTransactionStatus(transactionStatus);
        transactionCommandObject.setTransactionSpecialMentions(transactionSpecialMentions);

        transactionService.insertTransaction(transactionCommandObject);

        //onlineStoreController.showStore(model);
        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("transactions", transactionService.getAllTransactions());
        return "index";

    }

    @RequestMapping(value = "/createNewTransaction", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createNewTransaction(@ModelAttribute("command") TransactionCommandObject command, Model model) {

        transactionService.insertTransaction(new Transaction(command.getClientId(), command.getProductIds()));

    }

}

