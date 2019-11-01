package org.longmoneyoffshore.dlrtmweb.controller;

import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Client;
import org.longmoneyoffshore.dlrtmweb.service.ClientService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientsPresenterController {

    private ClientService clientService;

    @GetMapping("/presentClients")
    public String listClients(Model model) {

        model.addAttribute("clients", clientService.getAllClients());

        return "clientsThyme";
    }



   /* private boolean process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {

        try {

            // This prevents triggering engine executions for resource URLs
            if (request.getRequestURI().startsWith("/css") ||
                    request.getRequestURI().startsWith("/images") ||
                    request.getRequestURI().startsWith("/favicon")) {
                return false;
            }
            */


            /*
             * Query controller/URL mapping and obtain the controller
             * that will process the request. If no controller is available,
             * return false and let other filters/servlets process the request.
             */
            /*DLRTMStoreController controller = this.application.resolveControllerForRequest(request);
            if (controller == null) {
                return false;
            }

            *//*
             * Obtain the TemplateEngine instance.
             *//*
            ITemplateEngine templateEngine = this.application.getTemplateEngine();

            *//*
             * Write the response headers
             *//*
            response.setContentType("text/html;charset=UTF-8");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);

            *//*
             * Execute the controller and process view template,
             * writing the results to the response writer.
             *//*
            controller.process(
                    request, response, this.servletContext, templateEngine);

            return true;

        } catch (Exception e) {
            try {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            } catch (final IOException ignored) {
                // Just ignore this
            }
            throw new ServletException(e);
        }

    }

    public interface DLRTMStoreController {
        public void process(
                HttpServletRequest request, HttpServletResponse response,
                ServletContext servletContext, ITemplateEngine templateEngine);

    }
*/

    public ClientService getClientService() {
        return clientService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }
}