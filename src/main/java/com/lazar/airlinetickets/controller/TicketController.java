package com.lazar.airlinetickets.controller;
import com.lazar.airlinetickets.DTO.TicketDTO;
import com.lazar.airlinetickets.model.Ticket;
import com.lazar.airlinetickets.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;
    @GetMapping( "/all")
    public ResponseEntity<?> getAllTicket(){

        return new ResponseEntity<List<Ticket>>(this.ticketService.getAllTicket(), HttpStatus.OK);

    }

    @GetMapping("ticket_by_user/{id}")
    public ResponseEntity<?> getTicketByUser(@PathVariable(value = "id") Long id){

        return new ResponseEntity<List<Ticket>>(this.ticketService.getTicketByUser(id),HttpStatus.OK);
    }
    @GetMapping("ticket_by_login_user/{id}")
    public ResponseEntity<?> getTicketByLoginUser(@PathVariable(value = "id") Long id){

        return new ResponseEntity<List<Ticket>>(this.ticketService.getTicketByLoginUser(id),HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ticket> getTicketById(@PathVariable(value = "id") Long id){

        return  new ResponseEntity<Ticket>(this.ticketService.getTicketById(id), HttpStatus.OK);
    }

    @PostMapping("/reserve")
    public ResponseEntity<Ticket> createTicket(@RequestBody TicketDTO ticketDTO){


        return new ResponseEntity<Ticket>(this.ticketService.createTicket(ticketDTO),HttpStatus.CREATED);
    }


}
