package org.longmoneyoffshore.dlrtmweb.dao;

import org.longmoneyoffshore.dlrtmweb.entities.models.atomic.PhysicalProperties;
import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Product;
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

    private DataSource dataSource;
    //private BasicDataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate()
    {
        return namedParameterJdbcTemplate;
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    public DataSource getDataSource() {
        return dataSource;
    }

    //@Autowired
    public void setDataSource(DataSource dataSource) {
    //public void setDataSource(BasicDataSource dataSource) {

        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void createTable() {
        String sql = "CREATE TABLE products (uniqueID char(10), name char(50), manufacturer char(50)," +
                "                       countryOfOrigin char(50), description char(150), unitPurchasePrice float," +
                "                       unitPrice float, discounts float, adjustments float," +
                "                       credits float, deductions float, specialOffers char(50)," +
                "                       currency char(10), itemsInStockInt int, itemsInStockDecimal float," +
                "                       quantityInStock float, needToReorder int, measurementUnit char(10)," +
                "                       specialMentions char(150), length float, width float, depth float, height float," +
                "                       weight float, sizeMeasurementUnit char(15), weightMeasurementUnit char(15))";

        this.jdbcTemplate.execute(sql);
    }

    public void dropTable() {

        String sql = "DROP TABLE products";

                this.jdbcTemplate.execute(sql);
    }


    @Override
    public Product getProductById (String productId) {

        System.out.println("DAO: REQUEST /GET PRODUCT BY ID: " + productId);

        String sql = "SELECT * FROM products where uniqueID = " + productId;

        //return jdbcTemplate.queryForObject(sql, new Object[] {productId}, new ProductMapper());

        return namedParameterJdbcTemplate.query(sql, new ProductMapper()).get(0);
    }

    public int getProductCount() {
        String sql = "SELECT COUNT(*) FROM products";

        //TODO: is this property set in the spring.xml?
        //jdbcTemplate.setDataSource(getDataSource());

        int count = jdbcTemplate.queryForObject(sql,Integer.class);

        return count;
    }

    public int getProductWPropertyCount(){

        //TODO: not done yet

        int count = 0;
        String sql = "SELECT COUNT(*) FROM products";

        //int count = namedParameterJdbcTemplate.queryForObject(sql, commandsMap, new ProductMapper ());
        List<Product> productsWithProperty = namedParameterJdbcTemplate.query(sql, new ProductMapper());

        count = productsWithProperty.size();

        return count;

    }

    public String getProductName(String productId) {
        String sql = "SELECT name FROM products WHERE uniqueID = ?";

        //String productName = jdbcTemplate.queryForObject(sql,String.class);

        String productName = jdbcTemplate.queryForObject(sql, new Object[] {productId}, String.class); //TODO: this is the old implementation

        //TODO: new implementation
        //productName = namedParameterJdbcTemplate.query(sql, new ProductMapper()).get(0).getProductName();

        return productName;
    }


    @Override
    public List<Product> getAllProducts() {

        //System.out.println("PRODUCTDAOIMPL: REQUEST /GET ALL PRODUCTS _ XXXXXXXXXX");
        //System.out.println("WHAT: DATASOURCE " + dataSource.toString());


        String sql = "SELECT * FROM products";

        //return jdbcTemplate.query(sql, new ProductMapper());

        //List<Product> resultsUntrimmed = Arrays.asList(namedParameterJdbcTemplate.query(sql, new ProductMapper());
        //List<Product> results = Arrays.asList(resultsUntrimmed.stream())); //TODO: must trim

        //return results;

        System.out.println("PRODUCTDAOIMPL: getAllProducts() :" + sql);
        return namedParameterJdbcTemplate.query(sql, new ProductMapper());
    }

    @Override
    public void insertProduct (Product product) {

        String sql = "INSERT INTO products (uniqueID, name, manufacturer, countryOfOrigin, description, unitPurchasePrice," +
                "unitPrice, discounts, adjustments, credits, deductions, specialOffers, currency, itemsInStockInt, itemsInStockDecimal," +
                "quantityInStock, needToReorder, measurementUnit, specialMentions, length, width, depth, height, weight, sizeMeasurementUnit," +
                "weightMeasurementUnit)" +

                "VALUES (:uniqueID, :name, :manufacturer, :countryOfOrigin," +
                ":description, :unitPurchasePrice, :unitPrice, :discounts, :adjustments, :credits, :deductions, :specialOffers," +
                ":currency, :itemsInStockInt, :itemsInStockDecimal, :quantityInStock, :needToReorder, :measurementUnit," +
                ":specialMentions, :length, :width, :depth, :height, :weight, :sizeMeasurementUnit," +
                ":weightMeasurementUnit)";

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
                .addValue("specialMentions", product.getProductSpecialMentions())
                .addValue("length", product.getProductPhysicalProperties().getLength())
                .addValue("width", product.getProductPhysicalProperties().getWidth())
                .addValue("depth", product.getProductPhysicalProperties().getDepth())
                .addValue("height", product.getProductPhysicalProperties().getHeight())
                .addValue("weight", product.getProductPhysicalProperties().getWeight())
                .addValue("sizeMeasurementUnit", product.getProductPhysicalProperties().getSizeMeasurementUnit())
                .addValue("weightMeasurementUnit", product.getProductPhysicalProperties().getWeightMeasurementUnit());

        namedParameterJdbcTemplate.update(sql, namedParameters);
    }


    public void insertProductList(List<Product> products) {
        products.forEach(p -> insertProduct(p));
    }


    @Override
    public void deleteProductById(String id) {
        String sql = "DELETE FROM products WHERE uniqueID IN (?)";
        jdbcTemplate.update(sql,new Object[] {id});

    }

    //TODO: why is this here?
    public void createClientTable () {
        String sql = "CREATE TABLE CLIENTS (ID INTEGER, NAME VARCHAR(50))";
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

        //String SQL = "update Student set age = ? where id = ?";


        String sql = "UPDATE products set name = :name, manufacturer = :manufacturer, countryOfOrigin = :countryOfOrigin, description = :description," +
                "unitPurchasePrice = :unitPurchasePrice, unitPrice = :unitPrice, discounts = :discounts, adjustments = :adjustments, credits = :credits, deductions = :deductions," +
                "specialOffers = :specialOffers, currency = :currency, itemsInStockInt = :itemsInStockInt, itemsInStockDecimal = :itemsInStockDecimal," +
                "quantityInStock = :quantityInStock, needToReorder = :needToReorder, measurementUnit = :measurementUnit, specialMentions = :specialMentions, " +
                "length = :length, width = :width, depth = :depth, height = :height, weight = :weight, sizeMeasurementUnit = :sizeMeasurementUnit, weightMeasurementUnit = :weightMeasurementUnit " +
                "where uniqueID = :uniqueID";

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
                .addValue("specialMentions", product.getProductSpecialMentions())

                .addValue("length", product.getProductPhysicalProperties().getLength())
                .addValue("width", product.getProductPhysicalProperties().getWidth())
                .addValue("depth", product.getProductPhysicalProperties().getDepth())
                .addValue("height", product.getProductPhysicalProperties().getHeight())
                .addValue("weight", product.getProductPhysicalProperties().getWeight())
                .addValue("sizeMeasurementUnit", product.getProductPhysicalProperties().getSizeMeasurementUnit())
                .addValue("weightMeasurementUnit", product.getProductPhysicalProperties().getWeightMeasurementUnit());


        namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    public void updatedProductSublist (List<Product> subList) {
        subList.forEach(p -> updateProduct(p));
    }

    //mapping DB table columns to individual fields in the data object
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
            product.setProductItemsInStockDecimal(resultSet.getDouble("itemsInStockDecimal"));
            product.setProductQuantityInStock(resultSet.getDouble("quantityInStock"));
            product.setProductMeasurementUnit(resultSet.getString("measurementUnit"));
            product.setProductNeedToReorder(resultSet.getInt("needToReorder"));

            product.setProductSpecialMentions(resultSet.getString("specialMentions"));

            //read product physical dimensions
            PhysicalProperties physicalProperties = new PhysicalProperties();

            physicalProperties.setLength(resultSet.getDouble("length"));
            physicalProperties.setWidth(resultSet.getDouble("width"));
            physicalProperties.setDepth(resultSet.getDouble("depth"));
            physicalProperties.setHeight(resultSet.getDouble("height"));
            physicalProperties.setWeight(resultSet.getDouble("weight"));
            physicalProperties.setSizeMeasurementUnit(resultSet.getString("sizeMeasurementUnit"));
            physicalProperties.setWeightMeasurementUnit(resultSet.getString("weightMeasurementUnit"));

            product.setProductPhysicalProperties(physicalProperties);

            return product;
        }
    }

}