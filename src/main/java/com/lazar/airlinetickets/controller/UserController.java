package com.lazar.airlinetickets.controller;

import com.lazar.airlinetickets.DTO.UserDTO;
import com.lazar.airlinetickets.model.User;
import com.lazar.airlinetickets.services.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {


  @Autowired
  UserSevice userService;


 @GetMapping("/all")
  public String allAccess() {
    return "Public Content. Useee";
  }
  @GetMapping("/mod")
  @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
  public ResponseEntity<?> getAllUser() {

    return new ResponseEntity<List<User>>(this.userService.getAllUsers(), HttpStatus.OK);
  }

  @RequestMapping(value = "/user/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) {

    return new ResponseEntity<User>(this.userService.getUserById(id),HttpStatus.OK);
  }

 @RequestMapping(value = "user/edit/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> editUser(@RequestBody UserDTO userDTO, @PathVariable(value = "id") Long id){
      if (userDTO.getId()==null){
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }

      User updateUser = userService.updateUser(userDTO, id);
      return new ResponseEntity<>(updateUser,HttpStatus.OK);

  }




}
