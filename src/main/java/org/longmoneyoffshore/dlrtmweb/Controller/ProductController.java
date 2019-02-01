package org.longmoneyoffshore.dlrtmweb.Controller;

import org.longmoneyoffshore.dlrtmweb.Entities.models.entity.Product;
import org.longmoneyoffshore.dlrtmweb.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping(method = RequestMethod.GET, value = "/products")
    public List<Product> getAllProducts(){

        System.out.println("REQUEST /GET ALL PRODUCTS");

        return productService.getAllProducts();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String printTest(){
        System.out.println("REQUEST /TEST");
        return "Testing.";
    }


    @RequestMapping("/products/{id}")
    public Product getProduct(@PathVariable String id) {

        System.out.println("REQUEST /GET PRODUCT BY ID");

        return productService.getProductById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/products")
    public void addProduct(@RequestBody Product product) {
        System.out.println("REQUEST /ADD SINGLE PRODUCT");
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


    //alternate implementation
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
