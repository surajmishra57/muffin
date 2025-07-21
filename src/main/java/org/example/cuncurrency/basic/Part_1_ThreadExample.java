package org.example.cuncurrency.basic;

/**
 * Thread Can be created using two-way
 * ->Thread Class
 * ->Runnable Interface
 */

// Thread Class Example

class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getId() + " is running " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class CustomThread implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getId() + " is running in interface " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Part_1_ThreadExample {
    public static void main(String[] args) {
        Thread thread1 = new MyThread();
        Thread thread2 = new MyThread();

        thread1.start();
        thread2.start();


        Thread t1 = new Thread(new CustomThread());
        Thread t2 = new Thread(new CustomThread());

        t1.start();
        t2.start();
    }
}
