package com.multithreading;

public class NewThread {
    public static void main(String[] args) {
        //重写run接口
        Thread thread1 =new Thread(){@Override public void run(){
            int i=0;
            while (i<100) {
                System.out.println(" thread1！");

                i++;
            }
        }};

        //使用构造方法，传入实现了runnable接口的对象
        Thread thread2 = new Thread(()->{
            int i=0;
            while (i<100) {
                System.out.println(" thread2!");
                i++;
            }
        });
        thread1.start();
        thread2.start();
    }
}
