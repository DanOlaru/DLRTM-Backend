package org.longmoneyoffshore.dlrtmweb.globalvalues;

import org.longmoneyoffshore.dlrtmweb.entities.entity.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsFakeDataSets {
    public static List<Product> fakeProducts = new ArrayList<>(Arrays.asList(
            Product.builder()
                    .productName("Blender")
                    .productManufacturer("Phillips")
                    .productCountry("Netherlands")
                    .productDescription("food blender")
                    .productUnitPrice(20)
                    .productSpecialOffers("Free Bread Knife")
                    .productItemsInStockInt(100)
                    .productSpecialMentions("Pending recalls")
                    .build(),

            Product.builder()
                    .productName("Mixer")
                    .productManufacturer("Sony")
                    .productCountry("Japan")
                    .productDescription("food mixer")
                    .productUnitPrice(47.8)
                    .productSpecialOffers("10% off blades")
                    .productItemsInStockInt(180)
                    .productSpecialMentions("best in class")
                    .build(),

            Product.builder()
                    .productName("Grinder")
                    .productManufacturer("Sanyo")
                    .productCountry("South Korea")
                    .productDescription("coffee grinder")
                    .productUnitPrice(33)
                    .productSpecialOffers("free CD player")
                    .productItemsInStockInt(60)
                    .productSpecialMentions("new model")
                    .build(),

            Product.builder()
                    .productName("Coffee Maker")
                    .productManufacturer("JVC")
                    .productCountry("Germany")
                    .productDescription("coffee maker")
                    .productUnitPrice(22)
                    .productSpecialOffers("5 year warrantyv")
                    .productItemsInStockInt(10)
                    .productSpecialMentions("buyer's favorite")
                    .build(),

            Product.builder()
                    .productName("Coffee Shaker")
                    .productManufacturer("Sunny")
                    .productCountry("China")
                    .productDescription("coffee flaker")
                    .productUnitPrice(13)
                    .productSpecialOffers("nada")
                    .productItemsInStockInt(666)
                    .productSpecialMentions("flyer's delite")
                    .build(),

            Product.builder()
                    .productName("XRay Machine")
                    .productManufacturer("IBM")
                    .productCountry("USA")
                    .productDescription("XRAY machine")
                    .productUnitPrice(2)
                    .productSpecialOffers("Free Surgical Robot")
                    .productItemsInStockInt(1)
                    .productSpecialMentions("5 year warranty — heavy duty")
                    .build()
    ));

}
