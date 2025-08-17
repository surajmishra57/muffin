package org.example.desing_patterns.behavioral.b1_chain_of_responsibility_task.discountTask;

public class DiscountDefault implements Discount {
    @Override
    public void handleRequest(Order order) {
        System.out.println("this is default discount");
    }

    @Override
    public void setNextHandler(Discount discount) {

    }
}
