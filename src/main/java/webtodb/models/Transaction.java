package webtodb.models;

import java.util.ArrayList;

public class Transaction {

    //#1 IDs:
    // unique transaction id
    private String transactionUniqueID;

    // Client id + client reference
    private String clientUniqueID; //TODO: might be superfluous
    private Client clientReference; //actual reference to client object


    //products information
    //A list of transacted product IDs
    private String[] productIdList;
    // list of actual Products being transacted
    private ArrayList<TransactedProduct> productsList;



    //#2 Product description


    private String productSpecialMentions;


}
