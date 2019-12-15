package org.longmoneyoffshore.dlrtmweb.service;

import org.longmoneyoffshore.dlrtmweb.entities.atomic.PaymentCard;
import org.longmoneyoffshore.dlrtmweb.repository.PaymentCardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier ("PaymentCardService")
public class PaymentCardService {

    @Autowired
    PaymentCardDao paymentCardDao;

    public List<PaymentCard> getAllPaymentCards() { return this.paymentCardDao.findAll(); }

    public PaymentCard getPaymentCardById(int id) { return this.paymentCardDao.findById(id).get(); }

    public void deletePaymentCardById(int id) {this.paymentCardDao.deleteById(id);}

    public void deleteAllPaymentCards() {this.paymentCardDao.deleteAll();}

    public void updatePaymentCard (PaymentCard paymentCard){ this.paymentCardDao.save(paymentCard);}

    public void insertPaymentCard (PaymentCard paymentCard) { this.paymentCardDao.save(paymentCard);}

    public void insertPaymentCards (List<PaymentCard> paymentCards) { this.paymentCardDao.saveAll(paymentCards);}

}
