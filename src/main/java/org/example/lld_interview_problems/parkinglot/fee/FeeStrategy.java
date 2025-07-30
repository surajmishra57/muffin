package org.example.lld_interview_problems.parkinglot.fee;

import org.example.lld_interview_problems.parkinglot.ParkingTicket;

public interface FeeStrategy {
    double calculateFee(ParkingTicket parkingTicket);
}
