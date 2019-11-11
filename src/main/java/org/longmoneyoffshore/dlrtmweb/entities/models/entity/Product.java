package org.longmoneyoffshore.dlrtmweb.entities.models.entity;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.entities.models.atomic.PhysicalProperties;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    private String productUniqueID;

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

    /*@Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "length", column = @Column(name = "LENGTH")),
            @AttributeOverride(name = "width", column = @Column(name = "WIDTH")),
            @AttributeOverride(name = "depth", column = @Column(name = "DEPTH")),
            @AttributeOverride(name = "height", column = @Column(name = "HEIGHT")),
            @AttributeOverride(name = "weight", column = @Column(name = "WEIGHT")),
            @AttributeOverride(name = "sizeMeasurementUnit", column = @Column(name = "SIZEMEASUREMENTUNIT")),
            @AttributeOverride(name = "weightMeasurementUnit", column = @Column(name = "WEIGHTMEASUREMENTUNIT"))
    })*/

    @Nullable
    private PhysicalProperties productPhysicalProperties;


    public Product() { }

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
