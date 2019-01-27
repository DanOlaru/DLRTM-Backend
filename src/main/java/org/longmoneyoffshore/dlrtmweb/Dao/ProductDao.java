package org.longmoneyoffshore.dlrtmweb.Dao;

import org.longmoneyoffshore.dlrtmweb.Entities.models.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ProductDao {
//public interface ProductDao extends CrudRepository {

    public Collection<Product> getAllProducts();

    public Collection<Product> getProductsByField(Object field);

    public Product getProductById(String productId);

    public void removeProductById(String productId);

    public void updateProduct (Product product);

    public void insertProduct (Product product);

    //possible alternative where true is returned when insertion succeeds and false when it does not
    //boolean insertProduct (Product product);

}
