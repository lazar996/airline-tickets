package com.lazar.airlinetickets.controller;

import com.lazar.airlinetickets.model.Airport;
import com.lazar.airlinetickets.model.Route;
import com.lazar.airlinetickets.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/route")
public class RouteController {

    @Autowired
    RouteService routeService;


    @GetMapping("/all")
    public ResponseEntity<?> getAllRoute(){

        return new ResponseEntity<List<Route>>(this.routeService.getAllRoute(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Route> getRouteById(@PathVariable(value = "id") Long id){

        return  new ResponseEntity<Route>(this.routeService.getRouteById(id), HttpStatus.OK);
    }
}
