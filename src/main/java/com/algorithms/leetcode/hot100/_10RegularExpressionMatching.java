package com.algorithms.leetcode.hot100;

/**
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 */
public class _10RegularExpressionMatching {
    public static void main(String[] args) {
        boolean match = new _10RegularExpressionMatching().isMatch("a", "c*a");
        System.out.println(match);
    }

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (i != 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
//                    dp[i][j - 2]、dp[i][j - 1]、 dp[i - 1][j] 分别对应*使用0次，使用1次和使用多次，其中后面两次又可以合并。所以中间这个是可以直接去掉的。
                    dp[i][j] = dp[i][j - 2];
                    if (i != 0 && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.')) {
                        dp[i][j] |= dp[i][j - 1] | dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
