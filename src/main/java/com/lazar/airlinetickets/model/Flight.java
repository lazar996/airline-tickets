package com.lazar.airlinetickets.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "flight")
public class Flight {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String code;

    @Column
    private Integer quota;

    @Column
    private Double price;

    @Column(name = "departure_date")
    private Date departureDate;

    @Column(name = "estimated_arrival_date")
    private Date estimatedArrivalDate;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flight", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private Route route;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "airport_company_id", referencedColumnName = "id")
    private AirportCompany airportCompany;

    public Flight() {
    }

    public Flight(Long id, String code, Integer quota, Double price, Date departureDate, Date estimatedArrivalDate, List<Ticket> tickets, Route route, AirportCompany airportCompany) {
        this.id = id;
        this.code = code;
        this.quota = quota;
        this.price = price;
        this.departureDate = departureDate;
        this.estimatedArrivalDate = estimatedArrivalDate;
        this.tickets = tickets;
        this.route = route;
        this.airportCompany = airportCompany;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getEstimatedArrivalDate() {
        return estimatedArrivalDate;
    }

    public void setEstimatedArrivalDate(Date estimatedArrivalDate) {
        this.estimatedArrivalDate = estimatedArrivalDate;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public AirportCompany getAirportCompany() {
        return airportCompany;
    }

    public void setAirportCompany(AirportCompany airportCompany) {
        this.airportCompany = airportCompany;
    }
}
