package org.example.desing_patterns.behavioral.b3_state_desing_pattern;

/**
 * This is concreate class of Vending Machine State
 */
public class ReadyState implements VendingMachineState {
    @Override
    public void handelRequest() {
        System.out.println("This is ready state");
    }
}
