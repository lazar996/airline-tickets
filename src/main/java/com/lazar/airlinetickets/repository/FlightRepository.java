package com.lazar.airlinetickets.repository;

import com.lazar.airlinetickets.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    public Flight findFlightById(Long id);
    public  Flight findFlightByCode(String code);


    @Query(value ="SELECT * \n" +
            "FROM flight fl\n" +
            "JOIN route\n" +
            "on fl.route_id = route.id\n" +
            "JOIN airport a1\n" +
            "on departure_airport_id=  a1.id \n" +
            "JOIN airport a2\n" +
            " on a2.id = arrival_airport_id \n" +
            "where a2.city =:origin \n"+
            "and\n" +
            "a1.city=:destination \n" +
            "and\n" +
            "   fl.departure_date BETWEEN :startDate AND :endDate \n" +
            "   \n" +
            "    " , nativeQuery=true)
    public List<Flight> getAllFlightsDate(@Param("startDate") Date startDate,
                                          @Param("endDate")Date endDate,
                                          @Param("origin")String origin,
                                          @Param("destination")String destination);

    public List<Flight> getAllByDepartureDateBetween(Date startDate, Date endDate);

}
