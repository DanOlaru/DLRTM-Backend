package Controller;
/*


import Entities.models.entity.Client;
import Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    //@RequestMapping(value = "/", method = RequestMethod.GET)
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
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

        clientService.insertClient(client);

        System.out.println("INSERTING TRANSACTION " + client.toString());
        //return clientService.getAllClients();
    }

}
*/
