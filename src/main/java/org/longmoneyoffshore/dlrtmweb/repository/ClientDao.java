package org.longmoneyoffshore.dlrtmweb.repository;

import org.longmoneyoffshore.dlrtmweb.entities.entity.Client;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
//@Qualifier("ClientDao")
public interface ClientDao extends JpaRepository<Client, Integer> {
    Client findClientByEmailAddress(String email);
}
