package org.example.desing_patterns.behavioral.b3_state_desing_pattern;

public class Main {
    public static void main(String[] args) {

        ReadyState readyState = new ReadyState();
        OutOfStockState outOfStockState = new OutOfStockState();
        PaymentProcessingState paymentProcessingState = new PaymentProcessingState();
        ProductSelectState productSelectState = new ProductSelectState();

        VendingMachineContext context = new VendingMachineContext();
        context.setContext(readyState);
        context.request();


        context.setContext(productSelectState);
        context.request();

        context.setContext(paymentProcessingState);
        context.request();

        context.setContext(outOfStockState);
        context.request();
    }
}
