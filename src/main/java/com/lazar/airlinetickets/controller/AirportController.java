package com.lazar.airlinetickets.controller;

import com.lazar.airlinetickets.model.Airport;
import com.lazar.airlinetickets.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/airport")
public class AirportController {


    @Autowired
    AirportService airportService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllAirport(){

        return  new ResponseEntity<List<Airport>>(this.airportService.getAllAirPort(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Airport> getAirportById(@PathVariable(value = "id") Long id){

        return  new ResponseEntity<Airport>(this.airportService.getAirportById(id), HttpStatus.OK);
    }

}
