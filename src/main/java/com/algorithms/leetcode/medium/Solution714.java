package com.algorithms.leetcode.medium;

/**
 * 给定一个整数数组prices，其中第i个元素代表了第i天的股票价格 ；非负整数fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * 示例 1:
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润:((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 注意:
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 * <p>
 * 相关问题：
 * leetcode 第121题 {@link com.algorithms.leetcode.easy.Solution121}
 * leetcode 第122题 {@link com.algorithms.leetcode.easy.Solution122}
 * leetcode 第123题 {@link com.algorithms.leetcode.hard.Solution123}
 * leetcode 第188题 {@link com.algorithms.leetcode.hard.Solution188}
 * leetcode 第309题 {@link com.algorithms.leetcode.medium.Solution309}
 */
public class Solution714 {

    /**
     * dp
     */
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length + 1][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
        }
        return dp[prices.length][0];
    }
}
