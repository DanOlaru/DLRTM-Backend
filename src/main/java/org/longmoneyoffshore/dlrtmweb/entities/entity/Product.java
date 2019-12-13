package org.longmoneyoffshore.dlrtmweb.entities.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity (name = "Product")
@Table(name = "products")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
//@Component
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private int productID;

    @Column(name = "name")
    private String productName;

    @Column(name = "manufacturer")
    private String productManufacturer;

    @Column(name = "country", length = 80)
    private String productCountry;

    @Column(name = "description")
    private String productDescription;

    @Column(name = "unitPrice")
    private double productUnitPrice;

    @Column(name = "specialOffers")
    private String productSpecialOffers;

    @Column(name = "itemsInStockInt")
    private int productItemsInStockInt;

    @Column(name = "specialMentions")
    private String productSpecialMentions;


    @Override
    public String toString() {
        try {
            return "Product{" + "\n" +
                    "  productID=" + this.productID + "\n" +
                    ", productName=" + this.productName + "\n" +
                    ", productManufacturer=" + this.productManufacturer + "\n" +
                    ", productCountry=" + this.productCountry + "\n" +
                    ", productDescription=" + this.productDescription + "\n" +
                    ", productUnitPrice=" + this.productUnitPrice + "\n" +
                    ", productSpecialOffers=" + this.productSpecialOffers + "\n" +
                    ", productItemsInStockInt=" + this.productItemsInStockInt + "\n" +
                    ", productSpecialMentions=" + this.productSpecialMentions +
                    " }";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
