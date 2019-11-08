package org.longmoneyoffshore.dlrtmweb.controller;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.service.ClientService;
import org.longmoneyoffshore.dlrtmweb.service.ProductService;
import org.longmoneyoffshore.dlrtmweb.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Data
public class OnlineStoreController {
    private ClientService clientService;
    private ProductService productService;
    private TransactionService transactionService;

    @GetMapping("/showStore")
    public String showStore (Model model) {

        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("transactions", transactionService.getAllTransactions());
        return "index";
    }


}
