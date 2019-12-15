package org.longmoneyoffshore.dlrtmweb.controller;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.entities.entity.Product;
import org.longmoneyoffshore.dlrtmweb.globalvalues.ProductsFakeDataSets;
import org.longmoneyoffshore.dlrtmweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@Qualifier("ProductController")
@Data
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String printTest() {
        return "Testing.";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
    public Product getProduct(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addProduct(@RequestBody Product product) {

        productService.insertProduct(product);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
    public void updateProduct(@RequestBody Product product, @PathVariable String id) {
        System.out.println("REQUEST / UPDATE PRODUCT");

        productService.updateProduct(product);

    }

    //@RequestMapping(method = RequestMethod.DELETE, value = "products/{id}")
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void deleteProductById(@PathVariable("id") int id) {

        System.out.println("REQUEST /DELETE PRODUCT");

        productService.deleteProductById(id);

    }

    @PostMapping(value = "/productsfake")
    public void insertFakeProducts() {
        //productService.clearTable();

        productService.insertProducts(ProductsFakeDataSets.fakeProducts);
    }

}
