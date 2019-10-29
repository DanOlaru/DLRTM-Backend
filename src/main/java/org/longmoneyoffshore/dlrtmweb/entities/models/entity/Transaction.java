package org.longmoneyoffshore.dlrtmweb.entities.models.entity;


import org.springframework.data.annotation.Id;

import java.util.ArrayList;

//@Entity
public class Transaction {

    //#1 IDs:
    @Id
    private String transactionID;
    private Client clientReference;
    private ArrayList<TransactedProduct> productsList;
    private String transactionStatus;
    private String specialMentions;

    public Transaction() {
    }


    public Transaction(String transactionID, Client clientReference,
                       ArrayList<TransactedProduct> productsList, String specialMentions) {

        this.transactionID = transactionID;
        this.clientReference = clientReference;
        this.productsList = productsList;
        this.transactionStatus = "done";
        this.specialMentions = specialMentions;
    }

    public Transaction(Client clientReference, ArrayList<TransactedProduct> productsList) {
        this.clientReference = clientReference;
        this.productsList = productsList;
        this.specialMentions = "";
        this.transactionStatus = "done";
    }

    public Transaction(Client clientReference, ArrayList<TransactedProduct> productsList, String transactionStatus) {
        this.clientReference = clientReference;
        this.productsList = productsList;
        this.specialMentions = "";
        this.transactionStatus = transactionStatus;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public Client getClientReference() {
        return clientReference;
    }

    public void setClientReference(Client clientReference) {
        this.clientReference = clientReference;
    }

    public ArrayList<TransactedProduct> getProductsList() {
        return productsList;
    }

    public void setProductsList(ArrayList<TransactedProduct> productsList) {
        this.productsList = productsList;
    }

    public String getSpecialMentions() {
        return specialMentions;
    }

    public void setSpecialMentions(String specialMentions) {
        this.specialMentions = specialMentions;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionUniqueID='" + transactionID + '\'' +
                ", clientObjReference=" + clientReference +
                ", productsList=" + productsList +
                ", productSpecialMentions='" + specialMentions + '\'' +
                '}';
    }

    //Utility methods coming soon

}

