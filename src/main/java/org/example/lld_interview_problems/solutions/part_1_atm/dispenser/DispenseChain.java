package org.example.lld_interview_problems.solutions.part_1_atm.dispenser;

public interface DispenseChain {
    void setNextChain(DispenseChain nextChain);

    void dispense(int amount);

    boolean canDispense(int amount);

}
