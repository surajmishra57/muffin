package org.example.lld_interview_problems.parkinglot;

import org.example.lld_interview_problems.parkinglot.fee.VehicleBasedFeeStrategy;
import org.example.lld_interview_problems.parkinglot.parkingspot.ParkinSpotType;
import org.example.lld_interview_problems.parkinglot.parkingspot.ParkingSpot;
import org.example.lld_interview_problems.parkinglot.parkingspot.ParkingSpotFactory;
import org.example.lld_interview_problems.parkinglot.vehicle.*;

import java.util.List;

public class ParkingLotDemo {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        ParkingLot parkingLot = ParkingLot.getInstance();

        List<ParkingSpot> parkingSpotsFloor1 = List.of(
                ParkingSpotFactory.createParkingSpot("101", ParkinSpotType.BIKE),
                ParkingSpotFactory.createParkingSpot("102", ParkinSpotType.COMPACT),
                ParkingSpotFactory.createParkingSpot("101", ParkinSpotType.LARGE)
        );

        List<ParkingSpot> parkingSpotsFloor2 = List.of(
                ParkingSpotFactory.createParkingSpot("201", ParkinSpotType.BIKE),
                ParkingSpotFactory.createParkingSpot("202", ParkinSpotType.LARGE)
        );

        ParkingFloor floor1 = new ParkingFloor("1", parkingSpotsFloor1);
        ParkingFloor floor2 = new ParkingFloor("2", parkingSpotsFloor2);


        parkingLot.setFeeStrategy(new VehicleBasedFeeStrategy());

        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);
        Vehicle bike = new Bike("12345", VehicleType.BIKE);
        Vehicle car = new Car("54321", VehicleType.CAR);
        Vehicle truck = new Truck("98765", VehicleType.TRUCK);


        try {
            ParkingTicket parkingTicket = parkingLot.parkVehicle(bike);
            System.out.println("parked " + parkingTicket.getTicketId());

            ParkingTicket parkingTicket1 = parkingLot.parkVehicle(car);
            System.out.println("parked" + parkingTicket1.getTicketId());


            System.out.println(parkingLot.unparkVehicle(parkingTicket1.getVehicle().getLicenceNumber()));
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
