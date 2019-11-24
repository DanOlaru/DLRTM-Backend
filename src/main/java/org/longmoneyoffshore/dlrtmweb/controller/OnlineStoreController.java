package org.longmoneyoffshore.dlrtmweb.controller;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.entities.atomic.Address;
import org.longmoneyoffshore.dlrtmweb.entities.atomic.PersonName;
import org.longmoneyoffshore.dlrtmweb.entities.atomic.PhoneNumber;
import org.longmoneyoffshore.dlrtmweb.entities.entity.Client;
import org.longmoneyoffshore.dlrtmweb.entities.entity.Product;
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
    private Product newProduct;
    private Client newClient;


    @GetMapping("/showStore")
    public String showStore (Model model) {

        setModel(model);
        return "index";
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

        setModel(model);
        return "index";
    }


    @PostMapping(value = "/deleteClient")
    public String deleteClientById(@RequestParam("selectedClientID") String id, Model model) {

        clientService.removeClientById(id);

        setModel(model);
        return "index";
    }

    @GetMapping(value = "/deleteTransaction")
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
    }


    @PostMapping(value = "/createNewProduct")
    public String createProduct (@RequestParam("uniqueID") int uniqueID,
                                 @RequestParam("name") String name,
                                 @RequestParam("manufacturer") String manufacturer,
                                 @RequestParam("country") String country,
                                 @RequestParam("description") String description,
                                 @RequestParam("unitPrice") double unitPrice,
                                 @RequestParam("specialOffers") String specialOffers,
                                 @RequestParam("itemsInStockInt") int itemsInStockInt,
                                 @RequestParam("specialMentions") String specialMentions,
                                 Model model) {


        newProduct.setProductID(uniqueID);
        newProduct.setProductName(name);
        newProduct.setProductManufacturer(manufacturer);
        newProduct.setProductCountry(country);
        newProduct.setProductDescription(description);
        newProduct.setProductUnitPrice(unitPrice);
        newProduct.setProductSpecialOffers(specialOffers);
        newProduct.setProductItemsInStockInt(itemsInStockInt);
        newProduct.setProductSpecialMentions(specialMentions);

        productService.insertProduct(newProduct);

        setModel(model);

        return "index";
    }

    @PostMapping(value = "/deleteProduct")
    public String deleteProductById(@RequestParam("selectedProductID") int id, Model model) {
        productService.deleteProductById(id);

        setModel(model);

        return "index";
    }

    @PostMapping(value = "/createNewClient")
    public String createClient (@RequestParam("clientID") String clientID,
                                 @RequestParam("clientName") String clientName,
                                 @RequestParam("clientPhone") String clientPhone,
                                 @RequestParam("clientEmail") String clientEmail,
                                 @RequestParam("clientAddress") String clientAddress,
                                 @RequestParam("clientStatus") String clientStatus,
                                 @RequestParam("clientSpecialMentions") String clientSpecialMentions,
                                 Model model) {


        newClient.setClientID(clientID);
        newClient.setClientName(new PersonName(clientName));

        PhoneNumber ph = new PhoneNumber(clientName, clientPhone);
        newClient.setClientBusinessPhone(ph);
        newClient.setClientMobilePhone(ph);
        newClient.setClientHomePhone(ph);
        newClient.setClientAlternatePhone(ph);

        newClient.setClientPrimaryEmailAddress(clientEmail);
        newClient.setClientBillingAddress(new Address(clientAddress));
        newClient.setClientStatus(clientStatus);
        newClient.setClientSpecialMentions(clientSpecialMentions);

        clientService.insertClient(newClient);

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
