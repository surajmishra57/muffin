package org.example.desing_patterns.behavioral.b1_chain_of_responsibility_task.discountTask;

public class Main {
    public static void main(String[] args) {
        Discount level1 = new DiscountLevelOne();
        Discount level2 = new DiscountLevelTwo();
        Discount level3 = new DiscountLevelThree();

        level1.setNextHandler(level2);
        level2.setNextHandler(level3);

        Order order = new Order(DiscountType.FESTIVE_DISCOUNT);
        Order order1 = new Order(DiscountType.LOYAL_CUSTOMER);
        Order order2 = new Order(DiscountType.NEW_CUSTOMER);

        level1.handleRequest(order);
        level1.handleRequest(order1);
        level1.handleRequest(order2);

    }
}
