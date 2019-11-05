package org.longmoneyoffshore.dlrtmweb.entities.models.entity;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.view.TransactionCommandObject;
import org.springframework.data.annotation.Id;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//@Entity
@Data
public class Transaction {

    @Id
    private String transactionID;
    private String clientID;
    private List<String> productIDList;
    private String transactionStatus;
    private String specialMentions;

    public Transaction() { }

    public Transaction(String transactionID, String clientID, List<String> productIDList, String specialMentions) {

        this.transactionID = transactionID;
        this.clientID = clientID;
        this.productIDList = productIDList;
        this.transactionStatus = "done";
        this.specialMentions = specialMentions;
    }

    public Transaction(String clientID, List<String> productIDList) {
        this.clientID = clientID;
        this.productIDList = productIDList;
        this.specialMentions = "";
        this.transactionStatus = "done";
    }

    public Transaction(String clientID, List<String> productIDList, String transactionStatus) {
        this.clientID = clientID;
        this.productIDList = productIDList;
        this.specialMentions = "";
        this.transactionStatus = transactionStatus;
    }

    public Transaction(String clientId, String productIDList) {
        this.clientID = clientId;
        this.productIDList = Arrays.asList(productIDList.split(","));
        this.specialMentions = "";
    }

    public Transaction(String clientId, String productIDList, String transactionStatus, String specialMentions) {
        this.clientID = clientId;
        this.productIDList = Arrays.asList(productIDList.split(","));
        this.transactionStatus = transactionStatus;
        this.specialMentions = specialMentions;
    }

    public Transaction(TransactionCommandObject tco) {
        //this(tco.getClientId(),tco.getProductIds());
        this(tco.getClientId(),tco.getProductIds(),tco.getTransactionStatus(), tco.getTransactionSpecialMentions());
    }

    public String getProductListAsString() {
        return productIDList.stream().collect(Collectors.joining(", "));
    }

    /*public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public List<String> getProductIDList() {
        return productIDList;
    }

    public void setProductIDList(ArrayList<String> productIDList) {
        this.productIDList = productIDList;
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
                ", clientObjReference=" + clientID +
                ", productsList=" + productIDList.toString() +
                ", productSpecialMentions='" + specialMentions + '\'' +
                '}';
    }*/

    //Utility methods coming soon

}

