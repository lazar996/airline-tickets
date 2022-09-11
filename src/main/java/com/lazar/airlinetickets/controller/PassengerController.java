package com.lazar.airlinetickets.controller;


import com.lazar.airlinetickets.model.Airport;
import com.lazar.airlinetickets.model.Passenger;
import com.lazar.airlinetickets.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/passenger")
public class PassengerController {

    @Autowired
    PassengerService passengerService;


    @GetMapping( "/all")
    public ResponseEntity<?> getAllPassenger(){

        return new ResponseEntity<List<Passenger>>(this.passengerService.getAllPassenger(), HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Passenger> getAirportById(@PathVariable(value = "id") Long id){

        return  new ResponseEntity<Passenger>(this.passengerService.getPassengerById(id), HttpStatus.OK);
    }

}
