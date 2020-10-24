package com.algorithms.classical;

/**
 * 管程实现生产者消费者模型
 */
public class BoundedBufferProblem {
    private Monitor monitor;

    BoundedBufferProblem(int n) {
        monitor = new Monitor(n);
    }

    public static void main(String[] args) {
        BoundedBufferProblem boundedBufferProblem = new BoundedBufferProblem(5);
        new Thread(boundedBufferProblem.new Producer()).start();
        new Thread(boundedBufferProblem.new Consumer()).start();
    }


    class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                System.out.println("produce");
                monitor.insert(1);
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                monitor.remove();
                System.out.println("consume");
            }
        }
    }

    class Monitor {
        final int capacity;
        final int[] buffer;
        int count, lo, hi;

        Monitor(int n) {
            buffer = new int[n];
            capacity = n;
        }

        public synchronized void insert(int item) {
            if (count == capacity) {
                goToSleep("producer");
            }
            buffer[hi] = item;
            hi = (hi + 1) % capacity;
            count++;
            if (count == 1) {
                notify();
            }
        }

        public synchronized int remove() {
            if (count == 0) {
                goToSleep("consumer");
            }
            int item = buffer[lo];
            lo = (lo + 1) % capacity;
            if (count == capacity) {
                notify();
            }
            count--;
            return item;
        }

        private void goToSleep(String role) {
            try {
                System.out.println(role + " sleep");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
