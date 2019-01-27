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
    //public Collection<Product> removeProductById(@PathVariable("id") String id) {
    public void removeProductById(@PathVariable("id") String id) {
        productService.removeProductById(id);
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


    //alternate implementation — from Koushik
  /*
    @RequestMapping(method = RequestMethod.GET ,value = "/products")
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }


    @RequestMapping("/products/{id}")
    public Product getProduct(@PathVariable String id) {

        return productService.getProduct(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/products")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
    public void updateProduct(@RequestBody Product product, @PathVariable String id) {

        productService.updateProduct(id, product);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "products/{id}")
    public void deleteProduct(@PathVariable String id) {

        productService.deleteProduct(id);

    }*/
}
