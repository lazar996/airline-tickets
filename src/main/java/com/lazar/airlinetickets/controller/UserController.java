package com.lazar.airlinetickets.controller;

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
  UserSevice userSevice;


 @GetMapping("/all")
  public String allAccess() {
    return "Public Content. Useee";
  }
  @GetMapping("/mod")
  @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
  public ResponseEntity<?> getAllUser() {

    return new ResponseEntity<List<User>>(this.userSevice.getAllUsers(), HttpStatus.OK);
  }
  @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
  @RequestMapping(value = "/user/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) {

    return new ResponseEntity<User>(this.userSevice.getUserById(id),HttpStatus.OK);
  }




}
