package multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import static java.lang.Thread.sleep;

public class CyclicBarrierTest {
    private static CyclicBarrier cyclicBarrier =new CyclicBarrier(3,()-> System.out.println("go"));

    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            new Thread(()->{
                while (true){
                    try {
                        cyclicBarrier.await();
                        sleep(1000);
                        System.out.println("ok");
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }
    }
}
