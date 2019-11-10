package org.longmoneyoffshore.dlrtmweb.controller;

import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Client;
import org.longmoneyoffshore.dlrtmweb.entities.models.entity.SimpleClient;
import org.longmoneyoffshore.dlrtmweb.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/simpleclients")
public class SimpleClientController {

    private ClientService clientService;

    public ClientService getClientService() {
        return clientService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<SimpleClient> getAllClients() {

        System.out.println("TESTING: INSIDE SIMPLE CLIENT SERVICE: ");

        List<SimpleClient> mySimpleClients = clientService.getAllClients()
                .stream().map(c -> new SimpleClient(c)).collect(Collectors.toList());

        System.out.println("TESTING: INSIDE SIMPLE CLIENT SERVICE: ");
        mySimpleClients.stream().forEach(c -> System.out.print(c.smallToString() + " "));

        return mySimpleClients;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Client getClientById(@PathVariable("id") String id) {
        return clientService.getClientById(id);
    }


}

