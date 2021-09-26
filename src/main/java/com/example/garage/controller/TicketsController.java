package com.example.garage.controller;

import com.example.garage.entity.ResponseStatusInfo;
import com.example.garage.entity.Tickets;
import com.example.garage.exception.NoAvailableParkingSpaceException;
import com.example.garage.services.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE, path = "/garage/")
public class TicketsController {

    private static final Logger LOG = LoggerFactory.getLogger(TicketsController.class);

    private final TicketsService ticketsService;
    private final int PARKING_SIZE = 10;

    @Autowired
    public TicketsController(TicketsService ticketsService){
        this.ticketsService = ticketsService;
    }

    @PostMapping(value = "/addParking")
    public String createPark(@RequestBody Tickets ticket) {
        List<Tickets> ticketsList = ticketsService.findAllBy();
        int currParkSlot = 0;
        int parkingSpace = 1;

        for (Tickets tickets : ticketsList) {
            currParkSlot += tickets.getVehicleType().getSlotInfo() + parkingSpace;
        }

        if (PARKING_SIZE - (currParkSlot + ticket.getVehicleType().getSlotInfo()) < 0)
            throw new NoAvailableParkingSpaceException("Garage is full.");

        else
            ticketsService.save(ticket);

        return  "Allocated" + " " + ticket.getVehicleType().getSlotInfo() + " " + "slots.";
    }

    @DeleteMapping(value = "/leave/{id}")
    public void leavePark(@PathVariable int id){
        int index = id - 1;
        List<Tickets> ticketsList = ticketsService.findAllBy();
        if (ticketsList.isEmpty())
            LOG.info("Garage is empty.");

        Long ticketId = ticketsList.get(index).getTicketId();
        ticketsService.deleteTicketById(ticketId);
        LOG.info("Delete is successfully.");
    }

    @GetMapping(value = "/status")
    public List<ResponseStatusInfo> status (){
        List<Tickets> list = ticketsService.findAllBy();
        List<ResponseStatusInfo> response = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        for (Tickets tickets : list) {
            ResponseStatusInfo responseStatusInfo = new ResponseStatusInfo();
            responseStatusInfo.setVehiclePlate(tickets.getVehiclePlate());
            responseStatusInfo.setColor(tickets.getColor());
            responseStatusInfo.setVehicleSize(tickets.getVehicleType().getSlotInfo());
            response.add(responseStatusInfo);
        }

        int currParkSlot = 0;
        int parkingSpace = 1;
        for (int i = 0; i < response.size() ; i++) {
            if (i == 0)
            {
                for (int j = 1; j <= response.get(i).getVehicleSize(); j++) {
                    size.add(j);
                }
                currParkSlot = response.get(i).getVehicleSize() + parkingSpace;
            }

            if (i > 0)
            {
                for (int j = currParkSlot + 1; j < currParkSlot + response.get(i).getVehicleSize() + parkingSpace; j++) {
                    size.add(j);
                }
                currParkSlot += response.get(i).getVehicleSize() + parkingSpace;
            }
        }

        int firstIndex = 0;
        for (int i = 0; i < response.size(); i++) {
            if (i == 0)
                response.get(i).setArea(size.subList(firstIndex, response.get(i).getVehicleSize()));

            else
                response.get(i).setArea(size.subList(firstIndex, response.get(i).getVehicleSize() + firstIndex));

            firstIndex += response.get(i).getVehicleSize();
        }

        return  response;
    }
}
