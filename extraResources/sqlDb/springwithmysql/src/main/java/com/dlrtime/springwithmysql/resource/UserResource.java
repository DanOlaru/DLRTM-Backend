package com.dlrtime.springwithmysql.resource;

import com.dlrtime.springwithmysql.model.User;
import com.dlrtime.springwithmysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/users")
public class UserResource {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value="/all")
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @PostMapping(value = "/load")
    public List<User> persist(@RequestBody final User user)
    {
        userRepository.save(user);
        return userRepository.findAll();
    }
}
