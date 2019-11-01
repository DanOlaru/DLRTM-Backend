package org.longmoneyoffshore.dlrtmweb.entities.models.entity;

import org.longmoneyoffshore.dlrtmweb.entities.models.atomic.PhysicalProperties;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    //#1 Product id
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String productUniqueID;

    //#2 Product description
    private String productName;
    private String productManufacturer;
    private String productCountryOfOrigin;
    private String productDescription;

    private double productUnitPurchasePrice;
    private double productUnitPrice;
    private double productDiscounts;
    private double productAdjustments;
    private double productCredits;
    private double productDeductions;
    private String productSpecialOffers;
    private String currency;

    private int productItemsInStockInt;
    private double productItemsInStockDecimal;
    private double productQuantityInStock;
    private String productMeasurementUnit;

    private int productNeedToReorder = 0;

    private String productSpecialMentions;

    //@ManyToOne
    //@JoinColumn
    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "length", column = @Column(name = "LENGTH")),
            @AttributeOverride(name = "width", column = @Column(name = "WIDTH")),
            @AttributeOverride(name = "depth", column = @Column(name = "DEPTH")),
            @AttributeOverride(name = "height", column = @Column(name = "HEIGHT")),
            @AttributeOverride(name = "weight", column = @Column(name = "WEIGHT")),
            @AttributeOverride(name = "sizeMeasurementUnit", column = @Column(name = "SIZEMEASUREMENTUNIT")),
            @AttributeOverride(name = "weightMeasurementUnit", column = @Column(name = "WEIGHTMEASUREMENTUNIT"))
    })
    private PhysicalProperties productPhysicalProperties;

    //Internal Reference / Utility fields

    //Zero Constructor
    public Product() {}

    //Small Constructors
    public Product(String productUniqueID) {
        this.productUniqueID = productUniqueID;
    }

    public Product(String productUniqueID, String productName) {
        this.productUniqueID = productUniqueID;
        this.productName = productName;
    }


    public Product(String productUniqueID, String productName, String productManufacturer, String productCountryOfOrigin, String productDescription,
                   double productUnitPurchasePrice, double productUnitPrice, double productDiscounts, double productAdjustments, double productCredits,
                   double productDeductions, String productSpecialOffers, String currency, int productItemsInStockInt, double productItemsInStockDecimal,
                   double productQuantityInStock, int productNeedToReorder, String productMeasurementUnit, String productSpecialMentions) {

        this.productUniqueID = productUniqueID;
        this.productName = productName;
        this.productManufacturer = productManufacturer;
        this.productCountryOfOrigin = productCountryOfOrigin;
        this.productDescription = productDescription;
        this.productUnitPurchasePrice = productUnitPurchasePrice;
        this.productUnitPrice = productUnitPrice;
        this.productDiscounts = productDiscounts;
        this.productAdjustments = productAdjustments;
        this.productCredits = productCredits;
        this.productDeductions = productDeductions;
        this.productSpecialOffers = productSpecialOffers;
        this.currency = currency;
        this.productItemsInStockInt = productItemsInStockInt;
        this.productItemsInStockDecimal = productItemsInStockDecimal;
        this.productQuantityInStock = productQuantityInStock;
        this.productMeasurementUnit = productMeasurementUnit;
        this.productNeedToReorder = productNeedToReorder;
        this.productSpecialMentions = productSpecialMentions;
        this.productPhysicalProperties = new PhysicalProperties(); //blank
    }

    //Full Constructor
    public Product(String productUniqueID, String productName, String productManufacturer, String productCountryOfOrigin, String productDescription,
                   double productUnitPurchasePrice, double productUnitPrice, double productDiscounts, double productAdjustments, double productCredits,
                   double productDeductions, String productSpecialOffers, String currency, int productItemsInStockInt, double productItemsInStockDecimal,
                   double productQuantityInStock, int productNeedToReorder, String productMeasurementUnit, String productSpecialMentions,
                   PhysicalProperties physicalProperties) {

        this.productUniqueID = productUniqueID;
        this.productName = productName;
        this.productManufacturer = productManufacturer;
        this.productCountryOfOrigin = productCountryOfOrigin;
        this.productDescription = productDescription;
        this.productUnitPurchasePrice = productUnitPurchasePrice;
        this.productUnitPrice = productUnitPrice;
        this.productDiscounts = productDiscounts;
        this.productAdjustments = productAdjustments;
        this.productCredits = productCredits;
        this.productDeductions = productDeductions;
        this.productSpecialOffers = productSpecialOffers;
        this.currency = currency;
        this.productItemsInStockInt = productItemsInStockInt;
        this.productItemsInStockDecimal = productItemsInStockDecimal;
        this.productQuantityInStock = productQuantityInStock;
        this.productMeasurementUnit = productMeasurementUnit;
        this.productNeedToReorder = productNeedToReorder;
        this.productSpecialMentions = productSpecialMentions;
        this.productPhysicalProperties = physicalProperties;
    }

    //Full EXPLICIT-IN-TERMS-OF-BASIC-FIELDS Constructor
    public Product(String productUniqueID, String productName, String productManufacturer, String productCountryOfOrigin, String productDescription,
                   double productUnitPurchasePrice, double productUnitPrice, double productDiscounts, double productAdjustments, double productCredits,
                   double productDeductions, String productSpecialOffers, String currency, int productItemsInStockInt, double productItemsInStockDecimal,
                   double productQuantityInStock, int productNeedToReorder, String productMeasurementUnit, String productSpecialMentions,
                   double length, double width, double depth, double height, double weight, String sizeMeasurementUnit,
                   String weightMeasurementUnit) {

        this.productUniqueID = productUniqueID;
        this.productName = productName;
        this.productManufacturer = productManufacturer;
        this.productCountryOfOrigin = productCountryOfOrigin;
        this.productDescription = productDescription;
        this.productUnitPurchasePrice = productUnitPurchasePrice;
        this.productUnitPrice = productUnitPrice;
        this.productDiscounts = productDiscounts;
        this.productAdjustments = productAdjustments;
        this.productCredits = productCredits;
        this.productDeductions = productDeductions;
        this.productSpecialOffers = productSpecialOffers;
        this.currency = currency;
        this.productItemsInStockInt = productItemsInStockInt;
        this.productItemsInStockDecimal = productItemsInStockDecimal;
        this.productQuantityInStock = productQuantityInStock;
        this.productMeasurementUnit = productMeasurementUnit;
        this.productNeedToReorder = productNeedToReorder;
        this.productSpecialMentions = productSpecialMentions;
        this.productPhysicalProperties = new PhysicalProperties(length, width, depth, height, weight, sizeMeasurementUnit, weightMeasurementUnit);
    }


    //Constructor from other Product object
    public Product (Product product) {
        this.productUniqueID = product.getProductUniqueID();
        this.productName = product.productName;
        this.productManufacturer = product.productManufacturer;
        this.productCountryOfOrigin = product.productCountryOfOrigin;
        this.productDescription = product.getProductDescription();
        this.productUnitPurchasePrice = product.getProductUnitPurchasePrice();
        this.productUnitPrice = product.productUnitPrice;
        this.productDiscounts = product.productDiscounts;
        this.productAdjustments = product.productAdjustments;
        this.productSpecialOffers = product.productSpecialOffers;
        this.productItemsInStockInt = product.productItemsInStockInt;
        this.productItemsInStockDecimal = product.getProductItemsInStockDecimal();
        this.productNeedToReorder = product.getProductNeedToReorder();
        this.productSpecialMentions = product.getProductSpecialMentions();
    }


    public String getProductUniqueID() {
        return productUniqueID;
    }

    public void setProductUniqueID(String productUniqueID) {
        this.productUniqueID = productUniqueID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public String getProductCountryOfOrigin() {
        return productCountryOfOrigin;
    }

    public void setProductCountryOfOrigin(String productCountryOfOrigin) {
        this.productCountryOfOrigin = productCountryOfOrigin;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductUnitPurchasePrice() {
        return productUnitPurchasePrice;
    }

    public void setProductUnitPurchasePrice(double productUnitPurchasePrice) {
        this.productUnitPurchasePrice = productUnitPurchasePrice;
    }

    public double getProductUnitPrice() {
        return productUnitPrice;
    }

    public void setProductUnitPrice(double productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

    public double getProductDiscounts() {
        return productDiscounts;
    }

    public void setProductDiscounts(double productDiscounts) {
        this.productDiscounts = productDiscounts;
    }

    public double getProductAdjustments() {
        return productAdjustments;
    }

    public void setProductAdjustments(double productAdjustments) {
        this.productAdjustments = productAdjustments;
    }

    public double getProductCredits() {
        return productCredits;
    }

    public void setProductCredits(double productCredits) {
        this.productCredits = productCredits;
    }

    public double getProductDeductions() {
        return productDeductions;
    }

    public void setProductDeductions(double productDeductions) {
        this.productDeductions = productDeductions;
    }

    public String getProductSpecialOffers() {
        return productSpecialOffers;
    }

    public void setProductSpecialOffers(String productSpecialOffers) {
        this.productSpecialOffers = productSpecialOffers;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getProductItemsInStockInt() {
        return productItemsInStockInt;
    }

    public void setProductItemsInStockInt(int productItemsInStockInt) {
        this.productItemsInStockInt = productItemsInStockInt;
    }

    public double getProductItemsInStockDecimal() {
        return productItemsInStockDecimal;
    }

    public void setProductItemsInStockDecimal(double productItemsInStockDecimal) {
        this.productItemsInStockDecimal = productItemsInStockDecimal;
    }

    public double getProductQuantityInStock() {
        return productQuantityInStock;
    }

    public void setProductQuantityInStock(double productQuantityInStock) {
        this.productQuantityInStock = productQuantityInStock;
    }

    public String getProductMeasurementUnit() {
        return productMeasurementUnit;
    }

    public void setProductMeasurementUnit(String productMeasurementUnit) {
        this.productMeasurementUnit = productMeasurementUnit;
    }

    public int getProductNeedToReorder() {
        return productNeedToReorder;
    }

    public void setProductNeedToReorder(int productNeedToReorder) {
        this.productNeedToReorder = productNeedToReorder;
    }

    public String getProductSpecialMentions() {
        return productSpecialMentions;
    }

    public void setProductSpecialMentions(String productSpecialMentions) {
        this.productSpecialMentions = productSpecialMentions;
    }

    public PhysicalProperties getProductPhysicalProperties() {
        return productPhysicalProperties;
    }

    public void setProductPhysicalProperties(PhysicalProperties productPhysicalProperties) {
        this.productPhysicalProperties = productPhysicalProperties;
    }

   @Override
    public String toString() {
        return "Product{" +
                "productUniqueID='" + productUniqueID.trim() + '\'' + "\n" +
                ", productName='" + productName.trim() + '\'' + "\n" +
                ", productManufacturer='" + productManufacturer.trim() + '\'' + "\n" +
                ", productCountryOfOrigin='" + productCountryOfOrigin.trim() + '\'' + "\n" +
                ", productDescription='" + productDescription.trim() + '\'' + "\n" +
                ", productUnitPurchasePrice=" + productUnitPurchasePrice + "\n" +
                ", productUnitPrice=" + productUnitPrice + "\n" +
                ", productDiscounts=" + productDiscounts + "\n" +
                ", productAdjustments=" + productAdjustments + "\n" +
                ", productCredits=" + productCredits + "\n" +
                ", productDeductions=" + productDeductions + "\n" +
                ", productSpecialOffers='" + productSpecialOffers.trim() + '\'' + "\n" +
                ", currency='" + currency.trim() + '\'' + "\n" +
                ", productItemsInStockInt=" + productItemsInStockInt + "\n" +
                ", productItemsInStockDecimal=" + productItemsInStockDecimal + "\n" +
                ", productQuantityInStock=" + productQuantityInStock + "\n" +
                ", productMeasurementUnit='" + productMeasurementUnit.trim() + '\'' + "\n" +
                ", productNeedToReorder=" + productNeedToReorder + "\n" +
                ", productSpecialMentions='" + productSpecialMentions.trim() + '\'' + "\n" +
                ", productPhysicalProperties=" + productPhysicalProperties.toString() +
                '}';
    }

    public void trim() {

        this.productUniqueID = productUniqueID.trim();
        this.productName = productName.trim();
        this.productManufacturer = productManufacturer.trim();
        this.productCountryOfOrigin = productCountryOfOrigin.trim();
        this.productDescription = productDescription.trim();
        this.productUnitPurchasePrice = productUnitPurchasePrice;
        this.productUnitPrice = productUnitPrice;
        this.productDiscounts = productDiscounts;
        this.productAdjustments = productAdjustments;
        this.productCredits = productCredits;
        this.productDeductions = productDeductions;
        this.productSpecialOffers = productSpecialOffers.trim();
        this.currency = currency.trim();
        this.productItemsInStockInt = productItemsInStockInt;
        this.productItemsInStockDecimal = productItemsInStockDecimal;
        this.productQuantityInStock = productQuantityInStock;
        this.productMeasurementUnit = productMeasurementUnit.trim();
        this.productNeedToReorder = productNeedToReorder;
        this.productSpecialMentions = productSpecialMentions.trim();
        //this.productPhysicalProperties = physicalProperties.trim();


    }

}
