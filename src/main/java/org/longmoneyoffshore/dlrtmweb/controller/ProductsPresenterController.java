package org.longmoneyoffshore.dlrtmweb.controller;

import org.longmoneyoffshore.dlrtmweb.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ProductsPresenterController {

    private ProductService productService;

    @GetMapping("/presentProducts")
    public String listProducts(Model model) {

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

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}