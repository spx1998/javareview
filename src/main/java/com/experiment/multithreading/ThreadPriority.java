package com.experiment.multithreading;

public class ThreadPriority {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{for(int i=0;i<100;i++){}
            System.out.println("t1 finish");});
        Thread t2 = new Thread(()->{for(int i=0;i<100;i++){}
            System.out.println("t2 finish");});
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);//t2比t1先完成的概率大，但并非总是如此
        t1.start();
        t2.start();
    }
}
