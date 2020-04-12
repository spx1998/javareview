package com.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * reentrant lock特点：可重入 可公平 响应中断 有时限
 */
public class ReentrantLockTest {
//    private static ReentrantLock lock = new ReentrantLock(true);公平锁
    public static void main(String[] args) throws InterruptedException {
        Thread t1 =new Thread(new Test1());
        t1.start();
        t1.join();
        System.out.println("test2:");
        Thread t2 = new Thread(new Test2(1));
        Thread t3 = new Thread(new Test2(2));
        t2.start();t3.start();
        t2.interrupt();
        t3.join();
        System.out.println("test3:");
        Thread t4 = new Thread(new Test3());
        Thread t5 = new Thread(new Test3());
        t4.start();t5.start();
    }
}

//重入
class Test1 implements Runnable{
    private static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        lock.lock();
        lock.lock();
        lock.unlock();
        lock.unlock();
//        lock.unlock(); 解锁多于加锁，报错
    }
}

//响应中断
class Test2 implements Runnable{
    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();
    private int num ;
    Test2(int num){
        this.num = num;
    }
    @Override
    public void run() {
        if(num==1){
            try {
                lock1.lockInterruptibly();
                System.out.println(Thread.currentThread().getId() +"获得锁1");
                sleep(500);
                lock2.lockInterruptibly();
                System.out.println(Thread.currentThread().getId() +"获得锁2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            try {
                lock2.lockInterruptibly();
                System.out.println(Thread.currentThread().getId() +"获得锁2");
                sleep(500);
                lock1.lockInterruptibly();
                System.out.println(Thread.currentThread().getId() +"获得锁1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(lock1.isHeldByCurrentThread()) {
            System.out.println(Thread.currentThread().getId() + "解开锁1");
            lock1.unlock();
        }
        if(lock2.isHeldByCurrentThread()) {
            System.out.println(Thread.currentThread().getId() +"解开锁2");
            lock2.unlock();
        }
        System.out.println(Thread.currentThread().getId()+"退出");
    }
}

//申请等待时限
class Test3 implements Runnable{
    private static ReentrantLock lock =new ReentrantLock();

    @Override
    public void run() {
        try {
            if(lock.tryLock(1, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getId() + "获得锁");
                sleep(2000);
                lock.unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId()+"退出");
    }
}