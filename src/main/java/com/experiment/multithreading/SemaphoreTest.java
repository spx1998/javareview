package com.experiment.multithreading;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class SemaphoreTest implements Runnable{
    private static final Semaphore semaphore = new Semaphore(3);
    public static void main(String[] args) {
        Thread t1 = new Thread(new SemaphoreTest());
        Thread t2 = new Thread(new SemaphoreTest());
        Thread t3 = new Thread(new SemaphoreTest());
        Thread t4 = new Thread(new SemaphoreTest());
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    @Override
    public void run() {
//        try {
//            semaphore.acquire();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        if(semaphore.tryAcquire()) {
            System.out.println(Thread.currentThread().getId() + " is running");

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
        }

    }
}
