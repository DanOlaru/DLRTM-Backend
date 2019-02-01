package org.longmoneyoffshore.dlrtmweb.Service;

//import org.longmoneyoffshore.dlrtmweb.Dao.ProductDao;
import org.longmoneyoffshore.dlrtmweb.Dao.ProductDaoImpl;
import org.longmoneyoffshore.dlrtmweb.Entities.models.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class ProductService {

    //@Autowired
    private ProductDaoImpl myProductDao;

    //constructor
    public ProductService(ProductDaoImpl productDao) {
        this.myProductDao = productDao;
    }

    //methods
    public List<Product> getAllProducts() {
        return this.myProductDao.getAllProducts();
    }

    public List<Product> getProductsByField(Object field) {
        return this.myProductDao.getProductsByField(field);
    }

    public Product getProductById (String productId) {
        return this.myProductDao.getProductById (productId);
    }


    public void deleteProductById(String productId) {
        this.myProductDao.deleteProductById(productId);
    }


    public void updateProduct (Product product){

        this.myProductDao.updateProduct(product);
    }

    public void insertProduct (Product product) {
        this.myProductDao.insertProduct(product);
    }


    //alternate implementation

    /*@Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {

        List<Product> products = new ArrayList<>();

        productRepository.findAll().forEach(products :: add);

        return products;
    }

    public Product getProduct(String id) {
        //return products.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        //return productRepository.findById(id).get();

        return productRepository.findById(id).get();

    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(String id, Product product) {

        //!!!!
        productRepository.save(product);

    }

    public void deleteProduct(String id) {

        productRepository.deleteById(id);

    }*/

    //temporary data source




}
