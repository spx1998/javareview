package com.algorithms.leetcode.hard;

/**
 * 有台奇怪的打印机有以下两个特殊要求：
 * 打印机每次只能打印由 同一个字符 组成的序列。
 * 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 * 给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。
 * <p>
 * 我的解法：
 * 区间dp
 */
public class Solution664 {
    public int strangePrinter(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int l = 0; l < s.length(); l++) {
            int j;
            for (int i = 0; (j = i + l) < s.length(); i++) {
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }
//                s.charAt(i)单独打印，或者跟s.charAt(j)一起打印，或者跟i+1->j-1中的某个相同元素一起打印。
//                如果不能找出一个简单直观的状态转移方程，可以遍历所有可能的结果
                dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i + 1][j] : dp[i + 1][j] + 1;
                for (int k = i + 1; k < j; k++) {
                    if (s.charAt(i) == s.charAt(k)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][k] + dp[k + 1][j]);
                    }
                }
            }
        }
        return dp[0][dp.length - 1];
    }
}
