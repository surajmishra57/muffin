package org.example.cuncurrency.basic;

import java.util.PriorityQueue;
import java.util.Queue;

public class Example_3_ProducerConsumerProblem {

    Queue<Integer> queue = new PriorityQueue<>();
    static int size = 5;

    public static void main(String[] args) {
        Example_3_ProducerConsumerProblem ex = new Example_3_ProducerConsumerProblem();
        Thread producerThread = new Thread(ex::producer);
        Thread consumerThread = new Thread(ex::consumer);
        producerThread.start();
        consumerThread.start();
    }

    public void consumer() {
        while (true) {
            try {
                synchronized (this) {
                    while (queue.isEmpty()) {
                        System.out.println("Queue is empty waiting for new msg....");
                        wait();
                    }
                    System.out.println("Consumed value is " + queue.poll());
                    notifyAll();
                }
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Error in Consumer " + e.getMessage());
                Thread.interrupted();
            }
        }
    }

    public void producer() {
        int value = 0;
        while (true) {
            try {
                synchronized (this) {
                    if (queue.size() == size) {
                        System.out.println("queue is full producer is waiting...");
                        wait();
                    }
                    System.out.println("produced value is " + value);
                    queue.offer(value++);
                    notifyAll();
                }
                Thread.sleep(4000);
            } catch (Exception e) {
                System.out.println("Some Error In Producer : " + e.getMessage());
                Thread.interrupted();
            }
        }
    }
}


