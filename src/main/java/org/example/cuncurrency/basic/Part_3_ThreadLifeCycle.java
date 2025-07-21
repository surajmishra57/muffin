package org.example.cuncurrency.basic;

import java.util.concurrent.ExecutionException;

/**
 * Thread Life Cycle All State
 * 1.New
 * <p>
 * 2.Runnable
 * Thread is ready for execution and waiting for CPU allocation
 * Once start() is called, thread moves to this state
 * Includes ready-to-run state
 * <p>
 * 3.Running
 * The thread is currently executing its task on the CPU.
 * The CPU scheduler has allocated processing time to this thread.
 * <p>
 * 4.Blocked
 * Thread is temporarily inactive while waiting to acquire a lock
 * Typically occurs when trying to enter a synchronized block/method already locked by another thread
 * <p>
 * 5.Waiting
 * Thread is waiting indefinitely for another thread to perform a specific action
 * Entered via methods like Object.wait(), Thread.join(), or LockSupport.park()
 * No timeout specified
 * <p>
 * 6.Time Waiting
 * Thread is waiting for a specified period of time
 * Entered via methods like Thread.sleep(timeout), Object.wait(timeout), etc.
 * Will automatically return to RUNNABLE after timeout expires or notification
 * <p>
 * 7.Terminated
 * Thread has completed its execution or was stopped
 * The run() method has exited, either normally or due to an exception
 * Thread object still exists but cannot be restarted
 */
public class Part_3_ThreadLifeCycle {
    public static void main(String[] args) {
        Part_3_ThreadLifeCycle ex = new Part_3_ThreadLifeCycle();

        ex.threadNewStateExample();
        ex.threadRunnableStateExample();
        ex.threadRunningStateExample();
        ex.threadBlockedStateExample();
        ex.threadWaitingStateExample();
        ex.threadTimedWaitedExample();
        // After thread's run() method completes
        // Thread is in TERMINATED state
    }

    private void threadTimedWaitedExample() {
        try {
            Thread.sleep(1000); // Time Waited State Where Time is 1 second
        } catch (Exception e) {

        }
    }

    private void threadWaitingStateExample() {
        synchronized (Part_3_ThreadLifeCycle.class) {
            try {
                wait(); // thread Entered In Waiting State
            } catch (Exception e) {

            }
        }
    }

    private void threadBlockedStateExample() {
        synchronized (this) {
            // If another thread holds lockObject's monitor,
            // this thread will be BLOCKED until lock is available
        }
    }

    private void threadRunningStateExample() {
        Thread trse = new Thread(() -> System.out.println("This is new Thread"));
        trse.start(); // here thread is in runnable state and eventually moving in running state
    }

    private void threadRunnableStateExample() {
        Thread trse = new Thread(() -> System.out.println("This is new Thread"));
        trse.start(); // thread is in runnable state here
    }

    private void threadNewStateExample() {
        // This is example of new thread state
        new Thread(() -> System.out.println("Hello This is new Thread"));
    }
}

