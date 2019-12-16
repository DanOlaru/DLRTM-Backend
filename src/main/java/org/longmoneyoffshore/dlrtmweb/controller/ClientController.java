package org.longmoneyoffshore.dlrtmweb.controller;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.entities.atomic.PaymentCard;
import org.longmoneyoffshore.dlrtmweb.globalvalues.ClientsFakeDataSets;
import org.longmoneyoffshore.dlrtmweb.entities.entity.Client;
import org.longmoneyoffshore.dlrtmweb.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Controller
@RestController
@Qualifier("ClientController")
@RequestMapping(value = "/clients")
@Data
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClients() {
        System.out.println("INSIDE CONTROLLER: GETTING ALL CLIENTS: ");

        clientService.getAllClients().stream().forEach(c -> System.out.println(c.smallToString()));

        return clientService.getAllClients();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Client getClientById(@PathVariable("id") int id) {
        System.out.println("TESTING: INSIDE CONTROLLER: GETTING CLIENT # " + id);

        System.out.println("CLIENT OBTAINED: " + clientService.getClientById(id).smallToString());

        return clientService.getClientById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteClientById(@PathVariable("id") int id) {
        clientService.removeClientById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllClients() {
        clientService.removeAllClients();
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateClientById(@RequestBody Client client) {
        clientService.updateClient(client);

    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertClient(@RequestBody Client client) {

        clientService.insertClient(client);
    }


    @PostMapping(value = "/clientsfake")
    public void insertFakeClients() {
        ClientsFakeDataSets.clientsFakeDataSet.forEach(client ->{
            clientService.insertClient(client);
        });
    }

    @PostMapping(value = "/insertoneclient")
    public void insertOneClient() {

        System.out.println("testing: insert this one client");

        Client oneClient = Client.builder()
                .clientName("One Client")
                .clientBusinessPhone("666-888-6767")
                .emailAddress("one.client@gmail.com")
                .clientAddress("345 E 85th St, Chicago, IL, 60617")
                .cards(new ArrayList<PaymentCard>(Arrays.asList(new PaymentCard("5432 5678 6666 0987, 10/14/20, 665"))))
                .clientSpecialMentions("just one customer")
                .build();

        clientService.insertClient(oneClient);
    }

}