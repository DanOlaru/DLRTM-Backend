/*
package org.longmoneyoffshore.dlrtmweb.entities.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "TransactedProduct")
@Table (name = "transacted_products")
@Getter
@Setter
@Data
//@EqualsAndHashCode
public class TransactedProduct extends Product {

    @Id
    @GeneratedValue
    private int transactedProductId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "transactionID")
    private Transaction transaction;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactedProduct )) return false;
        return transactedProductId != 0 && transactedProductId == (((TransactedProduct) o).getTransactedProductId());
    }
    @Override
    public int hashCode() {
        return 31;
    }
}
*/
