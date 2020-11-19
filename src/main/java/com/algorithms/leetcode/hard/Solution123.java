package com.algorithms.leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
 * 注意:你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 示例1:
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 * 我的解法：
 * 区间拆分为两个区间，总区间最大利润即两个区间最大利润之和。超时
 * <p>
 * 相关问题：
 * leetcode 第121题 {@link com.algorithms.leetcode.easy.Solution121}
 * leetcode 第122题 {@link com.algorithms.leetcode.easy.Solution122}
 * leetcode 第188题 {@link com.algorithms.leetcode.hard.Solution188}
 * leetcode 第309题 {@link com.algorithms.leetcode.medium.Solution309}
 * leetcode 第714题 {@link com.algorithms.leetcode.medium.Solution714}
 */
public class Solution123 {
    public static void main(String[] args) {
        int[] ints1 = {3, 2, 6, 5, 0, 3};
        int[] ints = {3, 2, 6, 5, 0, 3};
        System.out.println(new Solution123().dp(ints));
    }

    /**
     * dp
     */
    public int dp(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int l = prices.length;
//        定义5种状态：不持有股票：卖出0次，卖出1次，卖出2次；持有股票：卖出0次，卖出1次（已卖出2次则不可能再持有股票）分别为[0,1,2,3,4]。
        int[][] dp = new int[prices.length][5];
        dp[0][3] = -prices[0];
        dp[0][4] = -prices[0];
        for (int i = 1; i < l; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][3] + prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][4] + prices[i], dp[i - 1][2]);
            dp[i][3] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][3]);
            dp[i][4] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][4]);
        }
        return Math.max(dp[l - 1][0], Math.max(dp[l - 1][1], dp[l - 1][2]));
    }
}
