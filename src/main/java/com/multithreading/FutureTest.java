package com.multithreading;

import java.util.concurrent.*;

/**
 * @author sunpengxiang
 *
 * future可以重复get。
 */
public class FutureTest {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(30, 50, 20,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));

        Future<Integer> futureTask = executorService.submit(new TestTask());
        try {
            System.out.println("first " + futureTask.get(1, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("second " + futureTask.get());
            System.out.println("third " + futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }

    static class TestTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(2000);
            return 1;
        }
    }
}
