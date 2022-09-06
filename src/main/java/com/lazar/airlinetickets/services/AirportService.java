package com.lazar.airlinetickets.services;

import com.lazar.airlinetickets.model.Airport;
import com.lazar.airlinetickets.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    @Autowired
    AirportRepository airportRepository;


    public List<Airport> getAllAirPort(){

        return airportRepository.findAll();
    }

    public Airport getAirportById(Long id){
        return airportRepository.findAirportById(id);
    }
}
