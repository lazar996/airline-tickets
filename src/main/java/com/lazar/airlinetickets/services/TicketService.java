package com.lazar.airlinetickets.services;

import com.lazar.airlinetickets.model.Ticket;
import com.lazar.airlinetickets.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {


    @Autowired
    TicketRepository ticketRepository;

    public List<Ticket> getAllTicket(){

        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id){
        return ticketRepository.findTicketById(id);
    }
}
