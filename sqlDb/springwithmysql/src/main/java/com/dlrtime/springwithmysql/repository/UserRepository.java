package com.dlrtime.springwithmysql.repository;

import com.dlrtime.springwithmysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
