package com.algorithms.leetcode.hard;

/**
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组nums中。
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。
 * 这里的 i - 1 和 i + 1 代表和i相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 * 求所能获得硬币的最大数量。
 * n == nums.length
 * 1 <= n <= 500
 * 0 <= nums[i] <= 100
 *
 * 区间DP问题
 * TODO 题解
 */
public class Solution312 {
    public static void main(String[] args) {
        System.out.println(new Solution312().maxCoins(new int[]{3, 1, 5, 8}));
    }

    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int l = 0; l < nums.length; l++) {
            for (int i = 0; i < nums.length; i++) {
                int j = i + l;
                if (j < dp.length) {
                    for (int k = i; k <= j; k++) {
                        int left = k > i ? dp[i][k - 1] : 0;
                        int right = k < j ? dp[k + 1][j] : 0;
                        int a = i == 0 ? 1 : nums[i - 1];
                        int b = j == nums.length - 1 ? 1 : nums[j + 1];
                        int mid = nums[k] * a * b;
                        dp[i][j] = Math.max(dp[i][j], left + right + mid);
                    }
                }
            }
        }
        return dp[0][dp.length - 1];
    }
}
