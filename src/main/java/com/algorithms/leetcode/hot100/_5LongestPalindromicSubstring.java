package com.algorithms.leetcode.hot100;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class _5LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int start = 0;
        int length = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int l = 1; l <= s.length(); l++) {
            for (int i = 0; i + l <= s.length(); i++) {
                int j = i + l - 1;
                if (l == 1) {
                    dp[i][j] = true;
                } else if (l == 2) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
                if (l > length && dp[i][j]) {
                    start = i;
                    length = l;
                }
            }
        }
        return s.substring(start, start + length);
    }
}
