package org.longmoneyoffshore.dlrtmweb.Repository;
import org.longmoneyoffshore.dlrtmweb.Entities.models.entity.Product;
import org.springframework.data.repository.CrudRepository;



public interface ProductRepository extends CrudRepository<Product, String>  {

    //Spring is supposed to provide this functionality

    //getAllProducts();
    //getProduct(String id);
    //updateProduct(Product product);
    //deleteProduct(String id)

}
