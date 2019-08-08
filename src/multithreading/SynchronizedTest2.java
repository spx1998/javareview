package multithreading;

/**
 * 对final对象加synchronized锁
 */
public class SynchronizedTest2 implements Runnable{
    private final Object o = new Object();
    private static Integer count = 0;
    public static void main(String[] args) throws InterruptedException {
        SynchronizedTest2 synchronizedTest2 = new SynchronizedTest2();
        Thread thread1 = new Thread(synchronizedTest2);//同一个runnable对象
        Thread thread2 = new Thread(synchronizedTest2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(count);//200000000
    }

    @Override
    public void run() {
        for(int i=0;i<100000000;i++){
        synchronized (o){
            count++;
        }
        }
    }
}
