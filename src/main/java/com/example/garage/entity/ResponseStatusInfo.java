package com.example.garage.entity;

import java.util.List;

public class ResponseStatusInfo {
    /*
     Vehicle Plate
     */
    private String vehiclePlate;

    /*
    Vehicle Color
     */
    private String color;

    /*
    Size of the vehicle
     */
    private int vehicleSize;


    /*
    Area of Vehicle
     */
    private List<Integer> area;

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

    public int getVehicleSize() {
        return vehicleSize;
    }

    public void setVehicleSize(int vehicleSize) {
        this.vehicleSize = vehicleSize;
    }

    public List<Integer> getArea() {
        return area;
    }

    public void setArea(List<Integer> area) {
        this.area = area;
    }
}
