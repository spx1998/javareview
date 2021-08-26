package com.algorithms.leetcode.hard;

import java.util.Arrays;

/**
 * 一个国家有 n个城市，城市编号为0到n - 1，题目保证 所有城市都由双向道路 连接在一起。
 * 道路由二维整数数组edges表示，其中edges[i] = [xi, yi, timei]表示城市xi 和yi之间有一条双向道路，
 * 耗费时间为timei分钟。两个城市之间可能会有多条耗费时间不同的道路，但是不会有道路两头连接着同一座城市。
 * 每次经过一个城市时，你需要付通行费。通行费用一个长度为 n且下标从 0开始的整数数组passingFees表示，其中passingFees[j]是你经过城市 j需要支付的费用。
 * 一开始，你在城市0，你想要在 maxTime分钟以内（包含 maxTime分钟）到达城市n - 1。
 * 旅行的 费用 为你经过的所有城市 通行费之和（包括起点和终点城市的通行费）。
 * 给你maxTime，edges和passingFees，请你返回完成旅行的最小费用，如果无法在maxTime分钟以内完成旅行，请你返回-1。
 *
 *
 */
public class Solution1928 {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int[][] dp = new int[maxTime + 1][passingFees.length];
        for (int i = 0; i < maxTime + 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
//          TODO

        return maxTime;
    }
}
