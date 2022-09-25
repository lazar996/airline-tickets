package com.lazar.airlinetickets.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String CheckIn;


    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "flight_id", referencedColumnName = "id")
    private Flight flight;

    @Column
    private Long NumberTicket;

    public Ticket() {
    }

    public Ticket(Long id, String checkIn, Passenger passenger, User user, Flight flight, Long numberTicket) {
        this.id = id;
        CheckIn = checkIn;
        this.passenger = passenger;
        this.user = user;
        this.flight = flight;
        NumberTicket = numberTicket;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCheckIn() {
        return CheckIn;
    }

    public void setCheckIn(String checkIn) {
        CheckIn = checkIn;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Long getNumberTicket() {
        return NumberTicket;
    }

    public void setNumberTicket(Long numberTicket) {
        NumberTicket = numberTicket;
    }
}
