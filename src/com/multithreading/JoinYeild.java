package com.multithreading;

import static java.lang.Thread.sleep;

public class JoinYeild {
    private static int i=0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{while (i<1000) {
            i++;
//            Thread.yield(); 会让出cpu资源 重新加入抢占
            try {
                sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        });
        thread.start();
        thread.join(); //等待thread结束才继续执行
//        thread.join(50); 50毫秒后，若thread仍未完成，本线程也不再等待，向下执行
        sleep(100);
        System.out.println(i);
    }
}
