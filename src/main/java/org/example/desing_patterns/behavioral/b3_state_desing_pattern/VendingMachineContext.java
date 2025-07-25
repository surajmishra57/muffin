package org.example.desing_patterns.behavioral.b3_state_desing_pattern;

/**
 * This is VendingMachineContext
 */
public class VendingMachineContext {
    VendingMachineState state;

    public void setContext(VendingMachineState vendingMachineState) {
        this.state = vendingMachineState;
    }

    public void request() {
        state.handelRequest();
    }

}
