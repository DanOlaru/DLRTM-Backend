package org.longmoneyoffshore.dlrtmweb.controller;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.entities.entity.Client;
import org.longmoneyoffshore.dlrtmweb.entities.entity.Product;
import org.longmoneyoffshore.dlrtmweb.service.ClientService;
import org.longmoneyoffshore.dlrtmweb.service.ProductService;
import org.longmoneyoffshore.dlrtmweb.service.TransactionService;
import org.longmoneyoffshore.dlrtmweb.view.TransactionCommandObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Qualifier("OnlineStoreController")
@Data
public class OnlineStoreController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;

    @Autowired
    private TransactionService transactionService;

    //private TransactionCommandObject transactionCommandObject;

    @GetMapping("/testClientService")
    public String testClientService() {
        return clientService.toString();
    }

    @GetMapping("/showStore")
    public String showStore(Model model) {

        setModel(model);
        return "index";
    }


    @RequestMapping(value = "/insertNewTransaction", method = RequestMethod.POST)
    public String insertNewTransactionAndRefresh(@RequestParam("selectedClientID") int clientID,
                                                 @RequestParam("selectedProductIDs") String productIds,
                                                 @RequestParam("transactionStatus") String transactionStatus,
                                                 @RequestParam("transactionSpecialMentions") String transactionSpecialMentions,
                                                 Model model) {

        TransactionCommandObject transactionCommandObject = TransactionCommandObject.builder()
                .clientId(clientID)
                .productIds(productIds)
                .transactionStatus(transactionStatus)
                .transactionSpecialMentions(transactionSpecialMentions)
                .build();


        //System.out.println("TESTING: INSIDE ONLINE STORE CONTROLLER CREATE NEW TRANSACTION: " + transactionCommandObject.toString());

        //transactionService.insertTransaction(transactionCommandObject);

        transactionService.insertTransaction(transactionCommandObject, productService);

        setModel(model);
        return "index";
    }


    @PostMapping(value = "/createNewClient")
    public String createClient(@RequestParam("clientName") String clientName,
                               @RequestParam("clientPhone") String clientPhone,
                               @RequestParam("clientEmail") String clientEmail,
                               @RequestParam("clientAddress") String clientAddress,
                               @RequestParam("clientStatus") String clientStatus,
                               @RequestParam("clientSpecialMentions") String clientSpecialMentions,
                               Model model) {


        clientService.insertClient(Client.builder()
                .clientName(clientName)
                .clientBusinessPhone(clientPhone)
                .emailAddress(clientEmail)
                .clientAddress(clientAddress)
                .clientStatus(clientStatus)
                .clientSpecialMentions(clientSpecialMentions)
                .build());

        setModel(model);

        return "index";
    }

    @PostMapping(value = "/deleteClient")
    public String deleteClientById(@RequestParam("selectedClientID") int id, Model model) {

        clientService.removeClientById(id);

        setModel(model);
        return "index";
    }

   /* @GetMapping(value = "/deleteTransaction")
    public String deleteTransactionById(@RequestParam("selectedTransactionID") String id, Model model) {

       transactionService.removeTransactionById(id);

        setModel(model);

        return "index";
    }

    @GetMapping(value = "/deleteAllTransactions")
    public String deleteAll(Model model) {

        transactionService.removeAllTransactions();

        setModel(model);

        return "index";
    }*/


    @PostMapping(value = "/createNewProduct")
    public String createProduct(@RequestParam("name") String name,
                                @RequestParam("manufacturer") String manufacturer,
                                @RequestParam("country") String country,
                                @RequestParam("description") String description,
                                @RequestParam("unitPrice") double unitPrice,
                                @RequestParam("specialOffers") String specialOffers,
                                @RequestParam("itemsInStockInt") int itemsInStockInt,
                                @RequestParam("specialMentions") String specialMentions,
                                Model model) {

        productService.insertProduct(Product.builder()
                .productName(name)
                .productManufacturer(manufacturer)
                .productCountry(country)
                .productDescription(description)
                .productUnitPrice(unitPrice)
                .productSpecialOffers(specialOffers)
                .productItemsInStockInt(itemsInStockInt)
                .productSpecialMentions(specialMentions)
                .build());

        setModel(model);

        return "index";
    }

    @PostMapping(value = "/deleteProduct")
    public String deleteProductById(@RequestParam("selectedProductID") int id, Model model) {
        productService.deleteProductById(id);

        setModel(model);

        return "index";
    }

    public void setModel(Model model) {

        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("transactions", transactionService.getAllTransactions());
    }

    @RequestMapping(value = "/justTesting")
    public void justTestMethod() {
        System.out.println("TESTING, THIS IS TESTING");
    }

}
