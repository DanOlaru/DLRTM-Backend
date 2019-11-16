package org.longmoneyoffshore.dlrtmweb.entities.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
//@Table(name = "products_hibernate")
@Component
@Getter
@Setter
public class Product implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
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


    public Product() { }

    public Product(int productID) {
        this.productID = productID;
    }

    public Product(int productID, String productName) {
        this.productID = productID;
        this.productName = productName;
    }


    public Product(int productID, String productName, String productManufacturer, String country, String productDescription,
                   double productUnitPrice, String productSpecialOffers, int productItemsInStockInt, String productSpecialMentions) {

        this.productID = productID;
        this.productName = productName;
        this.productManufacturer = productManufacturer;
        this.productCountry = country;
        this.productDescription = productDescription;
        this.productUnitPrice = productUnitPrice;
        this.productSpecialOffers = productSpecialOffers;
        this.productItemsInStockInt = productItemsInStockInt;
        this.productSpecialMentions = productSpecialMentions;
    }

    @Override
    public String toString() {
        try {
            return "Product{" + "\n" +
                    "  productID=" + this.productID+ "\n" +
                    ", productName=" + this.productName + "\n" +
                    ", productManufacturer=" + this.productManufacturer+ "\n" +
                    ", productCountry=" + this.productCountry + "\n" +
                    ", productDescription=" + this.productDescription+ "\n" +
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
