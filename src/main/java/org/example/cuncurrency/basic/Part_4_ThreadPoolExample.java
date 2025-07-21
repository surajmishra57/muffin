package org.example.cuncurrency.basic;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Thread pools are a managed collection of reusable threads designed to execute tasks concurrently.
 * They offer significant advantages in resource management, performance, and application stability. 🛠️
 */
public class Part_4_ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 10; i++) {
            executor.submit(new WorkerThread(i));
        }
        executor.shutdown();
    }
}

class WorkerThread implements Runnable {
    int taskId;

    WorkerThread(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getId() + " is processing task" + taskId);
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getId() + " task finished" + taskId);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
