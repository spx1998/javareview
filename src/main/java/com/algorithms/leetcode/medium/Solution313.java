package com.algorithms.leetcode.medium;

import java.util.Arrays;

/**
 * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 */
public class Solution313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int[] ptr = new int[primes.length];
        Arrays.fill(ptr, 1);
        for (int i = 2; i <= n; i++) {
            int[] nums = new int[primes.length];
            int minNum = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                nums[j] = dp[ptr[j]] * primes[j];
                minNum = Math.min(minNum, nums[j]);
            }
            dp[i] = minNum;
            for (int j = 0; j < primes.length; j++) {
                if (minNum == nums[j]) {
                    ptr[j]++;
                }
            }
        }
        return dp[n];
    }
}
