package org.longmoneyoffshore.dlrtmweb.repository;

import org.longmoneyoffshore.dlrtmweb.entities.models.atomic.PaymentCard;
import org.longmoneyoffshore.dlrtmweb.entities.models.entity.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PaymentCardDao {
//public interface PaymentCardDao extends CrudRepository {

    Collection<PaymentCard> getAllPaymentCards();

    //Collection<PaymentCard> getAllPaymentCardsByDate(Date date);

    Collection<PaymentCard> getAllPaymentCardsByField (Object field);

    PaymentCard getPaymentCardById(String paymentCardId);

    void removePaymentCardById(String paymentCardId);

    void updatePaymentCard(PaymentCard paymentCard);

    void insertPaymentCard (PaymentCard paymentCard);

    //possible alternative where true is returned when insertion succeeds and false when it does not
    //boolean insertClient (Client client);

}
