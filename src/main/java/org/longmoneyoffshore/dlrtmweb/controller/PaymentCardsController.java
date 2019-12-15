package org.longmoneyoffshore.dlrtmweb.controller;


import lombok.Data;
import org.longmoneyoffshore.dlrtmweb.entities.atomic.PaymentCard;
import org.longmoneyoffshore.dlrtmweb.entities.entity.Product;
import org.longmoneyoffshore.dlrtmweb.service.PaymentCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@Qualifier("PaymentCardsController")
public class PaymentCardsController {

    @Autowired
    PaymentCardService paymentCardService;

    @GetMapping("/paymentcards")
    public List<PaymentCard> getAllPaymentCards() {

        return paymentCardService.getAllPaymentCards();
    }


    @RequestMapping(method = RequestMethod.GET, value = "/testPaymentCards")
    public String printTest() {
        return "Testing.";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/paymentcards/{id}")
    public PaymentCard getPaymentCard (@PathVariable int id) {
        return paymentCardService.getPaymentCardById(id);
    }
}
