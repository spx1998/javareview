package Algorithms.JZoffer;

import java.util.PriorityQueue;

public class Question63$$$ {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(15, (o1, o2) -> o2-o1);
    private int count=0;
    public void Insert(Integer num) {
        if(count%2==0){
            maxHeap.offer(num);
            int max= maxHeap.poll();
            minHeap.offer(max);
        }else {
            minHeap.offer(num);
            int min = minHeap.poll();
            maxHeap.offer(min);
        }
        count++;
    }

    public Double GetMedian() {
        if(count%2==0){
            return (double) (minHeap.peek() + maxHeap.peek()) /2;
        }
        else return (double) minHeap.peek();
    }
}
