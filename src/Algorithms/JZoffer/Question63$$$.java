package Algorithms.JZoffer;

import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，
 * 使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Question63$$$ {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap= new PriorityQueue<>(15, (o1, o2) -> o2 - o1);
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
