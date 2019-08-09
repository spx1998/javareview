package multithreading;

import java.util.concurrent.*;

public class ExecutorTest implements Runnable{
    public static void main(String[] args) {
        //executor service   利用Java自带的executors生成几种线程池。
        ExecutorService fixExecutorService = Executors.newFixedThreadPool(3);
        ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();
        ExecutorService cachedExecutorService = Executors.newCachedThreadPool();
        ScheduledExecutorService executorService1 = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService executorService2 = Executors.newScheduledThreadPool(3);
        //自定义的线程池 thread pool executor
        Executor executor = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5),
                r -> new Thread(new ExecutorTest()), new ThreadPoolExecutor.AbortPolicy());
        fixExecutorService.submit(new ExecutorTest());
        fixExecutorService.execute(new ExecutorTest());
        executorService1.scheduleAtFixedRate(()->{
            System.out.println("schedule");
        },0,0,TimeUnit.SECONDS);//固定频率  scheduleAtFixedDelay->固定间隔
        //四种等待队列：SynchronousQueue ArrayBlockingQueue LinkedBlockingQueue PriorityBlockingQueue
        //四种拒绝策略：AbortPolicy CallerRunsPolicy DiscardOldestPolicy DiscardPolicy

    }

    @Override
    public void run() {

    }
}
