package org.example.cuncurrency.basic;

public class Example_4_OddEvenProblem {
    private int MAX = 20;
    private boolean isOddTurn = true;

    public static void main(String[] args) {
        Example_4_OddEvenProblem ex = new Example_4_OddEvenProblem();
        Thread oddNumbers = new Thread(ex::printOddNumbers);
        Thread evenNumbers = new Thread(ex::printEvenNumbers);
        oddNumbers.start();
        evenNumbers.start();
    }

    public void printEvenNumbers() {
        int val = 2;
        while (val <= MAX) {
            synchronized (this) {
                while (isOddTurn) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Even Number: " + val);
                val += 2;
                isOddTurn = true;
                notify();
            }
        }
    }

    public void printOddNumbers() {
        int val = 1;
        while (val <= MAX) {
            synchronized (this) {
                while (!isOddTurn) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Odd Number: " + val);
                val += 2;
                isOddTurn = false;
                notify();
            }
        }
    }
}
