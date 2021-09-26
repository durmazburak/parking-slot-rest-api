package com.example.garage.enums;

public enum VehicleType {
    Car(1),
    Jeep(2),
    Truck(4);

    private final int slot;

    public int getSlotInfo()
    {
        return this.slot;
    }

    VehicleType(int slot) {
        this.slot = slot;
    }
}