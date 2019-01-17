package Controller;

import Entity.models.entity.Product;
import Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    //@RequestMapping(value = "/", method = RequestMethod.GET)
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
    }


}
