package com.lazar.airlinetickets.services;

import com.lazar.airlinetickets.model.Route;
import com.lazar.airlinetickets.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {


    @Autowired
    RouteRepository routeRepository;

    public List<Route> getAllRoute(){

        return routeRepository.findAll();
    }

    public Route getRouteById(Long id){
        return routeRepository.findRouteById(id);
    }
}
