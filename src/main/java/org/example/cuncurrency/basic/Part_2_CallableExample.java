package org.example.cuncurrency.basic;

import java.util.concurrent.*;

public class Part_2_CallableExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Callable<String> callable1 = new CustomCallAble();
        Callable<String> callable2 = new CustomCallAble();
        try {
            Future<String> result = executorService.submit(callable1);
            Future<String> result1 = executorService.submit(callable2);
            System.out.println(result.get());
            System.out.println(result1.get());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            executorService.shutdown();
        }

    }
}

class CustomCallAble implements Callable<String> {

    @Override
    public String call() throws Exception {
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            System.out.println("current thread " + Thread.currentThread().getId());
            st.append("current thread ").append(Thread.currentThread().getId()).append(" is running").append(" ").append(i).append("\n");
        }
        return String.valueOf(st);
    }
}
