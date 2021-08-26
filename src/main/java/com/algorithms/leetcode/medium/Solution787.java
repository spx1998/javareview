package com.algorithms.leetcode.medium;


import java.util.Arrays;

/**
 * 有 n 个城市通过一些航班连接。给你一个数组flights ，
 * 其中flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，
 * 你的任务是找到出一条最多经过 k站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
 */
public class Solution787 {
    public static void main(String[] args) {
        int cheapestPrice = new Solution787().findCheapestPrice(3, new int[][]{
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500},
        }, 0, 2, 1);
        System.out.println(cheapestPrice);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] dp = new int[1 + k][n];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][src] = 0;
        for (int[] flight : flights) {
            if (flight[0] == src) {
                dp[0][flight[1]] = flight[2];
            }
        }
        for (int i = 1; i <= k; i++) {
            for (int[] flight : flights) {
                int j = flight[1];
                if (dp[i - 1][flight[0]] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][flight[0]] + flight[2]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            res = Math.min(res, dp[i][dst]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
