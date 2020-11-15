package com.algorithms.leetcode.medium;

/**
 * 给定一个整数数组，其中第i个元素代表了第i天的股票价格 。
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class Solution309 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][3];
        dp[0][1] = -prices[0];
//        0->持有一只股票，1->不持有且不在冻结期，2->不持有且在冻结期
        for (int i = 1; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][2] = dp[i - 1][0] + prices[i - 1];
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }
}
