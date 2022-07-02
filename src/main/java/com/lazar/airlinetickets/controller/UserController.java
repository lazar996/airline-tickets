package com.lazar.airlinetickets.controller;

import com.lazar.airlinetickets.model.User;
import com.lazar.airlinetickets.services.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {


  @Autowired
  UserSevice userSevice;

  @GetMapping("/mod")
  @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
  public ResponseEntity<?> getAllUser() {


    return new ResponseEntity<List<User>>(this.userSevice.getAllUsers(), HttpStatus.OK);
  }

}
