package org.example.cuncurrency.basic;

public class Example_4_1_ZigZagProblem {
    private boolean isZigTurn = true;
    private int max = 5;

    public static void main(String[] args) {
        Example_4_1_ZigZagProblem ex = new Example_4_1_ZigZagProblem();
        Thread thread1 = new Thread(ex::printZig);
        Thread thread2 = new Thread(ex::printZag);
        thread1.start();
        thread2.start();
    }

    private void printZag() {
        int val = 1;
        while (val < max) {
            try {
                synchronized (this) {
                    while (isZigTurn) {
                        wait();
                    }
                    System.out.println("zag");
                    val += 2;
                    isZigTurn = true;
                    notify();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printZig() {
        int val = 2;
        while (val < max) {
            try {
                synchronized (this) {
                    while (!isZigTurn) {
                        wait();
                    }
                    System.out.println("zig");
                    val += 2;
                    isZigTurn = false;
                    notify();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
