package org.longmoneyoffshore.dlrtmweb.controller;

import org.longmoneyoffshore.dlrtmweb.FakeDataSets;
import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Product;
import org.longmoneyoffshore.dlrtmweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.Collection;

@RestController
//@RequestMapping("/products")
public class ProductController extends HttpServlet {
//public class ProductController {

    //@Autowired
    private ProductService productService;

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/products")
    public Collection<Product> getAllProducts(){

        System.out.println("CONTROLLER: REQUEST /GET ALL PRODUCTS");

        return productService.getAllProducts();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String printTest(){
        //System.out.println("REQUEST /TEST");
        return "Testing.";
    }

    @RequestMapping("/products/{id}")
    public Product getProduct(@PathVariable String id) {

        System.out.println("REQUEST /GET PRODUCT BY ID: " + id);

        return productService.getProductById(id);
    }

    //@RequestMapping(method = RequestMethod.POST, value = "/products")
    @RequestMapping(method = RequestMethod.POST, value = "/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addProduct(@RequestBody Product product) {

        System.out.println("REQUEST /ADD SINGLE PRODUCT " + product.toString());

        //FakeDataSets fakeDataSets = new FakeDataSets();
        //product = fakeDataSets.productFive;

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


    /*//@RequestMapping(value = "/", method = RequestMethod.GET)
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Product> getAllProducts() {
        return productService.getAllProducts();

    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Product getProductById(@PathVariable("id") String id) {
        return productService.getProductById(id);
    }

    @RequestMapping(value = "{id}" , method = RequestMethod.DELETE)
    //public Collection<Product> deleteProductById(@PathVariable("id") String id) {
    public void deleteProductById(@PathVariable("id") String id) {
        productService.deleteProductById(id);
        //return productService.getAllProducts();
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    //public Collection<Product> updateProductById(@RequestBody Product product) {
    public void updateProductById(@RequestBody Product product) {
        productService.updateProduct(product);
        //return productService.getAllProducts();
    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    //public Collection<Product> insertProduct(@RequestBody Product product) {
    //public boolean insertProduct(@RequestBody Product product) {
    public void insertProduct(@RequestBody Product product) {

        productService.insertProduct(product);

        System.out.println("INSERTING PRODUCT " + product.toString());
        //return productService.getAllProducts();
    }*/

}
