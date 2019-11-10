package org.longmoneyoffshore.dlrtmweb.service;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.repository.ProductDaoImpl;
import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Qualifier("productService")
@Data
public class ProductService {

    private ProductDaoImpl productDao;

    public List<Product> getAllProducts() {

        return this.productDao.getAllProducts();
    }


    public List<Product> getProductsByField(Object field) {
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
}
