package org.longmoneyoffshore.dlrtmweb.controller;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.repository.ClientDaoImpl;
import org.longmoneyoffshore.dlrtmweb.service.ClientService;
import org.longmoneyoffshore.dlrtmweb.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
@Data
public class ProductsPresenterController {

    private ProductService productService;
    private ClientDaoImpl clientDao;

    @GetMapping("/presentProducts")
    public String listProducts(Model model) {

        model.addAttribute("products", productService.getAllProducts());
        //model.addAttribute("clientID", )

        return "productsThyme";
    }

    @PostMapping("/presentProducts")
    public String showProducts (@RequestParam("selectedClientID") String clientID, Model model){

        model.addAttribute("clientID", clientID);

        model.addAttribute("clientName", clientDao.getClientById(clientID).getClientName().getSimpleName());
        model.addAttribute("products", productService.getAllProducts());

        return "productsThyme";
    }


    @GetMapping("/presentProductsEx")
    public ModelAndView selectProduct() {

        ModelAndView mav = new ModelAndView("clientsThyme");
        mav.addObject("clients", productService.getAllProducts());

        return mav;
    }

   /* @Controller
    public class SomeController {
        @RequestMapping("/")
        public String redirect() {
            return "redirect:/query?q=Thymeleaf+Is+Great!";
        }
    }*/

   /* public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }*/
}