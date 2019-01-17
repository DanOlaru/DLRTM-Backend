package Entity.models.entity;

public class TransactedProduct extends Product {

    //TODO: questionable if these are needed
    private int productTransactedUnits;
    private double productTransactedUnitsDecimal;
    private double productTransactedQuantity;

    private double productTransactedUnitPrice;
    private double productTransactedDiscount;
    private double productTransactedAdjustments;
    private double productTransactedCredits;
    private String productTransactedCreditType; //reason for the credit
    private double productTransactedDeductions;

    private double productTransactedOtherCharges;

    private String productTransactedSpecialOffers;

    //empty constructor
    public TransactedProduct () {}

    //full constructor

    public TransactedProduct(String productUniqueID, String productName, String productManufacturer, String productCountryOfOrigin,
                             String productDescription, double productPrice, double productDiscounts, double productAdjustments, double productCredits,
                             double productDeductions, String productSpecialOffers, int productItemsInStockInt, float productItemsInStockDecimal,
                             float productQuantityInStock, int productNeedToReorder, String productMeasurementUnit, String productSpecialMentions,
                             int productTransactedUnits, double productTransactedUnitsDecimal, double productTransactedQuantity,
                             double productTransactedUnitPrice, double productTransactedDiscount, double productTransactedAdjustments,
                             double productTransactedCredits, String productTransactedCreditType, double productTransactedDeductions,
                             double productTransactedOtherCharges, String productTransactedSpecialOffers) {

        super(productUniqueID, productName, productManufacturer, productCountryOfOrigin, productDescription, productPrice, productDiscounts,
                productAdjustments, productCredits, productDeductions, productSpecialOffers, productItemsInStockInt, productItemsInStockDecimal,
                productQuantityInStock, productNeedToReorder, productMeasurementUnit, productSpecialMentions);


        this.productTransactedUnits = productTransactedUnits;
        this.productTransactedUnitsDecimal = productTransactedUnitsDecimal;
        this.productTransactedQuantity = productTransactedQuantity;
        this.productTransactedUnitPrice = productTransactedUnitPrice;
        this.productTransactedDiscount = productTransactedDiscount;
        this.productTransactedAdjustments = productTransactedAdjustments;
        this.productTransactedCredits = productTransactedCredits;
        this.productTransactedCreditType = productTransactedCreditType;
        this.productTransactedDeductions = productTransactedDeductions;
        this.productTransactedOtherCharges = productTransactedOtherCharges;
        this.productTransactedSpecialOffers = productTransactedSpecialOffers;
    }

    public TransactedProduct(Product product, int productTransactedUnits, double productTransactedUnitsDecimal, double productTransactedQuantity, double productTransactedUnitPrice, double productTransactedDiscount, double productTransactedAdjustments, double productTransactedCredits, String productTransactedCreditType, double productTransactedDeductions, double productTransactedOtherCharges, String productTransactedSpecialOffers) {
        super(product);
        this.productTransactedUnits = productTransactedUnits;
        this.productTransactedUnitsDecimal = productTransactedUnitsDecimal;
        this.productTransactedQuantity = productTransactedQuantity;
        this.productTransactedUnitPrice = productTransactedUnitPrice;
        this.productTransactedDiscount = productTransactedDiscount;
        this.productTransactedAdjustments = productTransactedAdjustments;
        this.productTransactedCredits = productTransactedCredits;
        this.productTransactedCreditType = productTransactedCreditType;
        this.productTransactedDeductions = productTransactedDeductions;
        this.productTransactedOtherCharges = productTransactedOtherCharges;
        this.productTransactedSpecialOffers = productTransactedSpecialOffers;
    }

    //constructor of TransactedProduct from Product

