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