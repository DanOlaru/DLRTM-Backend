package org.longmoneyoffshore.dlrtmweb.controller;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Client;
import org.longmoneyoffshore.dlrtmweb.service.ClientService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.longmoneyoffshore.dlrtmweb.entities.globalvalues.NewFakeDataSets.clientsFakeDataSet2;


@RestController
@RequestMapping(value = "/clients")
@Data
public class ClientController {

    private ClientService clientService;

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

    @RequestMapping(method = RequestMethod.POST, value = "/clientsfake")
    public void insertFakeClients() {

        {
            clientService.clearTables();
        }

        clientService.insertClients(clientsFakeDataSet2);
    }

}

