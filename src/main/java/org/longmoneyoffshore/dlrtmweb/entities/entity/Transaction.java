package org.longmoneyoffshore.dlrtmweb.entities.entity;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.longmoneyoffshore.dlrtmweb.view.TransactionCommandObject;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity (name = "Transaction")
@Table(name = "transactions_hibernate")
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transactionID")
    private int transactionID;

    @Column(name = "clientID")
    private String clientID;


    //simple @ManyToOne implementation !!!!
    /*EntityManager entityManager = Persistence
            .createEntityManagerFactory("longmoneyoffshore.dlrtmweb.entities.entity.TransactedProduct")
            .createEntityManager();

    @OneToMany(mappedBy = "transaction")
    //@JoinColumn(name = "transactedProductId")
    //private List<Product> products;
    private List<TransactedProduct> products = entityManager.createQuery(
            "SELECT tc" +
                    "FROM TransactedProduct tc" +
                    "WHERE tc.transaction.transactionID = : transactionID" ,TransactedProduct.class)
            .setParameter(transactionID, transactionID)
            .getResultList();*/

    //bi-directional @OneToMany
    //@JoinColumn(name = "transactedProductId")
    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransactedProduct> products = new ArrayList<>();


    @Column(name = "transactionStatus")
    private String transactionStatus;

    @Column(name = "specialMentions")
    private String specialMentions;

    @Column(name = "localDate")
    private LocalDate localDate;

    public Transaction() {}

    public Transaction(int transactionID, String clientID, ArrayList<String> productIDList, String specialMentions) {

        this();

        this.transactionID = transactionID;
        this.clientID = clientID;
        this.transactionStatus = "done";
        this.specialMentions = specialMentions;
    }

    public Transaction(String clientID, ArrayList<String> productIDList) {
        this();

        this.clientID = clientID;
        this.specialMentions = "";
        this.transactionStatus = "done";
    }

    public Transaction(String clientID, ArrayList<String> productIDList, String transactionStatus) {
        this();

        this.clientID = clientID;
        this.specialMentions = "";
        this.transactionStatus = transactionStatus;
    }

    public Transaction(String clientId, String productIDList) {
        this();

        this.clientID = clientId;
        //this.productIDList = Arrays.asList(productIDList.split(","));
        this.specialMentions = "";
    }

    public Transaction(String clientId, String productIDList, String transactionStatus, String specialMentions) {
        this();

        this.clientID = clientId;
        this.transactionStatus = transactionStatus;
        this.specialMentions = specialMentions;
    }

    public Transaction(TransactionCommandObject tco) {
        this(tco.getClientId(),tco.getProductIds(),tco.getTransactionStatus(), tco.getTransactionSpecialMentions());
    }

    public void addProduct (TransactedProduct transactedProduct) {
        products.add(transactedProduct);
        transactedProduct.setTransaction(this);
    }

    public void removeProduct (TransactedProduct transactedProduct) {
        products.remove(transactedProduct);
        transactedProduct.setTransaction(null);
    }

}

