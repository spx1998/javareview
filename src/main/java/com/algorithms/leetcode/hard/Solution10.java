package com.algorithms.leetcode.hard;

/**
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 * 说明:
 * s可能为空，且只包含从a-z的小写字母。
 * p可能为空，且只包含从a-z的小写字母，以及字符.和*。
 *
 * dp解法：
 * 构建二维boolean数组
 */
public class Solution10 {
    public static void main(String[] args) {
        System.out.println(new Solution10().isMatch("aab", "c*a*b"));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (i > 0 && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1))) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    if (i == 0 || (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.')) {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
/**
 * 1 不匹配字符 dp[i][j-1]
 * 2 匹配当前字符 1 上一字符跟当前字符相同 dp[i-1][j]
 * 2 上一字符跟当前字符不同 dp[i-1][j-1]
 * <p>
 * 1 不匹配字符 dp[i][j-1]
 * 2 上一字符 dp[i-1][j]
 */
