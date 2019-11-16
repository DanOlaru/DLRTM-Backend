package org.longmoneyoffshore.dlrtmweb.repository;

import org.longmoneyoffshore.dlrtmweb.entities.entity.Product;

import java.util.Collection;

public interface ProductDao {

    public Collection<Product> getAllProducts();

    public Collection<Product> getProductsByField(Object field);

    public Product getProductById(int productId);

    public void deleteProductById(int productId);

    public void updateProduct (Product product);

    public void insertProduct (Product product);

}
