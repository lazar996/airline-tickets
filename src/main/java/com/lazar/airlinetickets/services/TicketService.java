package com.lazar.airlinetickets.services;

import com.lazar.airlinetickets.DTO.TicketDTO;
import com.lazar.airlinetickets.model.Flight;
import com.lazar.airlinetickets.model.Passenger;
import com.lazar.airlinetickets.model.Ticket;
import com.lazar.airlinetickets.model.User;
import com.lazar.airlinetickets.repository.FlightRepository;
import com.lazar.airlinetickets.repository.PassengerRepository;
import com.lazar.airlinetickets.repository.TicketRepository;
import com.lazar.airlinetickets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {


    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    UserRepository userRepository;

    public List<Ticket> getAllTicket(){

        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id){
        return ticketRepository.findTicketById(id);
    }

    public Ticket createTicket(TicketDTO ticketDTO){

        Flight flight = flightRepository.findFlightById(ticketDTO.getFlight_id());
        Passenger passenger = passengerRepository.findPassengerById(ticketDTO.getPassenger_id());
        User user = userRepository.findUserById(ticketDTO.getUser_id());
        Ticket ticket = new Ticket();
        ticket.setCheckIn(ticketDTO.getCheckIn());
        ticket.setFlight(flight);
        ticket.setPassenger(passenger);
        ticket.setUser(user);
        ticket.setNumberTicket(ticketDTO.getNumber_ticket());
        System.out.println(flight);
        return ticketRepository.save(ticket);
    }

    public Ticket checkInTicket(Long id){

        Ticket ticket = ticketRepository.findTicketById(id);

        System.out.println(ticket);

        ticket.setCheckIn("yes");
        return ticketRepository.save(ticket);
    }

    public  List<Ticket>  getTicketByUser(Long id){

        return  ticketRepository.findTicketByPassenger(id);
    }

    public  List<Ticket>    getTicketByLoginUser(Long id){

        return  ticketRepository.findTicketByLoginUser(id);
    }

    public Ticket viewCart(String email,String lastName, String numberTicket ){
        return ticketRepository.findTicketByOriginAndNumberTicketAndLastName(email,lastName,numberTicket);
    }




}
