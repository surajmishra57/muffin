package org.example.desing_patterns.behavioral.b1_chain_of_responsibility_task.discountTask;

public interface Discount {
    void handleRequest(Order order);

    void setNextHandler(Discount discount);
}
