package org.longmoneyoffshore.dlrtmweb.repository;

import org.longmoneyoffshore.dlrtmweb.entities.atomic.PaymentCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PaymentCardDao extends JpaRepository<PaymentCard, Integer> {
    //List<PaymentCard> getAllPaymentCardsByDate(Date date);
}
