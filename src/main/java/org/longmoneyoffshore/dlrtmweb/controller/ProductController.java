package org.longmoneyoffshore.dlrtmweb.controller;

import org.longmoneyoffshore.dlrtmweb.FakeDataSets;
import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Product;
import org.longmoneyoffshore.dlrtmweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.Collection;

//TODO: questions:
//TODO: What's the last word on Autowired? To use or not to use?
//TODO: does this class need to extend HttpServlet?
//TODO: Wasn't there an interface I could implement that would generate methods for the basic CRUD operations for me?


@RestController
//@RequestMapping("/products")
public class ProductController  {
//public class ProductController {

    @Qualifier("productService")
    private ProductService productService;

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    //todo betterbversion
    @GetMapping("/products")
    public Collection<Product> getAllProducts() {

        return productService.getAllProducts();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String printTest() {
        //System.out.println("REQUEST /TEST");
        return "Testing.";
    }

    @RequestMapping("/products/{id}")
    public Product getProduct(@PathVariable String id) {
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

    @RequestMapping(method = RequestMethod.DELETE, value = "products/{id}")
    public void deleteProduct(@PathVariable String id) {

        System.out.println("REQUEST /DELETE PRODUCT");

        productService.deleteProductById(id);

    }

}
