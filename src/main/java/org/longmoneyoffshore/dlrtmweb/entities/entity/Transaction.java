/*
package org.longmoneyoffshore.dlrtmweb.entities.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.longmoneyoffshore.dlrtmweb.view.TransactionCommandObject;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@Data
@Entity(name = "Transaction")
@Table(name = "transactions")
@Builder
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transactionID")
    private int transactionID;

    @Column(name = "clientID")
    private String clientID;


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

    public Transaction() { }


    public Transaction(String clientID) {
        this();

        this.clientID = clientID;
        this.specialMentions = "";
        this.transactionStatus = "done";
    }

    public Transaction(String clientID, String transactionStatus) {
        this();

        this.clientID = clientID;
        this.specialMentions = "";
        this.transactionStatus = transactionStatus;
    }

    public Transaction(String clientId, String productIDList, String transactionStatus, String specialMentions) {
        this();

        this.clientID = clientId;
        this.transactionStatus = transactionStatus;
        this.specialMentions = specialMentions;
    }

    public Transaction(TransactionCommandObject tco) {
        this(tco.getClientId(), tco.getProductIds(), tco.getTransactionStatus(), tco.getTransactionSpecialMentions());
    }

    public void addProduct(TransactedProduct transactedProduct) {
        products.add(transactedProduct);
        transactedProduct.setTransaction(this);
    }

    public void removeProduct(TransactedProduct transactedProduct) {
        products.remove(transactedProduct);
        transactedProduct.setTransaction(null);
    }

}

*/
