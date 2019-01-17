package Dao;

import Entity.models.entity.Product;

import java.util.Collection;

public interface ProductDao {

    Collection<Product> getAllProducts();

    Collection<Product> getProductsByField(Object field);

    Product getProductById(String productId);

    void removeProductById(String productId);

    void updateProduct (Product product);

    void insertProduct (Product product);

    //possible alternative where true is returned when insertion succeeds and false when it does not
    //boolean insertProduct (Product product);

}
