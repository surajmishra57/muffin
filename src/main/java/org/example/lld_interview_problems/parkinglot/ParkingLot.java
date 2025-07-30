package org.example.lld_interview_problems.parkinglot;

import org.example.lld_interview_problems.parkinglot.fee.FeeStrategy;
import org.example.lld_interview_problems.parkinglot.fee.FlatRateFeeStrategy;
import org.example.lld_interview_problems.parkinglot.parkingspot.ParkingSpot;
import org.example.lld_interview_problems.parkinglot.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {
    private static final ParkingLot INSTANCE = new ParkingLot();
    private final List<ParkingFloor> floors = new ArrayList<>();
    private final Map<String, ParkingTicket> activeTickets = new ConcurrentHashMap<>();
    private FeeStrategy feeStrategy;

    private ParkingLot() {
        feeStrategy = new FlatRateFeeStrategy();
    }

    public static ParkingLot getInstance() {
        return INSTANCE;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public synchronized ParkingTicket parkVehicle(Vehicle vehicle) throws Exception {
        for (ParkingFloor floor : floors) {
            Optional<ParkingSpot> spotOpt = floor.getAvailableSpot(vehicle);
            if (spotOpt.isPresent()) {
                ParkingSpot spot = spotOpt.get();
                if (spot.assignVehicle(vehicle)) {
                    ParkingTicket ticket = new ParkingTicket(vehicle, spot);
                    activeTickets.put(vehicle.getLicenceNumber(), ticket);
                    return ticket;
                }
            }
        }
        throw new Exception("No available spot for " + vehicle.getVehicleType());
    }

    public synchronized double unparkVehicle(String licence) throws Exception {
        ParkingTicket ticket = activeTickets.remove(licence);
        if (ticket == null) throw new Exception("Ticket Not Found");
        ticket.getParkingSpot().removeVehicle();
        ticket.setExitTimestamp();
        return feeStrategy.calculateFee(ticket);
    }
}
