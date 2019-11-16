package org.longmoneyoffshore.dlrtmweb.controller;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.entities.entity.Product;
import org.longmoneyoffshore.dlrtmweb.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//@RestController
@Controller
@Data
public class ProductController {

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

    @RequestMapping(method = RequestMethod.DELETE, value = "products/{id}")
    public void deleteProduct(@PathVariable int id) {

        System.out.println("REQUEST /DELETE PRODUCT");

        productService.deleteProductById(id);

    }

    @GetMapping(value = "/productsfake")
    public void insertFakeProducts() {
        productService.clearTable();

        productService.insertProducts(
                new ArrayList<Product>(Arrays.asList(
                        new Product(1, "Blender", "Phillips", "Netherlands",
                                "food blender", 20, "Free Bread Knife", 100,
                                "Pending recalls"),

                        new Product(2, "Mixer", "Sony", "Japan",
                                "food mixer", 47.8,
                                "10% off blades", 180, "best in class"),

                        new Product(3, "Grinder", "Sanyo", "South Korea",
                                "coffee grinder", 33,
                                "free CD player", 60, "new model"),

                        new Product(4, "Coffee Maker", "JVC", "Germany",
                                "coffee maker", 22,
                                "5 year warranty", 10, "buyer's favorite"),

                        new Product(5, "Coffee Shaker", "Sunny", "China",
                                "coffee flaker", 13, "nada",
                                666, "flyer's delite"),

                        new Product(6, "XRay Machine", "IBM", "USA",
                                "XRAY machine", 2,
                                "yoyoy", 0, "\"5 year warranty\"heavy duty")

                )));
    }

}
