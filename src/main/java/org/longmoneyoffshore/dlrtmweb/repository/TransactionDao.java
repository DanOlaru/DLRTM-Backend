package org.longmoneyoffshore.dlrtmweb.repository;


import org.longmoneyoffshore.dlrtmweb.entities.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TransactionDao extends JpaRepository<Transaction, Integer> {

    //List<Transaction> getAllTransactionsByDate(Date date);

}

