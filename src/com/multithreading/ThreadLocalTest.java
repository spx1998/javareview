package com.multithreading;

import static java.lang.Thread.sleep;

public class ThreadLocalTest implements Runnable{
    private static ThreadLocal<Long> myNumber = new ThreadLocal<>();
    private static int num =0;
    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest test = new ThreadLocalTest();
        new Thread(test).start();
        new Thread(new ThreadLocalTest()).start();
        sleep(1000);
    }


    @Override
    public void run() {
        if(myNumber.get()==null)
            myNumber.set(0L);
        for (int i = 0; i < 10000; i++) {
            num++;
            myNumber.set(myNumber.get() + 1);
        }
        System.out.println(num);
        System.out.println(myNumber.get());
        myNumber.remove();//不remove会导致内存泄漏
    }
}
