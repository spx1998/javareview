package multithreading;

/**
 * 不加synchronized锁
 */
public class SynchronizedTest1 {
    private static volatile int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(()->{for(int i=0;i<100000000;i++){count++;}});
        Thread thread2 = new Thread(()->{for(int i=0;i<100000000;i++){count++;}});
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(count); //小于200000000
    }
}
