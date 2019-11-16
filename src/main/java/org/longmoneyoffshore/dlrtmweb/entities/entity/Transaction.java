package org.longmoneyoffshore.dlrtmweb.entities.entity;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.view.TransactionCommandObject;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactionID")
    private String transactionID;

    @Column(name = "clientID")
    private String clientID;

    @Column(name = "productIDList")
    private List<String> productIDList;

    @Column(name = "transactionStatus")
    private String transactionStatus;

    @Column(name = "specialMentions")
    private String specialMentions;

    @Column(name = "localDate")
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

