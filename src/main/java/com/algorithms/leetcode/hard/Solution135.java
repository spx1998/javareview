package com.algorithms.leetcode.hard;

import java.util.Arrays;

/**
 * 老师想给孩子们分发糖果，有 N个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * 示例1:
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例2:
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 * TODO 题解
 * 我的解法：
 * 一次遍历，若ratings[i]>ratings[i-1]，则给第i个孩子的糖果为i-1个孩子的数量+1；
 * 否则，给第i个孩子1个糖果，向前遍历，若从后向前递增，则给第i-j个孩子i-j+1个孩子的糖果数+1颗糖果。
 * 优化解法：
 * 不需要向前遍历，可以改为遍历两边，一遍从前往后，一遍从后往前。
 *
 * 一次遍历，不需要格外空间的解法：
 *
 */
public class Solution135 {
    public static void main(String[] args) {
        System.out.println(new Solution135().candy(new int[]{1, 2, 2}));
        System.out.println(new Solution135().candy2(new int[]{1, 3, 4, 5, 2}));

    }

    public int candy(int[] ratings) {
        int[] cost = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                cost[i] = cost[i - 1] + 1;
            } else {
                cost[i] = 1;
                int j = 1;
                while (i - j >= 0) {
                    if (ratings[i - j] > ratings[i - j + 1] && cost[i - j] == cost[i - j + 1]) {
                        cost[i - j] = cost[i - j + 1] + 1;
                    }
                    j++;
                }
            }
        }
        return Arrays.stream(cost).sum();
    }

    /**
     * 两次遍历 O(2*n)
     */
    public int candy2(int[] ratings) {
        int[] cost = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                cost[i] = cost[i - 1] + 1;
            } else if (cost[i] == 0) {
                cost[i] = 1;
            }
        }
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
                cost[i] = Math.max(cost[i + 1] + 1, cost[i]);
            } else if (cost[i] == 0) {
                cost[i] = 1;
            }
        }
        return Arrays.stream(cost).sum();
    }
}