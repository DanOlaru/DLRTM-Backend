package org.longmoneyoffshore.dlrtmweb.entities.models.entity;


import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

//@Entity
public class Transaction {

    @Id
    private String transactionID;
    private Client client;
    private ArrayList<Product> productsList;
    private String transactionStatus;
    private String specialMentions;

    public Transaction() {
    }

    public Transaction(String transactionID, Client client,
                       ArrayList<Product> productsList, String specialMentions) {

        this.transactionID = transactionID;
        this.client = client;
        this.productsList = productsList;
        this.transactionStatus = "done";
        this.specialMentions = specialMentions;
    }

    public Transaction(Client client, ArrayList<Product> productsList) {
        this.client = client;
        this.productsList = productsList;
        this.specialMentions = "";
        this.transactionStatus = "done";
    }

    public Transaction(Client client, ArrayList<Product> productsList, String transactionStatus) {
        this.client = client;
        this.productsList = productsList;
        this.specialMentions = "";
        this.transactionStatus = transactionStatus;
    }

    public Transaction(String clientId, ArrayList<String> productsList, String transactionStatus) {
        this.client = new Client(clientId);
        this.productsList = productsList.stream().map(p -> new Product(p)).collect(Collectors.toCollection(ArrayList::new));
        this.specialMentions = "";
        this.transactionStatus = transactionStatus;
    }

    public Transaction(String clientId, String productsList) {
        this.client = new Client(clientId);
        String[] productIds = productsList.split(",");
        this.productsList = Arrays.stream(productIds).map(p -> new Product(p)).collect(Collectors.toCollection(ArrayList::new));//TODO will be populated from the other tables referenced
        this.specialMentions = "";
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(ArrayList<Product> productsList) {
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
                ", clientObjReference=" + client +
                ", productsList=" + productsList +
                ", productSpecialMentions='" + specialMentions + '\'' +
                '}';
    }

    //Utility methods coming soon

}

