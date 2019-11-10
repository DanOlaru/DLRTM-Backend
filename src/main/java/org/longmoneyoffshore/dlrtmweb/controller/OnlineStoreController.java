package org.longmoneyoffshore.dlrtmweb.controller;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.service.ClientService;
import org.longmoneyoffshore.dlrtmweb.service.ProductService;
import org.longmoneyoffshore.dlrtmweb.service.TransactionService;
import org.longmoneyoffshore.dlrtmweb.view.TransactionCommandObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@Data
public class OnlineStoreController {
    private ClientService clientService;
    private ProductService productService;
    private TransactionService transactionService;

    private TransactionCommandObject transactionCommandObject;


    @GetMapping("/showStore")
    public String showStore (Model model) {

        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("transactions", transactionService.getAllTransactions());
        return "index";
    }


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

        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("transactions", transactionService.getAllTransactions());
        return "index";
    }


    @GetMapping(value = "/deleteTransaction")
    public String deleteById(@RequestParam("selectedTransactionID") String id, Model model) {

       transactionService.removeTransactionById(id);

        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("transactions", transactionService.getAllTransactions());
        return "index";
    }

    @GetMapping(value = "/deleteAllTransactions")
    public String deleteAll(Model model) {

        transactionService.removeAllTransactions();

        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("transactions", transactionService.getAllTransactions());
        return "index";
    }


    @RequestMapping(value = "/justTesting")
    public void justTestMethod() {
        System.out.println("TESTING, THIS IS TESTING");
    }

}
