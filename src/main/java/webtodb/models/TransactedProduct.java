package webtodb.models;

public class TransactedProduct extends Product {

    //TODO: questionable if these are needed
    private int productTransactedUnits;
    private double productTransactedUnitsNumberDecimal;
    private double productTransactedQuantity;

    private double productTransactedUnitPrice;
    private double productTransactedDiscount;
    private double productTransactedAdjustments;
    private double productTransactedCredits;
    private String productTransactedCreditType; //reason for the credit
    private double productTransactedDeductions;

    private double productTransactedOtherCharges;

    private String productTransactedSpecialOffers;

}
