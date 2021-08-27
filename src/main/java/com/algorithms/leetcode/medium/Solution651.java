package com.algorithms.leetcode.medium;

/**
 * 四字键盘 DP
 * 特殊键盘，只能输出 A ctrl+a ctrl+c ctrl+v 问按N次键盘最多输出多少个A？
 * 解法：DP
 * 对于按n次键盘能取到的最大值，要么全按A，要么按A再ca cc cv cv cv... ，对于N 一定是从某个n转移而来。
 */
public class Solution651 {
    public int ds(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            int j = 3;
            while (i - j >= 0) {
                dp[i] = Math.max(dp[i], dp[i - j] * (j - 1));
                j++;
            }
        }
        return dp[n];
    }
}
