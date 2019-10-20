package org.longmoneyoffshore.dlrtmweb;

import org.longmoneyoffshore.dlrtmweb.entities.models.atomic.Address;
import org.longmoneyoffshore.dlrtmweb.entities.models.atomic.PaymentCard;
import org.longmoneyoffshore.dlrtmweb.entities.models.atomic.PersonName;
import org.longmoneyoffshore.dlrtmweb.entities.models.atomic.PhoneNumber;
import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Client;
import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FakeDataSets {

    //Insert into DB from this list
    public List<Product> productsSimple = new ArrayList<>(Arrays.asList(
            new Product("0001", "Blender", "Phillips", "Netherlands",
                    "food blender", 20, 10.67, 0, 0, 10, 0,
                    "Free Bread Knife", "USD", 100, 0, 0, 0,
                    "Unit", "Pending recalls"),

            new Product("0002", "Mixer", "Sony", "Japan",
                    "food mixer", 47.8, 20.25, 2, -1, 20, 10,
                    "10% off blades", "USD", 180, 0, 0, 0,
                    "Unit", "best in class"),

            new Product("0003", "Grinder", "Sanyo", "South Korea",
                    "coffee grinder", 33, 34.43, 3, -3, 0, 14,
                    "free CD player", "USD", 60, 0, 0, 20,
                    "Unit", "new model"),

            new Product("0004", "Coffee Maker", "JVC", "Germany",
                    "coffee maker", 22, 16.15, 11, 20, 3, 20,
                    "5 year warranty", "USD", 10, 0, 0, 70,
                    "Unit", "buyer's favorite"))
    );

    public List<Product> productsExtended = new ArrayList<>(Arrays.asList(
            new Product("0001", "Blender", "Phillips", "Netherlands",
                    "food blender", 20, 10.67, 0, 0, 10, 0,
                    "Free Bread Knife", "USD", 100, 0, 0, 0,
                    "Unit", "Pending recalls", 2.3, 1.5, .5, 0.0, 35.6, "inch", "lbs"),

            new Product("0002", "Mixer", "Sony", "Japan",
                    "food mixer", 47.8, 20.25, 2, -1, 20, 10,
                    "10% off blades", "USD", 180, 0, 0, 0,
                    "Unit", "best in class", 2.3, 1.5, .5, 0.0, 35.6, "inch", "lbs"),

            new Product("0003", "Grinder", "Sanyo", "South Korea",
                    "coffee grinder", 33, 34.43, 3, -3, 0, 14,
                    "free CD player", "USD", 60, 0, 0, 20,
                    "Unit", "new model", 2.3, 1.5, .5, 0.0, 35.6, "inch", "lbs"),

            new Product("0004", "Coffee Maker", "JVC", "Germany",
                    "coffee maker", 22, 16.15, 11, 20, 3, 20,
                    "5 year warranty", "USD", 10, 0, 0, 70,
                    "Unit", "buyer's favorite", 2.3, 1.5, .5, 0.0, 35.6, "inch", "lbs"),

            new Product("0005", "Coffee Shaker", "Sunny", "China",
                    "coffee flaker", 13, 666, 5, 5, 5, 5,
                    "666 year warranty", "flUSD", 5, 5, 5, 5,
                    "flUnit", "flyer's delite", 2.3, 1.5, .5, 0.0, 35.6, "inch", "lbs"))
    );

    public List<Product> productsExtendedUpdatedSublist = new ArrayList<>(Arrays.asList(

            new Product("0002", "Mixer", "Sony", "Japan",
                    "food mixer", 33.3, 2.25, 2, -1, 20, 10,
                    "10% off blades", "USD", 130, 0, 0, 0,
                    "Unit", "best in class", 2.3, 1.5, .5, 0.0, 35.6, "inch", "lbs"),

            new Product("0003", "Grinder", "Sanyo", "South Korea",
                    "coffee grinder", 66.6, 5.55, 3, -3, 0, 14,
                    "free CD player", "USD", 690, 0, 0, 20,
                    "Unit", "new model", 2.3, 1.5, .5, 0.0, 35.6, "inch", "lbs")));

    public Product updatedProductFour = new Product("0004", "Coffee Baker", "Sunny", "Australia",
            "coffee maker", 22, 16.15, 11, 20, 3,
            20, "5 year warranty", "USD", 10, 0, 0,
            70, "Unit", "buyer's favorite", 6.3, 6.5, .6, 0.6,
            36.6, "sixteenth", "pound");

    public Product productFive = new Product("0005", "XRay Machine", "IBM", "USA",
            "XRAY machine", 2, 1600, 0, 20, 3,
            20, "5 year warranty", "USD", 3, 0, 0,
            2, "Unit", "heavy duty", 6.3, 6.5, 8, 10,
            36.6, "foot", "tons");


/*

//brief-signature Constructor
    public Client(String clientID, PersonName clientName, PhoneNumber clientPhone, String clientPrimaryEmailAddress,
                  Address clientAddress, List<PaymentCard> cards, String clientSpecialMentions)
 */

    public static Client JasonSmith =  new Client("0001", new PersonName("Jason Smith"), new PhoneNumber("Jason Smith", "555-888-6767"),
            "jason.smith@gmail.com", new Address("1421 E 23rd St, Chicago, IL, 60615"),
            Arrays.asList(new PaymentCard("1234 4321 5678 0987", "Jason Smith", "10/14/20", "665")),
            "good customer");

    public static List<Client> clientsFakeDataSet2 = new ArrayList<>(Arrays.asList(

            new Client("0001", new PersonName("Jason Smith"), new PhoneNumber("Jason Smith", "555-888-6767"),
                    "jason.smith@gmail.com", new Address("1421 E 23rd St, Chicago, IL, 60615"),
                    Arrays.asList(new PaymentCard("1234 4321 5678 0987", "Jason Smith", "10/14/20", "665")),
                    "good customer"),
            new Client("0002", new PersonName("Jake Wyler"), new PhoneNumber("Jake Wyler", "555-888-6767"),
                    "jason.smith@gmail.com", new Address("1421 E 23rd St, Chicago, IL, 60615"),
                    Arrays.asList(new PaymentCard("1234 4321 5678 0987", "Jake Wyler", "10/14/20", "665")),
                    "bad customer"),
            new Client("0003", new PersonName("Betty Boop"), new PhoneNumber("Betty Boop", "555-888-6767"),
                    "jason.smith@gmail.com", new Address("1421 E 23rd St, Chicago, IL, 60615"),
                    Arrays.asList(new PaymentCard("1234 4321 5678 0987", "Betty Boop", "10/14/20", "665")),
                    "good customer"),
            new Client("0004", new PersonName("Will Smith"), new PhoneNumber("Will Smith", "555-888-6767"),
                    "jason.smith@gmail.com", new Address("1421 E 23rd St, Chicago, IL, 60615"),
                    Arrays.asList(new PaymentCard("1234 4321 5678 0987", "Will Smith", "10/14/20", "665")),
                    "bad customer"),
            new Client("0005", new PersonName("Jason Lee"), new PhoneNumber("Jason Lee", "555-888-6767"),
                    "jason.smith@gmail.com", new Address("1421 E 23rd St, Chicago, IL, 60615"),
                    Arrays.asList(new PaymentCard("1234 4321 5678 0987", "Jason Lee", "10/14/20", "665")),
                    "bad customer"),
            new Client("0006", new PersonName("Mike Oldfield"), new PhoneNumber("Mike Oldfield", "555-888-6767"),
                    "jason.smith@gmail.com", new Address("1421 E 23rd St, Chicago, IL, 60615"),
                    Arrays.asList(new PaymentCard("1234 4321 5678 0987", "Mike Oldfield", "10/14/20", "665")),
                    "good customer")

    ));


    static public List<Client> clientsFakeDataSet = new ArrayList<>(Arrays.asList(

            /*new Client("0001", new PersonName("Jason Smith"), new PhoneNumber("Jason Smith", "555-888-6767"),
                    "jason.smith@gmail.com", new Address("1421 E 23rd St, Chicago, IL, 60615"),
                    new PaymentCard("1234 4321 5678 0987", "Jason Smith", "10/14/20", "665"),
                    "good customer")
        ,
            new Client("0001", new PersonName("Jake Wyler"), new PhoneNumber("Jake Wyler", "555-888-6767"),
                    "jason.smith@gmail.com", new Address("1421 E 23rd St, Chicago, IL, 60615"),
                    new PaymentCard("1234 4321 5678 0987", "Jake Wyler", "10/14/20", "665"),
                    "bad customer"),
            new Client("0001", new PersonName("Betty Boop"), new PhoneNumber("Betty Boop", "555-888-6767"),
                    "jason.smith@gmail.com", new Address("1421 E 23rd St, Chicago, IL, 60615"),
                    new PaymentCard("1234 4321 5678 0987", "Betty Boop", "10/14/20", "665"),
                    "good customer"),
            new Client("0001", new PersonName("Will Smith"), new PhoneNumber("Will Smith", "555-888-6767"),
                    "jason.smith@gmail.com", new Address("1421 E 23rd St, Chicago, IL, 60615"),
                    new PaymentCard("1234 4321 5678 0987", "Will Smith", "10/14/20", "665"),
                    "bad customer"),
            new Client("0001", new PersonName("Jason Lee"), new PhoneNumber("Jason Lee", "555-888-6767"),
                    "jason.smith@gmail.com", new Address("1421 E 23rd St, Chicago, IL, 60615"),
                    new PaymentCard("1234 4321 5678 0987", "Jason Lee", "10/14/20", "665"),
                    "bad customer"),
            new Client("0001", new PersonName("Mike Oldfield"), new PhoneNumber("Mike Oldfield", "555-888-6767"),
                    "jason.smith@gmail.com", new Address("1421 E 23rd St, Chicago, IL, 60615"),
                    new PaymentCard("1234 4321 5678 0987", "Mike Oldfield", "10/14/20", "665"),
                    "good customer") */

    ));

}
