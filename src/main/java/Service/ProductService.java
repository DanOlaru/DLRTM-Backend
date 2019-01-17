package Service;

import Dao.ProductDao;
import Entity.models.entity.Product;

import java.util.Collection;

public class ProductService {

    //@Autowired
    //@Qualifier("mongoData")
    private ProductDao myProductDao;

    public ProductService(ProductDao productDao) {
        this.myProductDao = productDao;
    }

    public Collection<Product> getAllProducts() {
        return this.myProductDao.getAllProducts();
    }


    public Collection<Product> getProductsByField(Object field) {
        return this.myProductDao.getProductsByField(field);
    }

    public Product getProductById (String productId) {
        return this.myProductDao.getProductById (productId);
    }


    public void removeProductById(String productId) {
        this.myProductDao.removeProductById (productId);
    }


    public void updateProduct (Product product){

        this.myProductDao.updateProduct(product);
    }

    public void insertProduct (Product product) {
        this.myProductDao.insertProduct(product);
    }


}
