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
 */
public class Solution135 {
    public static void main(String[] args) {
        System.out.println(new Solution135().candy(new int[]{1, 2, 2}));
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
}
