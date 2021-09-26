package com.example.garage.repository;

import com.example.garage.entity.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TicketsRepository  extends JpaRepository <Tickets, Integer> {

    @Query("SELECT t FROM Tickets t")
    List<Tickets> findAllBy();

    @Modifying
    @Transactional
    @Query("DELETE FROM Tickets WHERE ticketId = :ticketId")
    void deleteTicketById(@Param("ticketId") Long ticketId);
}
