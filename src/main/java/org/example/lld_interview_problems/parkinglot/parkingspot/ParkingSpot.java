package org.example.lld_interview_problems.parkinglot.parkingspot;

import org.example.lld_interview_problems.parkinglot.vehicle.Vehicle;

public abstract class ParkingSpot {
    private final String spotId;
    private boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSpot(String spotId) {
        this.spotId = spotId;
        this.isOccupied = false;
    }

    public synchronized boolean isAvailable() {
        return !isOccupied;
    }

    public synchronized boolean assignVehicle(Vehicle vehicle) {
        if (isOccupied)
            return false;
        this.vehicle = vehicle;
        this.isOccupied = true;
        return true;
    }

    public synchronized boolean removeVehicle() {
        this.vehicle = null;
        isOccupied = false;
        return true;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public String getSpotId() {
        return this.spotId;
    }

    public abstract boolean canFitVehicle(Vehicle vehicle);
}
