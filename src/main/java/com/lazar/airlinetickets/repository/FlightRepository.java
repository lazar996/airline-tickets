package com.lazar.airlinetickets.repository;

import com.lazar.airlinetickets.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    public Flight findFlightById(Long id);
    public  Flight findFlightByCode(String code);

    public List<Flight> getAllByDepartureDateBetween(Date startDate, Date endDate);
}
