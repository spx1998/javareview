package com.algorithms.leetcode.hard;

/**
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 * 说明:
 * s可能为空，且只包含从a-z的小写字母。
 * p可能为空，且只包含从a-z的小写字母，以及字符.和*。
 * <p>
 * dp解法：
 * 构建二维boolean数组
 * <p>
 * TODO 写下题解
 */

/**
 * s a
 * p a*
 * *   0 1 2
 * * 0 t f t
 * * 1 f t t
 * i j
 * p[j] = *
 * if p[j-1] != s[i]
 * dp[i][j] = dp[i][j-2]
 * if p[j-1] == s[i]
 * dp[i][j] = dp[i-1][j]||dp[i][j-2]
 */
public class Solution10 {
    public static void main(String[] args) {
        System.out.println(new Solution10().isMatch("aab", "c*a*b"));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (i > 0 && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1))) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    if (i == 0 || p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
//                        两种情况，s串的第i个字符用*匹配，或不用*匹配
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    }
                }

            }
        }
        return dp[m][n];
    }
}

