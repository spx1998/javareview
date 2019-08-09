package multithreading;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.lang.Thread.sleep;

public class ReadWriteLockTest {
    private static ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();
    public static void main(String[] args) {
        Runnable read = new Runnable() {
            @Override
            public void run() {
                readLock.lock();
                try {
                    System.out.println("read");
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                readLock.unlock();
            }
        };
        Runnable write = new Runnable() {
            @Override
            public void run() {
                writeLock.lock();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("write");
                writeLock.unlock();
            }
        };
        for(int i=0;i<8;i++){
            new Thread(write).start();
        }
        for(int i=0;i<20;i++){
            new Thread(read).start();
        }
    }


}
