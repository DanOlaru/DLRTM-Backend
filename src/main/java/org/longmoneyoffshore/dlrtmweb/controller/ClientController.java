package org.longmoneyoffshore.dlrtmweb.controller;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.globalvalues.ClientsFakeDataSets;
import org.longmoneyoffshore.dlrtmweb.entities.atomic.Address;
import org.longmoneyoffshore.dlrtmweb.entities.atomic.PaymentCard;
import org.longmoneyoffshore.dlrtmweb.entities.atomic.PersonName;
import org.longmoneyoffshore.dlrtmweb.entities.atomic.PhoneNumber;
import org.longmoneyoffshore.dlrtmweb.entities.entity.Client;
import org.longmoneyoffshore.dlrtmweb.service.ClientService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Controller
@RestController
@RequestMapping(value = "/clients")
@Data
public class ClientController {

    private ClientService clientService;
    private List<Client> myInitialClients = new ArrayList<>(ClientsFakeDataSets.clientsFakeDataSet);

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Client getClientById(@PathVariable("id") String id) {
        return clientService.getClientById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
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

        //System.out.println("CLIENT CONTROLLER: ");

        //clientService.clearTables();
        System.out.println("TESTING: WHAT ARE MY CLIENTS" );
        for (Client c : myInitialClients) { System.out.print(c.getClientID() + " " + c.getClientName() + " || "); }

        clientService.insertClients(myInitialClients);
    }

}