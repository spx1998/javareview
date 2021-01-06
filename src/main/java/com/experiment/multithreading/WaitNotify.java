package com.experiment.multithreading;

import static java.lang.Thread.sleep;

/**
 * @author sunpengxiang
 */
public class WaitNotify implements Runnable {
    static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new WaitNotify());
        thread.start();
        sleep(100);
        synchronized (lock) {//显然 wait 会释放当前线程的锁，而sleep()不会。
            System.out.println(System.currentTimeMillis() + " notify");
            lock.notify();
            sleep(1000);

        }
        Thread thread2 = new Thread(() -> {
            System.out.println(System.currentTimeMillis() + " thread2 start");
            synchronized (lock) {
                try {
                    lock.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(System.currentTimeMillis() + " thread2 finish");
        });
        thread2.start();
    }

    @Override
    public void run() {
        System.out.println("thread start!");
        try {
            synchronized (lock) {
                System.out.println(System.currentTimeMillis() + " wait");
                lock.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() + " thread end!");//时间戳说明 要取得o的锁，thread才会唤醒
    }
}
