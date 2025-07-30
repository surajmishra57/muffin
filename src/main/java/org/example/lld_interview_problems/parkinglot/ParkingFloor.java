package org.example.lld_interview_problems.parkinglot;

import org.example.lld_interview_problems.parkinglot.parkingspot.ParkingSpot;
import org.example.lld_interview_problems.parkinglot.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public class ParkingFloor {
    private String floorNumber;
    private List<ParkingSpot> parkingSpots;

    public ParkingFloor(String floorNumber, List<ParkingSpot> parkingSpots) {
        this.floorNumber = floorNumber;
        this.parkingSpots = parkingSpots;
    }

    public synchronized Optional<ParkingSpot> getAvailableSpot(Vehicle vehicle) {
        return parkingSpots.stream()
                .filter(spot -> spot.isAvailable() && spot.canFitVehicle(vehicle))
                .findFirst();
    }

    public String getFloorNumber() {
        return floorNumber;
    }
}
