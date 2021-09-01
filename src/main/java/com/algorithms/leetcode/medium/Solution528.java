package com.algorithms.leetcode.medium;

/**
 * 给定一个正整数数组 w ，其中 w[i] 代表下标 i 的权重（下标从 0 开始），请写一个函数 pickIndex ，它可以随机地获取下标 i，选取下标 i 的概率与 w[i] 成正比。
 * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。
 * 也就是说，选取下标 i 的概率为 w[i] / sum(w) 。
 * <p>
 * 解法：
 * 随机数+二分查找（我的写法要1000多ms，换成题解写法只要几十ms。。）
 */
public class Solution528 {

    class Solution {

        int size;
        int[] w;

        public Solution(int[] w) {
            for (int i = 1; i < w.length; i++) {
                w[i] = w[i - 1] + w[i];
            }
            this.w = w;
            this.size = w[w.length - 1];
        }

        public int pickIndex0() {
            int random = (int) (Math.random() * size + 1);
            int left = 0;
            int right = w.length - 1;
            while (left <= right) {
                int temp = left + (right - left) / 2;
                if (random == w[temp]) {
                    return temp;
                } else if (random < w[temp]) {
                    right = right - 1;
                } else {
                    left = left + 1;
                }
            }
            return left;
        }

        /**
         * 题解 二分
         */
        public int pickIndex() {
            int x = (int) (Math.random() * size) + 1;
            return binarySearch(x);
        }

        private int binarySearch(int x) {
            int low = 0, high = w.length - 1;
            while (low < high) {
                int mid = (high - low) / 2 + low;
                if (w[mid] < x) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }

    }


}
