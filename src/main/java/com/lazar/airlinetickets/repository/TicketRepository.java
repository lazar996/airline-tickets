package com.lazar.airlinetickets.repository;

import com.lazar.airlinetickets.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    public Ticket findTicketById(Long id);
}
