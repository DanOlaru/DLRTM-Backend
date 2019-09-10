package org.longmoneyoffshore.dlrtmweb.dao;

import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Product;

import java.util.Collection;

public interface ProductDao {
//public interface ProductDao extends CrudRepository {

    public Collection<Product> getAllProducts();

    public Collection<Product> getProductsByField(Object field);

    public Product getProductById(String productId);

    public void deleteProductById(String productId);

    public void updateProduct (Product product);

    public void insertProduct (Product product);

    //possible alternative where true is returned when insertion succeeds and false when it does not
    //boolean insertProduct (Product product);

}
