package templates.throwaway;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Transaction;
import org.longmoneyoffshore.dlrtmweb.repository.ClientDaoImpl;
import org.longmoneyoffshore.dlrtmweb.service.ClientService;
import org.longmoneyoffshore.dlrtmweb.service.ProductService;
import org.longmoneyoffshore.dlrtmweb.view.TransactionCommandObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Getter
@Setter
@NoArgsConstructor
public class ProductsPresenterController {

    private ProductService productService;
    private ClientDaoImpl clientDao;

    private TransactionCommandObject transactionCommandObject;

    @GetMapping("/presentProducts")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());

        return "productsThyme";
    }

    @PostMapping("/presentProducts")
    public String showProducts (@RequestParam("selectedClientID") String clientID, Model model){

        transactionCommandObject.setClientId(clientID);

        model.addAttribute("clientID", clientID);
        model.addAttribute("clientName", clientDao.getClientById(clientID).getClientName().getSimpleName());

        model.addAttribute("products", productService.getAllProducts());

        return "productsThyme";
    }


    @GetMapping("/presentProductsEx")
    public ModelAndView selectProduct() {

        ModelAndView mav = new ModelAndView("clientsThyme");
        mav.addObject("clients", productService.getAllProducts());

        return mav;
    }
}