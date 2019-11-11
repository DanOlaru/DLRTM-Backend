package templates.throwaway;

import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Data
public class TransactionsPresenterController {
    private TransactionService transactionService;

    @GetMapping("/presentTransactions")
    public String listTransactions(Model model) {

        model.addAttribute("transactions", transactionService.getAllTransactions());

        return "transactionsThyme";
    }
}
