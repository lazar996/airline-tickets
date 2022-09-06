package com.lazar.airlinetickets.model;

import javax.persistence.*;

@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "departure_airport_id", referencedColumnName = "id")
    private Airport departureAirport;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "arrival_airport_id", referencedColumnName = "id")
    private Airport arrivalAirport;
}
