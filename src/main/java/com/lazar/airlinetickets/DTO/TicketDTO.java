package com.lazar.airlinetickets.DTO;


public class TicketDTO {

    private Long id;
    private String CheckIn;
    private Long passenger_id;
    private Long flight_id;

    private Long user_id;

    private Long number_ticket;

    public TicketDTO() {
    }

    public TicketDTO(Long id, String checkIn, Long passenger_id, Long flight_id, Long user_id, Long number_ticket) {
        this.id = id;
        CheckIn = checkIn;
        this.passenger_id = passenger_id;
        this.flight_id = flight_id;
        this.user_id = user_id;
        this.number_ticket = number_ticket;
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

    public Long getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(Long passenger_id) {
        this.passenger_id = passenger_id;
    }

    public Long getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Long flight_id) {
        this.flight_id = flight_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getNumber_ticket() {
        return number_ticket;
    }

    public void setNumber_ticket(Long number_ticket) {
        this.number_ticket = number_ticket;
    }
}
