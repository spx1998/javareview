package com.multithreading;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolTest extends RecursiveTask<Long> {
    private long start ;
    private long end;
    private static final long THRESHOLD=10000;

    private ForkJoinPoolTest(long i, long l) {
        start = i;
        end = l;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinPoolTest task = new ForkJoinPoolTest(0,200000L);
        ForkJoinTask<Long> result = forkJoinPool.submit(task);
        long res = result.get();
        System.out.println("sum="+ res);
    }

    @Override
    protected Long compute() {
        long sum=0;
        if(end-start<THRESHOLD){
            for(long i=start;i<=end;i++){
                sum+=i;
            }
        }else {
            long step = (end-start)/100;
            ArrayList<ForkJoinPoolTest> subTasks = new ArrayList<>();
            long pos = start;
            for(int i=0;i<100;i++){
                long lastOne = pos +step;
                if(lastOne>end)lastOne = end;
                ForkJoinPoolTest subTask = new ForkJoinPoolTest(pos,lastOne);
                pos+=step+1;
                subTasks.add(subTask);
                subTask.fork();
            }
            for(ForkJoinPoolTest t:subTasks){
                sum += t.join();
            }
        }
        return sum;
    }

}
