package com.lazar.airlinetickets.services;

import com.lazar.airlinetickets.model.Passenger;
import com.lazar.airlinetickets.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {


    @Autowired
    PassengerRepository passengerRepository;

    public List<Passenger> getAllPassenger(){

        return passengerRepository.findAll();
    }

    public Passenger getPassengerById(Long id){

        return passengerRepository.findPassengerById(id);
    }
}
