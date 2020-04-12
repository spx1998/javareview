package com.experiment;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(3);
        priorityQueue.add(5);
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(4);
        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());//1 2 3 4 5
        }
    }
}
