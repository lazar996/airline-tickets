package com.lazar.airlinetickets.services;

import com.lazar.airlinetickets.model.User;
import com.lazar.airlinetickets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSevice {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){ return  userRepository.findUserById(id);}
}
