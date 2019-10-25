package org.longmoneyoffshore.dlrtmweb.controller;

import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Client;
import org.longmoneyoffshore.dlrtmweb.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

import static org.longmoneyoffshore.dlrtmweb.FakeDataSets.clientsFakeDataSet2;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    private ClientService clientService;

    public ClientService getClientService() {
        return clientService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    //@RequestMapping(value = "/", method = RequestMethod.GET)
    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public Collection<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Client getClientById(@PathVariable("id") String id) {
        return clientService.getClientById(id);
    }

    @RequestMapping(value = "{id}" , method = RequestMethod.DELETE)
    //public Collection<Client> deleteClientById(@PathVariable("id") String id) {
    public void deleteClientById(@PathVariable("id") String id) {
        clientService.removeClientById(id);
        //return clientService.getAllClients();
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    //public Collection<Client> updateClientById(@RequestBody Client client) {
    public void updateClientById(@RequestBody Client client) {
        clientService.updateClient(client);

        System.out.println("UPDATING TRANSACTION " + client.toString());
        //return clientService.getAllClients();
    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    //public Collection<Client> insertClient(@RequestBody Client client) {
    //public boolean insertClient(@RequestBody Client client) {
    public void insertClient(@RequestBody Client client) {

        System.out.println("INSERTING CLIENT " + client.smallToString());

        clientService.insertClient(client);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/clientsfake")
    public void insertFakeClients() {

        //clientService.insertClient(client);

        //clear tables
        {
            clientService.clearTables();
        }

        clientService.insertClients(clientsFakeDataSet2);

        //clientService.insertClient(JasonSmith);
    }

}

