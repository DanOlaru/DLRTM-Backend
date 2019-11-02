package org.longmoneyoffshore.dlrtmweb.entities.models.entity;

import org.springframework.data.annotation.Id;
import lombok.Data;

import java.util.ArrayList;

@Data
public class WebTransaction {

    @Id
    private String clientID;
    private String[] productIDsList;
    private String transactionStatus;
    private String specialMentions;

    public WebTransaction() {
    }

    public WebTransaction(String transactionID, Client client,
                       ArrayList<Product> productsList, String specialMentions) {


        this.transactionStatus = "done";
        this.specialMentions = specialMentions;
    }

    public WebTransaction(Client client, ArrayList<Product> productsList) {

        this.specialMentions = "";
        this.transactionStatus = "done";
    }

    public WebTransaction(Client client, ArrayList<Product> productsList, String transactionStatus) {
        this.specialMentions = "";
        this.transactionStatus = transactionStatus;
    }

    public WebTransaction(String clientId, ArrayList<String> productsList, String transactionStatus) {
        this.specialMentions = "";
        this.transactionStatus = transactionStatus;
    }

    public WebTransaction(String clientId, String productsList) {
        String[] productIds = productsList.split(",");
        this.specialMentions = "";
    }


}

