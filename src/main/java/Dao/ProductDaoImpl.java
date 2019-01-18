package Dao;


//@Repository
//@Qualifier("mongoData")
//@Qualifier("fakeData")

/*
public class ProductDaoImpl implements ProductDao {

    Connection mongoConnection;
    private static Map<String, Product> products;
    static {
        products = new HashMap<String, Product>() {
            {
                //put (1, new Product(1,"Mario", "Math"));
                //put (2, new Product(2, "Valerie", "Literature"));
                //put (3, new Product(3, "John", "Sports"));
            }
        };
    }

    @Override
    public Collection<Product> getAllProducts() {
        return this.products.values();
    }


    @Override
    public Collection<Product> getProductsByField(Object field) {
        //TODO: this requires thoughtful implementation
        return null;
    }


    @Override
    public Product getProductById(String id) {

        return this.products.get(id);
    }

    @Override
    public void removeProductById(String id) {
        this.products.remove(id);
    }


    @Override
    public void updateProduct(Product product) {

        //TODO: unclear whether this implementation actually works ——— Needs testing

        //Product p = products.get(product.getProductUniqueID());
        //p.setCourse(product.getCourse());
        //p.setName(product.getName());

        this.products.put(product.getProductUniqueID(), product);
    }

    @Override
    public void insertProduct(Product product) {
        this.products.put(product.getProductUniqueID(), product);

    }





}
*/