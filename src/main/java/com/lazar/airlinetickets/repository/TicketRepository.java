package com.lazar.airlinetickets.repository;

import com.lazar.airlinetickets.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    public Ticket findTicketById(Long id);

    @Query(value = "SELECT * \n" +
            "FROM ticket \n" +
            "where passenger_id =:id \n"
            , nativeQuery = true)
    public List<Ticket> findTicketByPassenger(@Param("id") Long id);




    @Query(value = "SELECT * \n" +
            "FROM ticket \n" +
            "where user_id =:id \n"
            , nativeQuery = true)
    public List<Ticket> findTicketByLoginUser(@Param("id") Long id);

    @Query(value = "SELECT * \n" +
            "FROM ticket t\n" +
            "JOIN users u\n"+
            "on u.email=:email \n"+
            "and\n"+
             "u.last_name=:lastName \n" +
            " where number_ticket=:numberTicket \n",nativeQuery = true)

    public Ticket findTicketByOriginAndNumberTicketAndLastName(@Param("email") String email,
                                                               @Param("lastName") String lastName,
                                                               @Param("numberTicket") String numberTicket );
}
