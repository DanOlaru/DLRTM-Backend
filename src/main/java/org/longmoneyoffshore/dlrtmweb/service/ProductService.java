package org.longmoneyoffshore.dlrtmweb.service;

//import org.longmoneyoffshore.dlrtmweb.Dao.ProductDao;
import org.longmoneyoffshore.dlrtmweb.repository.ProductDaoImpl;
import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
@Qualifier("productService")
public class ProductService {

    private ProductDaoImpl productDao;

    public ProductDaoImpl getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDaoImpl productDao) {
        this.productDao = productDao;
    }

    public ProductService(ProductDaoImpl productDao) {
        this.productDao = productDao;
    }

    public Collection<Product> getAllProducts() {

        //TODO: why Collection and not List??

        return this.productDao.getAllProducts();
    }


    public Collection<Product> getProductsByField(Object field) {
        return this.productDao.getProductsByField(field);
    }

    public Product getProductById (String productId) {
        return this.productDao.getProductById (productId);
    }


    public void deleteProductById(String productId) {
        this.productDao.deleteProductById(productId);
    }


    public void updateProduct (Product product){

        this.productDao.updateProduct(product);
    }

    public void insertProduct (Product product) {
        this.productDao.insertProduct(product);
    }

    //temporary data source

    private List<Product> products =  new ArrayList<>(Arrays.asList(
            new Product("0001", "Blender", "Phillips", "Netherlands",
                    "food blender", 20, 10.67,0,0,10,0,
                    "Free Bread Knife","USD", 100,0,0,0,
                    "Unit","Pending recalls"),

            new Product("0002", "Mixer", "Sony", "Japan",
                    "food mixer", 47.8, 20.25,2,-1,20,10,
                    "10% off blades","USD",180,0,0,0,
                    "Unit","best in class"),

            new Product("0003", "Grinder", "Sanyo", "South Korea",
                    "coffee grinder",33, 34.43,3,-3,0,14,
                    "free CD player","USD",60,0,0,20,
                    "Unit","new model"),

            new Product("0004", "Coffee Maker", "JVC", "Germany",
                    "coffee maker",22, 16.15,11,20,3,20,
                    "5 year warranty","USD",10,0,0,70,
                    "Unit","buyer's favorite"))

    );


}
