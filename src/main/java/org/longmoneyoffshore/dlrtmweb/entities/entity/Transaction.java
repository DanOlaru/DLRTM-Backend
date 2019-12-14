package org.longmoneyoffshore.dlrtmweb.entities.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.longmoneyoffshore.dlrtmweb.service.ProductService;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactionID")
    private int transactionID;

    @Column(name = "clientID")
    private int clientID;


    //bi-directional @OneToMany
    //@JoinColumn(name = "transactedProductId")
    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransactedProduct> products = new ArrayList<>();


    @Column(name = "transactionStatus")
    private String transactionStatus;

    @Column(name = "specialMentions")
    private String specialMentions;

    @Column(name = "localDate")
    //@Temporal(value = TemporalType.TIMESTAMP)
    private LocalDate localDate;

    public Transaction() {
        this.specialMentions = "";
        this.transactionStatus = "done";
    }


    public Transaction(TransactionCommandObject tco) {
        this.clientID = tco.getClientId();
        this.transactionStatus = tco.getTransactionStatus();
        this.specialMentions = tco.getTransactionSpecialMentions();
        this.localDate = LocalDate.now();

        this.products = new ArrayList<>();
        String[] productIds = tco.getProductIds().split(",");

        for (String id : productIds) {
            TransactedProduct product = new TransactedProduct(id);
            addProduct(product);
        }

    }

    public Transaction(TransactionCommandObject tco, ProductService productService) {
        this.clientID = tco.getClientId();
        this.transactionStatus = tco.getTransactionStatus();
        this.specialMentions = tco.getTransactionSpecialMentions();
        this.localDate = LocalDate.now();

        this.products = new ArrayList<>();
        String[] productIds = tco.getProductIds().split(",");

        for (String id : productIds) {
            TransactedProduct product = new TransactedProduct(id);
            product.setProductName(productService.getProductById(Integer.valueOf(id)).getProductName());
            addProduct(product);
        }

    }

    public void addProduct(TransactedProduct transactedProduct) {
        this.products.add(transactedProduct);
        transactedProduct.setTransaction(this);
    }

    public void removeProduct(TransactedProduct transactedProduct) {
        products.remove(transactedProduct);
        transactedProduct.setTransaction(null);
    }

}

