package multithreading;

import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;

public class CountDownLatchTest {
    private static CountDownLatch countDownLatch = new CountDownLatch(3);
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<3;i++){
            new Thread(()->{
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId()+" is ready");
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("go!");

    }
}
