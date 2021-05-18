package com.algorithms.leetcode.medium;

/**
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 * 解法：二维DP
 * 相关问题：
 * {@link Solution5}
 * {@link Solution1143}
 */
public class Solution516 {
    public static void main(String[] args) {
        System.out.println(new Solution516().longestPalindromeSubseq("bbbab"));
    }

    /**
     * 我的解法：类似第5题，用l表示子序列长度，
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubseq0(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int l = 0; l < s.length(); l++) {
            for (int i = 1; i <= s.length(); i++) {
                int j = i + l;
                if (j > s.length()) {
                    continue;
                }
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    int temp = l > 1 ? dp[i + 1][j - 1] : 0;
                    if (s.charAt(i - 1) == s.charAt(j - 1)) {
                        temp += 2;
                    }
                    dp[i][j] = Math.max(temp, Math.max(dp[i + 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[1][s.length()];
    }

    /**
     * 类似1143题的解法，更一般的子序列问题的思路
     */
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = s.length(); i >= 1; i--) {
            for (int j = i; j <= s.length(); j++) {
                if (i == j) {
                    dp[j][j] = 1;
                } else {
                    if (s.charAt(i - 1) == s.charAt(j - 1)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[1][s.length()];
    }
}
