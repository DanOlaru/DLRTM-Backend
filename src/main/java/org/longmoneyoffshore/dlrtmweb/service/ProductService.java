package org.longmoneyoffshore.dlrtmweb.service;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.repository.ProductDao;
import org.longmoneyoffshore.dlrtmweb.entities.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Qualifier("productService")
@Data
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> getAllProducts() { return this.productDao.findAll(); }


    public Product getProductById (int productId) {
        return this.productDao.findById(productId).get();
    }


    public void deleteProductById(int productId) {
        this.productDao.deleteById(productId);
    }


    public void updateProduct (Product product){

        this.productDao.save(product);
    }

    public void insertProduct (Product product) {

        this.productDao.save(product);
    }

    public void insertProducts(List<Product> products) { this.productDao.saveAll(products);}

    public void deleteAll() {this.productDao.deleteAll();}

    public void clearTable() {this.productDao.deleteAll();}

}
