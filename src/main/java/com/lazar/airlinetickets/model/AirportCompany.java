package com.lazar.airlinetickets.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class AirportCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "airportCompany", cascade = CascadeType.MERGE)
    private List<Flight> flights;
}
