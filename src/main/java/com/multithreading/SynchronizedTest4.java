package com.multithreading;

/**
 * 对静态方法加锁
 */
public class SynchronizedTest4 implements Runnable{
    private static Integer count = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new SynchronizedTest4());//两个runnable对象
        Thread thread2 = new Thread(new SynchronizedTest4());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(count);//200000000
    }

    @Override
    public void run() {
        for(int i=0;i<100000000;i++){
            increase();
        }
    }

    private  static synchronized void increase() {
        count++;
    }
}
