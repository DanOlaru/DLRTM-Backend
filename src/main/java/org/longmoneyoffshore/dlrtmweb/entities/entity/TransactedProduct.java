package org.longmoneyoffshore.dlrtmweb.entities.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "TransactedProduct")
@Table (name = "transacted_products")
@Getter
@Setter
@Data
//@EqualsAndHashCode
public class TransactedProduct {

    @Id
    @GeneratedValue
    private int transactedProductId;

    private int productID;
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "transactionID")
    private Transaction transaction;

    public TransactedProduct() {}

    public TransactedProduct(String id) {
        //this.transactedProductId = Integer.valueOf(id);
        this.productID = Integer.valueOf(id);
    }

    public TransactedProduct(String id, Transaction transaction) {
        this.productID = Integer.valueOf(id);
        this.transaction = transaction;
    }

    public TransactedProduct(String id, Transaction transaction, String productName) {
        this.productID = Integer.valueOf(id);
        this.transaction = transaction;
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactedProduct )) return false;
        return productID != 0 && productID == (((TransactedProduct) o).getProductID());
    }
    @Override
    public int hashCode() {
        return 31;
    }
}
