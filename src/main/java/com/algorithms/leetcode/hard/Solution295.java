package com.algorithms.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * 例如，
 * [2,3,4]的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 进阶:
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 */
public class Solution295 {
    class MedianFinder {
        List<Integer> list;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            list = new ArrayList<>();
        }

        public void addNum(int num) {
            if (list.size() == 0) {
                list.add(num);
            } else if (list.get(0) >= num) {
                list.add(0, num);
            } else if (list.get(list.size() - 1) <= num) {
                list.add(num);
            } else {
                int left = 0;
                int right = list.size() - 1;
                while (left <= right) {
                    int temp = left + (right - left) / 2;
                    if (list.get(temp) == num) {
                        list.add(temp, num);
                        return;
                    }
                    if (list.get(temp) > num) {
                        if (list.get(temp - 1) <= num) {
                            list.add(temp, num);
                            return;
                        }
                        right = temp - 1;
                    } else if (list.get(temp) < num) {
                        if (list.get(temp + 1) >= num) {
                            list.add(temp + 1, num);
                            return;
                        }
                        left = temp + 1;
                    }
                }
            }

        }

        public double findMedian() {
            int size = list.size();
            if (size == 0) {
                return 0;
            }
            if (size % 2 == 0) {
                return ((double) (list.get(size / 2) + list.get(size / 2 - 1))) / 2;
            } else {
                return list.get(size / 2);
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
