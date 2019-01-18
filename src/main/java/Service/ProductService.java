package Service;

//import Dao.ProductDao;
import Entity.models.entity.Product;
import Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@Service
public class ProductService {

    /*@Autowired
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
    }*/


    //alternate implementation

    @Autowired
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

    }

    //temporary data source

    private List<Product> products =  new ArrayList<>(Arrays.asList(
            new Product("0001", "Blender", "Phillips", "Netherlands",
                    "food blender", 10.67,0,0,10,0,
                    "Free Bread Knife",100,0,0,0,
                    "Unit","Pending recalls"),

            new Product("0002", "Mixer", "Sony", "Japan",
                    "food mixer", 20.25,2,-1,20,10,
                    "10% off blades",180,0,0,0,
                    "Unit","best in class"),

            new Product("0003", "Grinder", "Sanyo", "South Korea",
                    "coffee grinder", 34.43,3,-3,0,14,
                    "free CD player",60,0,0,20,
                    "Unit","new model"),

            new Product("0004", "Coffee Maker", "JVC", "Germany",
                    "coffee maker", 16.15,11,20,3,20,
                    "5 year warranty",10,0,0,70,
                    "Unit","buyer's favorite"))

    );


}
