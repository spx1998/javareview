package multithreading;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            LockSupport.park();
            System.out.println(Thread.currentThread().getId());
        });
        Thread t2 = new Thread(()->{
            LockSupport.park();
            System.out.println(Thread.currentThread().getId());
        });
        t1.start();
        t2.start();
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);//类似信号量的机制 不会有suspend resume 顺序的问题

    }
}
