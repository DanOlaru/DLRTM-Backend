package org.longmoneyoffshore.dlrtmweb.repository;

import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.longmoneyoffshore.dlrtmweb.entities.entity.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
@Data
public class ProductDaoImpl implements ProductDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS products (productID int NOT NULL AUTO_INCREMENT, name char(50), manufacturer char(50)," +
                " country char(50), description char(150), unitPrice float, discounts float," +
                " specialOffers char(50), itemsInStockInt int, specialMentions char(150), PRIMARY KEY (productID))";

        this.jdbcTemplate.execute(sql);
    }

    public void clearTable() {
        createTable();

        String sql = "TRUNCATE TABLE products";
        this.jdbcTemplate.execute(sql);
    }

    public void dropTable() {
        String sql = "DROP TABLE products";
        this.jdbcTemplate.execute(sql);
    }

    @Override
    public Product getProductById(int productId) {

        String sql = "SELECT * FROM products where productID = " + productId;

        return namedParameterJdbcTemplate.query(sql, new ProductMapper()).get(0);
    }

    public int getProductCount() {
        String sql = "SELECT COUNT(*) FROM products";

        int count = jdbcTemplate.queryForObject(sql, Integer.class);

        return count;
    }


    public String getProductName(int productId) {
        String sql = "SELECT name FROM products WHERE productID = ?";

        String productName = jdbcTemplate.queryForObject(sql, new Object[]{productId}, String.class); //TODO: this is the old implementation

        return productName;
    }

    @Override
    public List<Product> getAllProducts() {

        createTable();

        String sql = "SELECT * FROM products";

        return namedParameterJdbcTemplate.query(sql, new ProductMapper());
    }

    @Override
    public void insertProduct(Product product) {

        createTable();

        String sql = "INSERT INTO products (productID, name, manufacturer, country, description," +
                "unitPrice, specialOffers, itemsInStockInt, specialMentions)" +

                "VALUES (:productID, :name, :manufacturer, :country, :description, :unitPrice, :specialOffers," +
                ":itemsInStockInt, :specialMentions)";

        SqlParameterSource namedParameters = new MapSqlParameterSource("productID", product.getProductID())
                .addValue("name", product.getProductName())
                .addValue("manufacturer", product.getProductManufacturer())
                .addValue("country", product.getProductCountry())
                .addValue("description", product.getProductDescription())
                .addValue("unitPrice", product.getProductUnitPrice())
                .addValue("specialOffers", product.getProductSpecialOffers())
                .addValue("itemsInStockInt", product.getProductItemsInStockInt())
                .addValue("specialMentions", product.getProductSpecialMentions());

        namedParameterJdbcTemplate.update(sql, namedParameters);
    }

   public void insertProductHibernate(Product product) {

        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void insertProducts(List<Product> products) {
        products.forEach(p -> insertProduct(p));
    }


    @Override
    public void deleteProductById(int id) {
        String sql = "DELETE FROM products WHERE productID IN (?)";
        jdbcTemplate.update(sql, new Object[]{id});

    }


    @Override
    public List<Product> getProductsByField(Object field) {
        //TODO: implement the capacity to search for object based on different fields
        // Heavy Duty

        return null;
    }

    @Override
    public void updateProduct(Product product) {

        String sql = "UPDATE products set name = :name, manufacturer = :manufacturer, country = :country, description = :description," +
                "unitPrice = :unitPrice, specialOffers = :specialOffers, itemsInStockInt = :itemsInStockInt, specialMentions = :specialMentions, " +
                "where productID = :productID";

        SqlParameterSource namedParameters = new MapSqlParameterSource("productID", product.getProductID())
                .addValue("name", product.getProductName())
                .addValue("manufacturer", product.getProductManufacturer())
                .addValue("country", product.getProductCountry())
                .addValue("description", product.getProductDescription())
                .addValue("unitPrice", product.getProductUnitPrice())
                .addValue("specialOffers", product.getProductSpecialOffers())
                .addValue("itemsInStockInt", product.getProductItemsInStockInt())
                .addValue("specialMentions", product.getProductSpecialMentions());


        namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    public void updatedProductSublist(List<Product> subList) { subList.forEach(p -> updateProduct(p)); }

    private static final class ProductMapper implements RowMapper<Product> {

        public ProductMapper() { }

        @Override
        public Product mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Product product = new Product();

            product.setProductID(resultSet.getInt("productID"));
            product.setProductName(resultSet.getString("name"));
            product.setProductManufacturer(resultSet.getString("manufacturer"));
            product.setProductCountry(resultSet.getString("country"));
            product.setProductDescription(resultSet.getString("description"));
            product.setProductUnitPrice(resultSet.getDouble("unitPrice"));
            product.setProductSpecialOffers(resultSet.getString("specialOffers"));
            product.setProductItemsInStockInt(resultSet.getInt("itemsInStockInt"));
            product.setProductSpecialMentions(resultSet.getString("specialMentions"));

            return product;
        }
    }

}