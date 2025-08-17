package org.example.desing_patterns.behavioral.b1_chain_of_responsibility_task.discountTask;

public class Order {
    private DiscountType discountType;

    public Order(DiscountType discountType) {
        this.discountType = discountType;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }
}
