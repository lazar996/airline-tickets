package com.lazar.airlinetickets.services;

import com.lazar.airlinetickets.model.Flight;
import com.lazar.airlinetickets.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;


    public List<Flight> getAllFlight(){
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id){

        return flightRepository.findFlightById(id);
    }

    public Flight getFlightByCode(String code){

        return  flightRepository.findFlightByCode(code);
    }

    public List<Flight> getAllFlightsDepartureDateBetween(Date start, Date end){

        return flightRepository.getAllByDepartureDateBetween(start, end);
    }

}
