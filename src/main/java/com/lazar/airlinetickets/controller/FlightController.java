package com.lazar.airlinetickets.controller;
import com.lazar.airlinetickets.model.Flight;
import com.lazar.airlinetickets.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/flight")
public class FlightController {


    @Autowired
    FlightService flightService;


    @GetMapping("/all")
    public ResponseEntity<?> getAllFlight(){

        return new ResponseEntity<List<Flight>>(this.flightService.getAllFlight(), HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Flight> getFlightById(@PathVariable(value = "id") Long id){

        return  new ResponseEntity<Flight>(this.flightService.getFlightById(id), HttpStatus.OK);
    }

    @GetMapping("/by-code/{code}")
    public Flight getFlightByCode(@PathVariable String code){

        return flightService.getFlightByCode(code);
    }


    @GetMapping("all/departure-data")
    public List<Flight> getAllFlightsDepartureDate(@DateTimeFormat (pattern = "yyyy-MM-dd HH:mm:ss") Date start,
                                                   @DateTimeFormat (pattern = "yyyy-MM-dd HH:mm:ss") Date end,
                                                   String origin, String destination){
        return flightService.getAllFlightsDepartureDateBetweenAndDestination(start, end, origin, destination);
    }

    @GetMapping("all/departure-data-return")
    public List<Flight> getAllFlightsDepartureDateReturn(@DateTimeFormat (pattern = "yyyy-MM-dd HH:mm:ss") Date start,
                                                   @DateTimeFormat (pattern = "yyyy-MM-dd HH:mm:ss") Date end,
                                                   String origin, String destination){
        return flightService.getAllFlightsDepartureDateBetweenAndDestination(start, end, destination,origin);
    }
    @GetMapping("all/departure-data-between")
    public List<Flight> getAllFlightsDepartureDateBetween(@DateTimeFormat (pattern = "yyyy-MM-dd HH:mm:ss") Date start,
                                                          @DateTimeFormat (pattern = "yyyy-MM-dd HH:mm:ss") Date end){

        System.out.println(start);
        System.out.println(end);
        return flightService.getAllFlightsDepartureDateBetween(start, end);
    }

}
