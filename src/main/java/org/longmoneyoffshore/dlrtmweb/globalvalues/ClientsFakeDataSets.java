package org.longmoneyoffshore.dlrtmweb.globalvalues;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.longmoneyoffshore.dlrtmweb.entities.entity.Client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Getter
@Setter
public class ClientsFakeDataSets {

    /*public static List<Client> getClientsFakeDataSet2() {
        return clientsFakeDataSet2;
    }


    public static List<Client> getClientsFakeDataSet3() {
        return clientsFakeDataSet3;
    }

    public static List<Client> getClientsFakeDataSet() {
        return clientsFakeDataSet;
    }
*/




    /*public static Client JasonSmith =  new Client(1, new PersonName("Jason Smith"), new PhoneNumber("Jason Smith", "555-888-6767"),
            "jason.smith@gmail.com", new Address("1421 E 23rd St, Chicago, IL, 60615"),
            Arrays.asList(new PaymentCard("1234 4321 5678 0987", "Jason Smith", "10/14/20", "665")),
            "good customer");

    private static List<Client> clientsFakeDataSet2 = new ArrayList<>(Arrays.asList(
            new Client(1, new PersonName("Jason Smith"), new PhoneNumber("Jason Smith", "555-888-6767"),
                    "jason.smith@gmail.com", new Address("1421 E 23rd St, Chicago, IL, 60615"),
                    Arrays.asList(new PaymentCard("1234 4321 5678 0987", "Jason Smith", "10/14/20", "665")),
                    "good customer"),
            new Client(2, new PersonName("Jake Wyler"), new PhoneNumber("Jake Wyler", "555-888-6767"),
                    "jason.smith@gmail.com", new Address("1421 E 23rd St, Chicago, IL, 60615"),
                    Arrays.asList(new PaymentCard("1234 4321 5678 0987", "Jake Wyler", "10/14/20", "665")),
                    "bad customer"),
            new Client(3, new PersonName("Betty Boop"), new PhoneNumber("Betty Boop", "555-888-6767"),
                    "jason.smith@gmail.com", new Address("1421 E 23rd St, Chicago, IL, 60615"),
                    Arrays.asList(new PaymentCard("1234 4321 5678 0987", "Betty Boop", "10/14/20", "665")),
                    "good customer"),
            new Client(4, new PersonName("Will Smith"), new PhoneNumber("Will Smith", "555-888-6767"),
                    "jason.smith@gmail.com", new Address("1421 E 23rd St, Chicago, IL, 60615"),
                    Arrays.asList(new PaymentCard("1234 4321 5678 0987", "Will Smith", "10/14/20", "665")),
                    "bad customer"),
            new Client(5, new PersonName("Jason Lee"), new PhoneNumber("Jason Lee", "555-888-6767"),
                    "jason.smith@gmail.com", new Address("1421 E 23rd St, Chicago, IL, 60615"),
                    Arrays.asList(new PaymentCard("1234 4321 5678 0987", "Jason Lee", "10/14/20", "665")),
                    "bad customer"),
            new Client(6, new PersonName("Mike Oldfield"), new PhoneNumber("Mike Oldfield", "555-888-6767"),
                    "jason.smith@gmail.com", new Address("1421 E 23rd St, Chicago, IL, 60615"),
                    Arrays.asList(new PaymentCard("1234 4321 5678 0987", "Mike Oldfield", "10/14/20", "665")),
                    "good customer")
    ));


    public static List<Client> clientsFakeDataSet3 = new ArrayList<>(Arrays.asList(

            new Client(1,"Jason Smith", "555-888-6767",
                    "jason.smith@gmail.com","1421 E 23rd St, Chicago, IL, 60615",
                    "1234 4321 5678 0987 " + "Jason Smith " + "10/14/20 " + "665", "good customer"),
            new Client(2,"Jake Wyler", "555-888-6767",
                    "jason.smith@gmail.com","1421 E 23rd St, Chicago, IL, 60615",
                    "1234 4321 5678 0987 " + "Jason Smith " + "10/14/20 " + "665", "good customer"),
            new Client(3,"Betty Boop", "555-888-6767",
                    "jason.smith@gmail.com","1421 E 23rd St, Chicago, IL, 60615",
                    "1234 4321 5678 0987 " + "Jason Lee " + "10/14/20 " + "665", "good customer"),
            new Client(4,"Jason Lee", "555-888-6767",
                    "jason.smith@gmail.com","1421 E 23rd St, Chicago, IL, 60615",
                    "1234 4321 5678 0987 " + "Jason Smith " + "10/14/20 " + "665", "good customer"),
            new Client(5,"Mike Oldfield", "555-888-6767",
                    "jason.smith@gmail.com","1421 E 23rd St, Chicago, IL, 60615",
                    "1234 4321 5678 0987 " + "Jason Smith " + "10/14/20 " + "665", "good customer"),
            new Client(6,"Jason Smith", "555-888-6767",
                    "jason.smith@gmail.com","1421 E 23rd St, Chicago, IL, 60615",
                    "1234 4321 5678 0987 " + "Jason Smith " + "10/14/20 " + "665", "good customer")
    ));
*/


    static public List<Client> clientsFakeDataSet = new ArrayList<>(Arrays.asList(
            Client.builder()
                    .clientName("Jason Smith")
                    .clientBusinessPhone("555-888-6767")
                    .emailAddress("jason.smith@gmail.com")
                    .clientAddress("1421 E 23rd St, Chicago, IL, 60615")
                    .paymentCard("1234 4321 5678 0987, 10/14/20, 665")
                    .clientSpecialMentions("good customer")
                    .build(),
            Client.builder()
                    .clientName("Jake Wyler")
                    .clientBusinessPhone("555-888-6767")
                    .emailAddress("jake.wyler@gmail.com")
                    .clientAddress("1421 E 23rd St, Chicago, IL, 60615")
                    .paymentCard("1234 4321 5678 0987, 10/14/20, 665")
                    .clientSpecialMentions("bad customer")
                    .build(),
            Client.builder()
                    .clientName("Betty Boop")
                    .clientBusinessPhone("555-888-6767")
                    .emailAddress("betty.boop@gmail.com")
                    .clientAddress("1421 E 23rd St, Chicago, IL, 60615")
                    .paymentCard("1234 4321 5678 0987, 10/14/20, 665")
                    .clientSpecialMentions("good customer")
                    .build(),
            Client.builder()
                    .clientName("Will Smith")
                    .clientBusinessPhone("555-888-6767")
                    .emailAddress("will.smith@gmail.com")
                    .clientAddress("1421 E 23rd St, Chicago, IL, 60615")
                    .paymentCard("1234 4321 5678 0987, 10/14/20, 665")
                    .clientSpecialMentions("bad customer")
                    .build(),
            Client.builder()
                    .clientName("Jason Lee")
                    .clientBusinessPhone("555-888-6767")
                    .emailAddress("jason.lee@gmail.com")
                    .clientAddress("1421 E 23rd St, Chicago, IL, 60615")
                    .paymentCard("1234 4321 5678 0987, 10/14/20, 665")
                    .clientSpecialMentions("terrible customer")
                    .build(),
            Client.builder()
                    .clientName("Mike Oldfield")
                    .clientBusinessPhone("555-888-6767")
                    .emailAddress("mike.oldfield@gmail.com")
                    .clientAddress("1421 E 23rd St, Chicago, IL, 60615")
                    .paymentCard("1234 4321 5678 0987, 10/14/20, 765")
                    .clientSpecialMentions("especially good customer")
                    .build()
    ));

}