package com.algorithms.leetcode.medium;

/**
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * 示例 1:
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 */
public class Solution518 {
    public static void main(String[] args) {
        new Solution518().change(5, new int[]{1, 2, 5});
    }

    /**
     * 我的解法：二维dp 时间复杂度和空间复杂度都过高
     */
    public int change0(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        for (int i = 0; i < coins.length + 1; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j <= coins.length; j++) {
                int k = 0;
                while (i - k * coins[j - 1] >= 0) {
                    dp[i][j] += dp[i - k * coins[j - 1]][j - 1];
                    k++;
                }
            }
        }
        return dp[amount][coins.length];
    }

    /**
     * 优化解法：一维dp
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
//        初始化 一种可能：选择0枚硬币
        dp[0] = 1;
        for (int v : coins) {
            for (int i = v; i < amount + 1; i++) {
                dp[v] += dp[i - v];
            }
        }
        return dp[amount];
    }

}
