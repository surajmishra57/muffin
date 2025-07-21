package org.example.cuncurrency.basic;

/**
 * Scenario: Restaurant Order Processing 🍔
 * Thread A (Waiter) takes the customer's order and waits for the chef to prepare the food.
 * Thread B (Chef) prepares the food and notifies the waiter when it's ready.
 */
public class Example_2_RestaurantOrderProcessing {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread waiter = new Waiter(lock);
        Thread chef = new Chef(lock);
        waiter.start();
        chef.start();
    }
}

class Waiter extends Thread {
    Object lock;

    Waiter(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                System.out.println("Waiter : waiting for order to get ready.......");
                new Thread().join();
                lock.wait();

                /** also is used here
                 * Object().wait();
                 * Object().wait();
                 * LockSupport.park();
                 */
                System.out.println("Waiter : order received going to delever to customer....");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}

class Chef extends Thread {
    Object lock;

    Chef(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(10000);
            synchronized (lock) {
                System.out.println("Chef : Food is ready notifying the waiter.");
                lock.notify();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}