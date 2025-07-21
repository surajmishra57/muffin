package org.example.cuncurrency.basic;

/**(
 * This is the basic Example of sleep() And wait() Method With notify()
 *
 * sleep() :   When a thread calls sleep(), it pauses execution for the specified time.
 *             However, it does NOT release any locks it was holding.
 *             Other threads cannot access synchronized resources held by the sleeping thread.
 *
 * wait() :   When a thread calls wait(), it releases the lock on the synchronized object it was holding.
 *            Other threads can now acquire the lock and continue execution.
 *            The waiting thread remains idle until another thread calls notify() or notifyAll().
 *
 * notify() : When notify() or notifyAll() is called, the waiting thread does not immediately start running. Instead,
 *            it follows these steps:
 *
 *            When another thread calls notify(), one waiting thread is moved to the Blocked (or Runnable) State,
 *            but it does not start execution immediately.
 *            The notified thread cannot resume execution until it successfully
 *            acquires the lock on the synchronized object.
 *            If multiple threads are waiting, only one gets notified by notify(), while notifyAll() wakes up all
 *            waiting threads (but they still compete for the lock).
 *            Once the thread reacquires the lock, it continues execution from where it called wait().
 *
 * notifyAll() : If we replace notify(); with notifyAll();, all waiting threads will be notified,
 *               but only one will acquire the lock first as they will
 *               compete for the lock, and execution depends on the thread scheduler.
 */
public class Example_1_PausingAndWaitingForNotification {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread thread1 = new Thread(sharedResource::waitNotification);
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(10000);
                sharedResource.notifyExample();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        thread1.start();
        thread2.start();
    }
}

class SharedResource {
    synchronized void waitNotification() {
        System.out.println("Notification Thread Started......");
        try {
            wait();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Notification Thread Work Completed.......");
    }

    synchronized void notifyExample() {
        System.out.println("Goting To Up Notification Thread...");
        notify();
    }
}
