package com.lazar.airlinetickets.model;


import javax.persistence.*;

@Entity
@Table(name = "airplane")
public class Airplane {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
