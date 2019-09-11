package org.longmoneyoffshore.dlrtmweb;

import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FakeDataSets {

    //Insert into DB from this list
    public List<Product> productsSimple =  new ArrayList<>(Arrays.asList(
            new Product("0001", "Blender", "Phillips", "Netherlands",
                    "food blender", 20, 10.67,0,0,10,0,
                    "Free Bread Knife","USD", 100,0,0,0,
                    "Unit","Pending recalls"),

            new Product("0002", "Mixer", "Sony", "Japan",
                    "food mixer", 47.8, 20.25,2,-1,20,10,
                    "10% off blades","USD",180,0,0,0,
                    "Unit","best in class"),

            new Product("0003", "Grinder", "Sanyo", "South Korea",
                    "coffee grinder",33, 34.43,3,-3,0,14,
                    "free CD player","USD",60,0,0,20,
                    "Unit","new model"),

            new Product("0004", "Coffee Maker", "JVC", "Germany",
                    "coffee maker",22, 16.15,11,20,3,20,
                    "5 year warranty","USD",10,0,0,70,
                    "Unit","buyer's favorite"))
    );

    public List<Product> productsExtended =  new ArrayList<>(Arrays.asList(
            new Product("0001", "Blender", "Phillips", "Netherlands",
                    "food blender", 20, 10.67,0,0,10,0,
                    "Free Bread Knife","USD", 100,0,0,0,
                    "Unit","Pending recalls", 2.3, 1.5,.5,0.0,35.6,"inch", "lbs"),

            new Product("0002", "Mixer", "Sony", "Japan",
                    "food mixer", 47.8, 20.25,2,-1,20,10,
                    "10% off blades","USD",180,0,0,0,
                    "Unit","best in class", 2.3, 1.5,.5,0.0,35.6,"inch", "lbs"),

            new Product("0003", "Grinder", "Sanyo", "South Korea",
                    "coffee grinder",33, 34.43,3,-3,0,14,
                    "free CD player","USD",60,0,0,20,
                    "Unit","new model", 2.3, 1.5,.5,0.0,35.6,"inch", "lbs"),

            new Product("0004", "Coffee Maker", "JVC", "Germany",
                    "coffee maker",22, 16.15,11,20,3,20,
                    "5 year warranty","USD",10,0,0,70,
                    "Unit","buyer's favorite", 2.3, 1.5,.5,0.0,35.6,"inch", "lbs"),

            new Product("0005", "Coffee Shaker", "Sunny", "China",
                    "coffee flaker",13, 666,5,5,5,5,
                    "666 year warranty","flUSD",5,5,5,5,
                    "flUnit","flyer's delite", 2.3, 1.5,.5,0.0,35.6,"inch", "lbs"))
    );

    public List<Product> productsExtendedUpdatedSublist =  new ArrayList<>(Arrays.asList(

            new Product("0002", "Mixer", "Sony", "Japan",
                    "food mixer", 33.3, 2.25,2,-1,20,10,
                    "10% off blades","USD",130,0,0,0,
                    "Unit","best in class", 2.3, 1.5,.5,0.0,35.6,"inch", "lbs"),

            new Product("0003", "Grinder", "Sanyo", "South Korea",
                    "coffee grinder",66.6, 5.55,3,-3,0,14,
                    "free CD player","USD",690,0,0,20,
                    "Unit","new model", 2.3, 1.5,.5,0.0,35.6,"inch", "lbs")));

    public Product updatedProductFour = new Product("0004", "Coffee Baker", "Sunny", "Australia",
                        "coffee maker",22, 16.15,11,20,3,
                        20, "5 year warranty","USD",10,0,0,
                        70, "Unit","buyer's favorite", 6.3, 6.5,.6,0.6,
                        36.6,"sixteenth", "pound");

    public Product productFive = new Product("0005", "XRay Machine", "IBM", "USA",
            "XRAY machine",2, 1600,0,20,3,
            20, "5 year warranty","USD",3,0,0,
            2, "Unit","heavy duty", 6.3, 6.5,8,10,
            36.6,"foot", "tons");




}
