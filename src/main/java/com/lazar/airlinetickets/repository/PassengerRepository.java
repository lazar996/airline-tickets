package com.lazar.airlinetickets.repository;

import com.lazar.airlinetickets.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
