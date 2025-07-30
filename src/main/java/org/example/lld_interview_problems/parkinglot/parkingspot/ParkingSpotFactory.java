package org.example.lld_interview_problems.parkinglot.parkingspot;

public class ParkingSpotFactory {
    public static ParkingSpot createParkingSpot(String spotId, ParkinSpotType parkinSpotType) {
        return switch (parkinSpotType) {
            case BIKE -> new BikeSpot(spotId);
            case COMPACT -> new CompactSpot(spotId);
            case LARGE -> new CompactSpot(spotId);
            default -> throw new IllegalArgumentException("UnKnown parking  spot type : " + parkinSpotType);
        };

    }
}
