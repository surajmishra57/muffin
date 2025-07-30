package org.example.lld_interview_problems.parkinglot.vehicle;

public abstract class Vehicle {
    private String licenceNumber;
    private VehicleType vehicleType;

    public Vehicle(String licenceNumber, VehicleType vehicleType) {
        this.licenceNumber = licenceNumber;
        this.vehicleType = vehicleType;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
