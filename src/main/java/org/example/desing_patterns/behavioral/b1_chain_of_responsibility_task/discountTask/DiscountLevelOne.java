package org.example.desing_patterns.behavioral.b1_chain_of_responsibility_task.discountTask;

public class DiscountLevelOne implements Discount {
    private Discount discount;

    @Override
    public void handleRequest(Order order) {
        if (order.getDiscountType().equals(DiscountType.NEW_CUSTOMER))
            System.out.println("this is new customer discount.");
        else
            discount.handleRequest(order);
    }

    @Override
    public void setNextHandler(Discount discount) {
        this.discount = discount;
    }
}
