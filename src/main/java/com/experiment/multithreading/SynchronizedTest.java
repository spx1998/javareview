package com.experiment.multithreading;

import java.util.HashMap;

public class SynchronizedTest {
    private static String s = "LOCK";
    public static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public SynchronizedTest() {
        hashMap.put(1, 1);
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (s) {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(hashMap.size());
                }
            }
        }).start();

        for (int i = 0; i < 100; i++) {
            Thread.sleep(10);
            hashMap.put(i, 1);
        }
    }


}
