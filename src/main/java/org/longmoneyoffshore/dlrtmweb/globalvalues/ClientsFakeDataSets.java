package org.longmoneyoffshore.dlrtmweb.globalvalues;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.longmoneyoffshore.dlrtmweb.entities.atomic.PaymentCard;
import org.longmoneyoffshore.dlrtmweb.entities.entity.Client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Getter
@Setter
public class ClientsFakeDataSets {

    static public List<Client> clientsFakeDataSet = new ArrayList<>(Arrays.asList(
            Client.builder()
                    .clientName("Jason Smith")
                    .clientBusinessPhone("555-888-6767")
                    .emailAddress("jason.smith@gmail.com")
                    .clientAddress("1421 E 23rd St, Chicago, IL, 60615")
                    .cards(new ArrayList<PaymentCard>(Arrays.asList(
                            //new PaymentCard("8976 3542 1432 0975, 11/12/22, 808"))))
                            new PaymentCard("8976 3542 1432 0975, 11/12/22, 808","Jason Smith"))))
                    .clientSpecialMentions("good customer")
                    .clientStatus("good standing")
                    .build(),
            Client.builder()
                    .clientName("Jake Wyler")
                    .clientBusinessPhone("555-888-6767")
                    .emailAddress("jake.wyler@gmail.com")
                    .clientAddress("1421 E 23rd St, Chicago, IL, 60615")
                    .cards(new ArrayList<PaymentCard>(Arrays.asList(
                            //new PaymentCard("0000 1111 2222 3333, 04/15/26, 111"),
                            new PaymentCard("0000 1111 2222 3333, 04/15/26, 111", "Jake Wyler"),
                            //new PaymentCard("1234 4321 5678 0987, 10/14/20, 665"))))
                            new PaymentCard("1234 4321 5678 0987, 10/14/20, 665", "Jake Wyler"))))
                    .clientSpecialMentions("bad customer")
                    .clientStatus("behind on payments")
                    .build(),
            Client.builder()
                    .clientName("Betty Boop")
                    .clientBusinessPhone("555-888-6767")
                    .emailAddress("betty.boop@gmail.com")
                    .clientAddress("1421 E 23rd St, Chicago, IL, 60615")
                    .cards(new ArrayList<PaymentCard>(Arrays.asList(
                            //new PaymentCard("1234 4321 5678 0987, 10/14/20, 665"))))
                            new PaymentCard("1234 4321 5678 0987, 10/14/20, 665","Betty Boop"))))
                    .clientSpecialMentions("good customer")
                    .build(),
            Client.builder()
                    .clientName("Will Smith")
                    .clientBusinessPhone("555-888-6767")
                    .emailAddress("will.smith@gmail.com")
                    .clientAddress("1421 E 23rd St, Chicago, IL, 60615")
                    .cards(new ArrayList<PaymentCard>(Arrays.asList(
                            //new PaymentCard("1111 2222 3333 7568, 04/15/14, 054"),
                            //new PaymentCard("1234 4321 5678 0987, 10/14/45, 978"),
                            //new PaymentCard("4351 5241 6899 9999, 10/14/20, 001"))))
                            new PaymentCard("1111 2222 3333 7568, 04/15/14, 054","Will Smith"),
                            new PaymentCard("1234 4321 5678 0987, 10/14/45, 978","Will Smith"),
                            new PaymentCard("4351 5241 6899 9999, 10/14/20, 001","Will Smith"))))
                    .clientSpecialMentions("bad customer")
                    .build(),
            Client.builder()
                    .clientName("Jason Lee")
                    .clientBusinessPhone("555-888-6767")
                    .emailAddress("jason.lee@gmail.com")
                    .clientAddress("1421 E 23rd St, Chicago, IL, 60615")
                    .cards(new ArrayList<PaymentCard>(Arrays.asList(
                            //new PaymentCard("1234 4321 5678 0987, 10/14/20, 665"))))
                            new PaymentCard("1234 4321 5678 0987, 10/14/20, 665","Jason Lee"))))
                    .clientSpecialMentions("terrible customer")
                    .build(),
            Client.builder()
                    .clientName("Mike Oldfield")
                    .clientBusinessPhone("555-888-6767")
                    .emailAddress("mike.oldfield@gmail.com")
                    .clientAddress("1421 E 23rd St, Chicago, IL, 60615")
                    .cards(new ArrayList<PaymentCard>(Arrays.asList(
                            //new PaymentCard("1234 4321 5678 0987, 10/14/20, 765"))))
                            new PaymentCard("1234 4321 5678 0987, 10/14/20, 765","Mike Oldfield"))))
                    .clientSpecialMentions("especially good customer")
                    .build()
    ));

}