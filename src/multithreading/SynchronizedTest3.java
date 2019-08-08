package multithreading;

/**
 *对非静态方法加锁
 */
public class SynchronizedTest3 implements Runnable{
    private static Integer count = 0;
    public static void main(String[] args) throws InterruptedException {
        SynchronizedTest3 synchronizedTest3 = new SynchronizedTest3();
        Thread thread1 = new Thread(synchronizedTest3);//同一个runnable对象
        Thread thread2 = new Thread(synchronizedTest3);
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

    private synchronized void increase() {
        count++;
    }
}
