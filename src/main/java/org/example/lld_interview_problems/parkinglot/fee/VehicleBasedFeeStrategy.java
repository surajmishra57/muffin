package org.example.lld_interview_problems.parkinglot.fee;

import org.example.lld_interview_problems.parkinglot.ParkingTicket;
import org.example.lld_interview_problems.parkinglot.vehicle.VehicleType;

import java.util.Map;

public class VehicleBasedFeeStrategy implements FeeStrategy {
    private final Map<VehicleType, Double> hourlyRate = Map.of(
            VehicleType.BIKE, 10.0,
            VehicleType.CAR, 20.0,
            VehicleType.TRUCK, 30.0
    );

    @Override
    public double calculateFee(ParkingTicket parkingTicket) {
        long duration = parkingTicket.getExitTimestamp() - parkingTicket.getEntryTimestamp();
        long hour = (duration / (1000 * 60 * 60)) + 1;
        return hourlyRate.get(parkingTicket.getVehicle().getVehicleType()) * hour;
    }
}
