package org.longmoneyoffshore.dlrtmweb.Entities.models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    //#1 Product id
    @Id
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
    private float productItemsInStockDecimal;
    private float productQuantityInStock; //TODO: make getters/setters/constructors
    private String productMeasurementUnit;

    private int productNeedToReorder = 0;

    private String productSpecialMentions;

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


    //Full Constructor
    public Product(String productUniqueID, String productName, String productManufacturer, String productCountryOfOrigin, String productDescription,
                   double productUnitPurchasePrice, double productUnitPrice, double productDiscounts, double productAdjustments, double productCredits,
                   double productDeductions, String productSpecialOffers, String currency, int productItemsInStockInt, float productItemsInStockDecimal,
                   float productQuantityInStock, int productNeedToReorder, String productMeasurementUnit, String productSpecialMentions) {

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

    public float getProductItemsInStockDecimal() {
        return productItemsInStockDecimal;
    }

    public void setProductItemsInStockDecimal(float productItemsInStockDecimal) {
        this.productItemsInStockDecimal = productItemsInStockDecimal;
    }

    public float getProductQuantityInStock() {
        return productQuantityInStock;
    }

    public void setProductQuantityInStock(float productQuantityInStock) {
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
                '}';
    }
}
