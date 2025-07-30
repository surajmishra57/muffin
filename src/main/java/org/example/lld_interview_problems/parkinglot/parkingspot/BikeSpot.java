package org.example.lld_interview_problems.parkinglot.parkingspot;

import org.example.lld_interview_problems.parkinglot.vehicle.Vehicle;
import org.example.lld_interview_problems.parkinglot.vehicle.VehicleType;

public class BikeSpot extends ParkingSpot {
    public BikeSpot(String spotId) {
        super(spotId);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType().equals(VehicleType.BIKE);

    }
}
