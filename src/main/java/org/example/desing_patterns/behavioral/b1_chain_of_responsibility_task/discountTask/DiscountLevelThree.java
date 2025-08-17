package org.example.desing_patterns.behavioral.b1_chain_of_responsibility_task.discountTask;

public class DiscountLevelThree implements Discount {
    private Discount discount;

    @Override
    public void handleRequest(Order order) {
        if (order.getDiscountType().equals(DiscountType.FESTIVE_DISCOUNT))
            System.out.println("this is festive discount");
        else
            discount.handleRequest(order);
    }

    @Override
    public void setNextHandler(Discount discount) {
        this.discount = discount;
    }
}
