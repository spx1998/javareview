package com.experiment.multithreading;

/**
 * 下例中，如果不对s添加volatile修饰符，THREAD start, s is false ，说明线程THREAD不能感知到s到变化，故而陷入了死循环。
 * 用volatile修饰s后，将依次输出THREAD start, s is false, THREAD stop 说明线程THREAD感知到了s的变化，退出了循环。
 */
public class VolatileTest {
    private static /*volatile*/ boolean s = true;
    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("THREAD start");
            while (s) {
                i++;
            }
            System.out.println("THREAD stop");
        }, "THREAD").start();
        Thread.sleep(100);
        s = false;
        System.out.println("s is false!");
    }
}
