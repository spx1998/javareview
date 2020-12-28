package com.experiment.jvm;

/**
 * 三种synchronized的底层实现方式：
 * 代码块：monitorenter monitorexit
 * 静态/实例方法：方法上的 ACC_SYNCHRONIZED 标志
 *
 * @author sunpengxiang
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        staticMethod();
        new SynchronizedTest().ordinaryMethod();
        new SynchronizedTest().instanceMethod();
    }

    void ordinaryMethod() {
        synchronized (this) {
            System.out.println("ordinaryMethod");
        }
    }

    synchronized void instanceMethod() {
        System.out.println("instanceMethod");

    }

    static synchronized void staticMethod() {
        System.out.println("staticMethod");

    }
}