    public TransactedProduct(Product product) {
        super(product);
        this.productTransactedUnits = 0;
        this.productTransactedUnitsDecimal = 0;
        this.productTransactedQuantity = 0;
        this.productTransactedUnitPrice = product.getProductUnitPrice();
        this.productTransactedDiscount = product.getProductDiscounts();
        this.productTransactedAdjustments = product.getProductAdjustments();
        this.productTransactedCredits = product.getProductCredits();
        this.productTransactedCreditType = "";
        this.productTransactedDeductions = product.getProductDeductions();
        this.productTransactedOtherCharges = 0;
        this.productTransactedSpecialOffers = product.getProductSpecialOffers();
    }

    public int getProductTransactedUnits() {
        return productTransactedUnits;
    }

    public void setProductTransactedUnits(int productTransactedUnits) {
        this.productTransactedUnits = productTransactedUnits;
    }

    public double getProductTransactedUnitsDecimal() {
        return productTransactedUnitsDecimal;
    }

    public void setProductTransactedUnitsDecimal(double productTransactedUnitsDecimal) {
        this.productTransactedUnitsDecimal = productTransactedUnitsDecimal;
    }

    public double getProductTransactedQuantity() {
        return productTransactedQuantity;
    }

    public void setProductTransactedQuantity(double productTransactedQuantity) {
        this.productTransactedQuantity = productTransactedQuantity;
    }

    public double getProductTransactedUnitPrice() {
        return productTransactedUnitPrice;
    }

    public void setProductTransactedUnitPrice(double productTransactedUnitPrice) {
        this.productTransactedUnitPrice = productTransactedUnitPrice;
    }

    public double getProductTransactedDiscount() {
        return productTransactedDiscount;
    }

    public void setProductTransactedDiscount(double productTransactedDiscount) {
        this.productTransactedDiscount = productTransactedDiscount;
    }

    public double getProductTransactedAdjustments() {
        return productTransactedAdjustments;
    }

    public void setProductTransactedAdjustments(double productTransactedAdjustments) {
        this.productTransactedAdjustments = productTransactedAdjustments;
    }

    public double getProductTransactedCredits() {
        return productTransactedCredits;
    }

    public void setProductTransactedCredits(double productTransactedCredits) {
        this.productTransactedCredits = productTransactedCredits;
    }

    public String getProductTransactedCreditType() {
        return productTransactedCreditType;
    }

    public void setProductTransactedCreditType(String productTransactedCreditType) {
        this.productTransactedCreditType = productTransactedCreditType;
    }

    public double getProductTransactedDeductions() {
        return productTransactedDeductions;
    }

    public void setProductTransactedDeductions(double productTransactedDeductions) {
        this.productTransactedDeductions = productTransactedDeductions;
    }

    public double getProductTransactedOtherCharges() {
        return productTransactedOtherCharges;
    }

    public void setProductTransactedOtherCharges(double productTransactedOtherCharges) {
        this.productTransactedOtherCharges = productTransactedOtherCharges;
    }

    public String getProductTransactedSpecialOffers() {
        return productTransactedSpecialOffers;
    }

    public void setProductTransactedSpecialOffers(String productTransactedSpecialOffers) {
        this.productTransactedSpecialOffers = productTransactedSpecialOffers;
    }



    //Utility methods

    @Override
    public String toString() {
        return "TransactedProduct{" +
                "productTransactedUnits=" + productTransactedUnits +
                ", productTransactedUnitsDecimal=" + productTransactedUnitsDecimal +
                ", productTransactedQuantity=" + productTransactedQuantity +
                ", productTransactedUnitPrice=" + productTransactedUnitPrice +
                ", productTransactedDiscount=" + productTransactedDiscount +
                ", productTransactedAdjustments=" + productTransactedAdjustments +
                ", productTransactedCredits=" + productTransactedCredits +
                ", productTransactedCreditType='" + productTransactedCreditType + '\'' +
                ", productTransactedDeductions=" + productTransactedDeductions +
                ", productTransactedOtherCharges=" + productTransactedOtherCharges +
                ", productTransactedSpecialOffers='" + productTransactedSpecialOffers + '\'' +
                '}';
    }



}
