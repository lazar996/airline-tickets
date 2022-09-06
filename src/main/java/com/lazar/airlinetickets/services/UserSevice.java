package com.lazar.airlinetickets.services;

import com.lazar.airlinetickets.DTO.UserDTO;
import com.lazar.airlinetickets.model.Role;
import com.lazar.airlinetickets.model.User;
import com.lazar.airlinetickets.repository.RoleRepository;
import com.lazar.airlinetickets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserSevice {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){ return  userRepository.findUserById(id);}

   public User updateUser(UserDTO userDTO, Long id){

        User user = userRepository.findUserById(id);

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        user.setAddress(userDTO.getAddress());
        user.setPhone(userDTO.getPhone());
        user.setEmail(userDTO.getEmail());
        
        return userRepository.save(user);
    }
}
