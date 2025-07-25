package org.example.desing_patterns.behavioral.b3_state_desing_pattern;

/**
 * This is concreate class of VendingMachineState
 */
public class OutOfStockState implements VendingMachineState {
    @Override
    public void handelRequest() {
        System.out.println("This is OutOfStock State......");
    }
}
