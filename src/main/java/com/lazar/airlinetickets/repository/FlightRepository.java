package com.lazar.airlinetickets.repository;

import com.lazar.airlinetickets.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
