package com.lazar.airlinetickets.model;


import javax.persistence.*;

@Entity
@Table(name = "airport")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String iataCode;

    @Column
    private String icaoCode;

    @Column
    private String name;

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private Double lattitude;

    @Column
    private Double longitude;

    @Column
    private Double altitude;

    @Column
    private String timezone;

    public Airport() {
    }

    public Airport(Long id, String iataCode, String icaoCode, String name, String country, String city, Double lattitude, Double longitude, Double altitude, String timezone) {
        this.id = id;
        this.iataCode = iataCode;
        this.icaoCode = icaoCode;
        this.name = name;
        this.country = country;
        this.city = city;
        this.lattitude = lattitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.timezone = timezone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getLattitude() {
        return lattitude;
    }

    public void setLattitude(Double lattitude) {
        this.lattitude = lattitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
