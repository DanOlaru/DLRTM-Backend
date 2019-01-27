package org.longmoneyoffshore.dlrtmweb.Dao;

import org.longmoneyoffshore.dlrtmweb.Entities.models.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

//@Qualifier("")
@Component
public class ProductDaoImpl implements ProductDao {

    /*static {
        products = new HashMap<String, Product>() {
            {
                //put (1, new Product(1,"Mario", "Math"));
            }
        };
    }*/

    //@Autowired
    private DataSource dataSource;
    //@Autowired
    //private JdbcTemplate jdbcTemplate;
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    //TODO: is this relevant?
    public Product getProductXml(String productId) {

        Connection conn = null;

        try {

            conn = dataSource.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM product where id = ?");
            ps.setString(1, productId);

            Product product = null;
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                //product =  new Product(productId,rs.getString("name"));
                product =  new Product(String.valueOf(productId),rs.getString("productName"));
            }

            rs.close();
            ps.close();

            return product;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }



    @Override
    public Product getProductById (String productId) {

        //TODO: has problems when there are several entries with the same ID
        String sql = "SELECT * FROM product where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {productId}, new ProductMapper());



        //TODO: is it possible to do the above with namedParameter?
        //Product product = namedParameterJdbcTemplate.query(sql, new ProductMapper()).get(0);

        //return product;
    }


    public int getProductCount() {
        String sql = "SELECT COUNT(*) FROM product";

        //TODO: is this property set in the spring.xml?
        //jdbcTemplate.setDataSource(getDataSource());

        int count = jdbcTemplate.queryForObject(sql,Integer.class);

        return count;
    }


    public int getProductWPropertyCount(){

        //TODO: not done yet

        int count = 0;
        String sql = "SELECT COUNT(*) FROM CIRCLE";

        //int count = namedParameterJdbcTemplate.queryForObject(sql, commandsMap, new ProductMapper ());
        List<Product> productsWithProperty = namedParameterJdbcTemplate.query(sql, new ProductMapper());

        count = productsWithProperty.size();


        return count;

    }

    public String getProductName(String productId) {
        String sql = "SELECT NAME FROM CIRCLE WHERE ID = ?";

        //String productName = jdbcTemplate.queryForObject(sql,String.class);

        String productName = jdbcTemplate.queryForObject(sql, new Object[] {productId}, String.class); //TODO: this is the old implementation

        //TODO: new implementation
        productName = namedParameterJdbcTemplate.query(sql, new ProductMapper()).get(0).getProductName();

        //TODO: potentially redundant

        return productName;
    }


    @Override
    public List<Product> getAllProducts() {
        String sql = "SELECT * FROM products";

        return jdbcTemplate.query(sql, new ProductMapper());
        //return namedParameterJdbcTemplate.query(sql, new ProductMapper());
    }

    @Override
    public void insertProduct (Product product) {

        //TODO: First Implementation
        //String sql = "INSERT INTO CIRCLE (ID, NAME) VALUES (?, ?)";
        //jdbcTemplate.update(sql, new Object[] {product.getProductUniqueID(), product.getProductName()});


        //TODO: Second Implementation w/ named parameters
        String sql = "INSERT INTO products (uniqueID, name, manufacturer, countryOfOrigin, description, unitPurchasePrice," +
                "unitPrice, discounts, adjustments, credits, deductions, specialOffers, currency, itemsInStockInt, itemsInStockDecimal," +
                "quantityInStock, needToReorder, measurementUnit, specialMentions)" +

                "VALUES (:uniqueID, :name, :manufacturer, :countryOfOrigin," +
                ":description, :unitPurchasePrice, :unitPrice, :discounts, :adjustments, :credits, :deductions, :specialOffers," +
                ":currency, :itemsInStockInt, :itemsInStockDecimal, :quantityInStock, :needToReorder, :measurementUnit," +
                ":specialMentions)";

        SqlParameterSource namedParameters = new MapSqlParameterSource("uniqueID", product.getProductUniqueID())
                .addValue("name", product.getProductName())
                .addValue("manufacturer", product.getProductManufacturer())
                .addValue("countryOfOrigin", product.getProductCountryOfOrigin())
                .addValue("description", product.getProductDescription())
                .addValue("unitPurchasePrice", product.getProductUnitPurchasePrice())
                .addValue("unitPrice", product.getProductUnitPrice())
                .addValue("discounts", product.getProductDiscounts())
                .addValue("adjustments", product.getProductAdjustments())
                .addValue("credits", product.getProductCredits())
                .addValue("deductions", product.getProductDeductions())
                .addValue("specialOffers", product.getProductSpecialOffers())
                .addValue("currency", product.getCurrency())
                .addValue("itemsInStockInt", product.getProductItemsInStockInt())
                .addValue("itemsInStockDecimal", product.getProductItemsInStockDecimal())
                .addValue("quantityInStock", product.getProductQuantityInStock())
                .addValue("needToReorder", product.getProductNeedToReorder())
                .addValue("measurementUnit", product.getProductMeasurementUnit())
                .addValue("specialMentions", product.getProductSpecialMentions());

        namedParameterJdbcTemplate.update(sql, namedParameters);

        //jdbcTemplate.update(sql, new Object[] {product.getId(), product.getName()});
    }



