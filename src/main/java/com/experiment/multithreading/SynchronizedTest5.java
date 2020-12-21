package com.experiment.multithreading;

/**
 * 对类加锁
 */
public  class SynchronizedTest5 implements  Runnable{
    private static Integer count = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new SynchronizedTest5());//两个runnable对象
        Thread thread2 = new Thread(new SynchronizedTest5());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(count);//200000000
    }

    @Override
    public void run() {
        for(int i=0;i<100000000;i++){
            synchronized (SynchronizedTest5.class){
                count++;
            }
        }
    }

}
