package com.experiment.multithreading;

import static java.lang.Thread.sleep;

public class ThreadGroupTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup threadGroup = new ThreadGroup("tg");
        Thread thread1 = new Thread(threadGroup,()->{if(Thread.currentThread().isInterrupted()){
            System.out.println("thread1 interrupted");
        }},"t1");
        Thread thread2 = new Thread(threadGroup,()->{while (true);},"t1");
        thread1.start();
        thread2.start();
        thread1.interrupt();
        sleep(100);
        System.out.println(threadGroup.activeCount());//正在执行的线程数
        threadGroup.list();
    }

}
