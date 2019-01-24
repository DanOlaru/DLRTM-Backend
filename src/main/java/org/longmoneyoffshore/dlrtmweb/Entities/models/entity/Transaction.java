package org.longmoneyoffshore.dlrtmweb.Entities.models.entity;

import java.util.ArrayList;
import java.util.Arrays;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction {

    //#1 IDs:
    // unique transaction id
    @Id
    private String transactionUniqueID;

    // Client id + client reference
    private String clientUniqueID; //TODO: might be superfluous
    private Client clientObjReference; //actual reference to client object


    //products information
    //A list of transacted product IDs
    private String[] productIdList;
    // list of actual Products / references to the same, which are being transacted
    private ArrayList<TransactedProduct> productsList;


    //#2 Product description — potentially superfluous
    private String productSpecialMentions;

    //empty constructor
    public Transaction() { }


    //full constructor


    public Transaction(String transactionUniqueID, String clientUniqueID, Client clientObjReference, String[] productIdList,
                       ArrayList<TransactedProduct> productsList, String productSpecialMentions) {

        this.transactionUniqueID = transactionUniqueID;
        this.clientUniqueID = clientUniqueID;
        this.clientObjReference = clientObjReference;
        this.productIdList = productIdList;
        this.productsList = productsList;
        this.productSpecialMentions = productSpecialMentions;
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "transactionUniqueID='" + transactionUniqueID + '\'' +
                ", clientUniqueID='" + clientUniqueID + '\'' +
                ", clientObjReference=" + clientObjReference +
                ", productIdList=" + Arrays.toString(productIdList) +
                ", productsList=" + productsList +
                ", productSpecialMentions='" + productSpecialMentions + '\'' +
                '}';
    }


}
