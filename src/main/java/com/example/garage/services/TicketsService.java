package com.example.garage.services;

import com.example.garage.entity.Tickets;
import com.example.garage.repository.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketsService {

    private final TicketsRepository ticketsRepository;

    @Autowired
    public TicketsService (TicketsRepository ticketsRepository){
        this.ticketsRepository = ticketsRepository;
    }

    public List<Tickets> findAllBy (){
        return ticketsRepository.findAllBy();
    }

    public void save (Tickets tickets){
        ticketsRepository.save(tickets);
    }

    public void deleteTicketById(Long ticketId){
        ticketsRepository.deleteTicketById(ticketId);
    }
}
