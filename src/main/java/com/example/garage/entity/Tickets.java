package com.example.garage.entity;

import com.example.garage.enums.VehicleType;

import javax.persistence.*;

@Entity
@Table(name = "TICKETS")
public class Tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_id")
    private long ticketId;

    /*
    Vehicle Plate
     */
    private String vehiclePlate;

    /*
    Vehicle Color
     */
    private String color;

    /*
    Vehicle Type
     */
    private VehicleType vehicleType;

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
