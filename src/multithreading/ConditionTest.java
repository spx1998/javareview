package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * condition的await() signal() signalAll()与object的wait() notify() notifyAll() 类似 ，更安全高效
 */
public class ConditionTest {
    private static ReentrantLock lock =new ReentrantLock();
    private static Condition condition = lock.newCondition();
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            System.out.println("new thread");
            lock.lock();
            System.out.println("lock already");
            try {
                System.out.println("await");
                condition.await();//会释放当前锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread finish");
        });
        thread.start();
        Thread.sleep(3000);
        lock.lock();
        System.out.println("signal");
        condition.signal();
        lock.unlock();
    }
}
