package com.lazar.airlinetickets.repository;

import com.lazar.airlinetickets.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository  extends JpaRepository<Airport, Long> {


    public Airport findAirportById(Long id);
}
