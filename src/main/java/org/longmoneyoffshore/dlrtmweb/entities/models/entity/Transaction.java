package org.longmoneyoffshore.dlrtmweb.entities.models.entity;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.view.TransactionCommandObject;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
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
    private LocalDate localDate;

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
        this(tco.getClientId(),tco.getProductIds(),tco.getTransactionStatus(), tco.getTransactionSpecialMentions());
    }

    public String getProductListAsString() {
        return productIDList.stream().collect(Collectors.joining(", "));
    }

}

