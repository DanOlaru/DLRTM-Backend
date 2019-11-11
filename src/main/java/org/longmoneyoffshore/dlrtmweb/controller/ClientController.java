package org.longmoneyoffshore.dlrtmweb.controller;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.entities.globalvalues.ClientsFakeDataSets;
import org.longmoneyoffshore.dlrtmweb.entities.models.atomic.Address;
import org.longmoneyoffshore.dlrtmweb.entities.models.atomic.PaymentCard;
import org.longmoneyoffshore.dlrtmweb.entities.models.atomic.PersonName;
import org.longmoneyoffshore.dlrtmweb.entities.models.atomic.PhoneNumber;
import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Client;
import org.longmoneyoffshore.dlrtmweb.service.ClientService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



//@RestController
@Controller
@RequestMapping(value = "/clients")
@Data
public class ClientController {

    private ClientService clientService;

    ClientsFakeDataSets clientsFakeDataSets;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Client getClientById(@PathVariable("id") String id) {
        return clientService.getClientById(id);
    }

    @RequestMapping(value = "{id}" , method = RequestMethod.DELETE)
    public void deleteClientById(@PathVariable("id") String id) {
        clientService.removeClientById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateClientById(@RequestBody Client client) {
        clientService.updateClient(client);

    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertClient(@RequestBody Client client) {


        clientService.insertClient(client);
    }

    @GetMapping(value = "/clientsfake")
    public void insertFakeClients() {


        {
            clientService.clearTables();
        }


        System.out.println("ADDING FAKE CLIENTS LIST TO DB");

            clientService.insertClients(new ArrayList<>(Arrays.asList(
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
        )));
    }

}

