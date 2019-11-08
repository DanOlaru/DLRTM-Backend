package org.longmoneyoffshore.dlrtmweb.controller;

import org.longmoneyoffshore.dlrtmweb.service.ClientService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientsPresenterController {

    private ClientService clientService;

    @GetMapping("/presentClients")
    //@RequestMapping(value = "/presentClients", method = { RequestMethod.GET, RequestMethod.POST })
    public String listClients(Model model) {

        model.addAttribute("clients", clientService.getAllClients());

        return "clientsThyme";
    }



    public ClientService getClientService() {
        return clientService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }
}