    public void insertProductList(List<Product> products) {
        products.forEach(p -> insertProduct(p));
    }


    @Override
    public void deleteProductById(String id) {
        //this.products.remove(id);

        String sql = "DELETE FROM products WHERE uniqueID IN (?)";
        jdbcTemplate.update(sql,new Object[] {id});

    }

    //TODO: why is this here?
    public void createClientTable () {
        String sql = "CREATE TABLE TRIANGLE (ID INTEGER, NAME VARCHAR(50))";
        jdbcTemplate.execute(sql);
    }


    @Override
    public List<Product> getProductsByField(Object field) {
        //TODO: implement the capacity to search for object based on different fields
        // Heavy Duty

        return null;
    }

    @Override
    public void updateProduct(Product product) {

        String sql = "UPDATE products (uniqueID, name, manufacturer, countryOfOrigin, description, unitPurchasePrice, " +
                "unitPrice, discounts, adjustments, credits, deductions,specialOffers, currency, itemsInStockInt, itemsInStockDecimal, " +
                "quantityInStock, needToReorder, measurementUnit, specialMentions) " +

                "VALUES (:uniqueID, :name, :manufacturer, :countryOfOrigin, :description, :unitPurchasePrice, " +
                ":unitPrice, :discounts, :adjustments, :credits, :deductions, :specialOffers, :currency, :itemsInStockInt, :itemsInStockDecimal, " +
                ":quantityInStock, :needToReorder, :measurementUnit, :specialMentions)";

        SqlParameterSource namedParameters = new MapSqlParameterSource("uniqueID", product.getProductUniqueID())
                .addValue("name", product.getProductName())
                .addValue("manufacturer", product.getProductManufacturer())
                .addValue("countryOfOrigin", product.getProductCountryOfOrigin())
                .addValue("description", product.getProductDescription())
                .addValue("unitPurchasePrice", product.getProductUnitPurchasePrice())
                .addValue("unitPrice", product.getProductUnitPrice())
                .addValue("discounts", product.getProductDiscounts())
                .addValue("adjustments", product.getProductAdjustments())
                .addValue("credits", product.getProductCredits())
                .addValue("deductions", product.getProductDeductions())
                .addValue("specialOffers", product.getProductSpecialOffers())
                .addValue("currency", product.getCurrency())
                .addValue("itemsInStockInt", product.getProductItemsInStockInt())
                .addValue("itemsInStockDecimal", product.getProductItemsInStockDecimal())
                .addValue("quantityInStock", product.getProductQuantityInStock())
                .addValue("needToReorder", product.getProductNeedToReorder())
                .addValue("measurementUnit", product.getProductMeasurementUnit())
                .addValue("specialMentions", product.getProductSpecialMentions());

        namedParameterJdbcTemplate.update(sql, namedParameters);
    }


    //TODO: mapping the DB table colums to individual fields in the data object
    private static final class ProductMapper implements RowMapper<Product> {

        public ProductMapper() {};

        @Override
        public Product mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Product product = new Product();

            product.setProductUniqueID(resultSet.getString("uniqueID"));

            product.setProductName(resultSet.getString("name"));
            product.setProductManufacturer(resultSet.getString("manufacturer"));
            product.setProductCountryOfOrigin(resultSet.getString("countryOfOrigin"));
            product.setProductDescription(resultSet.getString("description"));

            product.setProductUnitPurchasePrice(resultSet.getDouble("unitPurchasePrice"));
            product.setProductUnitPrice(resultSet.getDouble("unitPrice"));
            product.setProductDiscounts(resultSet.getDouble("discounts"));
            product.setProductAdjustments(resultSet.getDouble("adjustments"));
            product.setProductCredits(resultSet.getDouble("credits"));
            product.setProductDeductions(resultSet.getDouble("deductions"));
            product.setProductSpecialOffers(resultSet.getString("specialOffers"));
            product.setCurrency (resultSet.getString("currency"));

            product.setProductItemsInStockInt(resultSet.getInt("itemsInStockInt"));
            product.setProductItemsInStockDecimal(resultSet.getFloat("itemsInStockDecimal"));
            product.setProductQuantityInStock(resultSet.getFloat("quantityInStock"));
            product.setProductNeedToReorder(resultSet.getInt("needToReorder"));
            product.setProductMeasurementUnit(resultSet.getString("measurementUnit"));

            product.setProductSpecialMentions(resultSet.getString("specialMentions"));

            return product;
        }
    }

}