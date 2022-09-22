package com.lazar.airlinetickets.model;

import javax.persistence.*;

@Entity
@Table(name="reservation")
public class Reservation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



}
