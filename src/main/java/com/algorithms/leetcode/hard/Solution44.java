package com.algorithms.leetcode.hard;

/**
 * 给定一个字符串(s) 和一个字符模式(p) ，实现一个支持'?'和'*'的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * 说明:
 * s可能为空，且只包含从a-z的小写字母。
 * p可能为空，且只包含从a-z的小写字母，以及字符?和*。
 * <p>
 * DP解法：
 * 构造一个 (s.length+1) * (p.length+1) 大小的二维boolean数组dp[s.length+1][p.length+1]，其中的每个元素dp[i][j]，
 * 表示s中前i个元素与p中的前j个元素是否能匹配成功。i=0或j=0可以理解为s或p的子串为""。
 * 然后初始化数组。dp[0][0]显然是true；如果p是以'*'开头的字符串，则dp[0][1]是true（s的子串是""，p的子串是"*"可以匹配空字符串）。
 * 以此类推，当p以多个'*'开头的情况与之类似，若p的[1,j]的子串都是'*"，则dp[0][1->j]都是true。
 * 此外，显然，dp[i][0]一定是false。
 * 初始化结束后，开始对二位数组进行遍历（从下标1开始，因为i=0或j=0的情况已经讨论过了）。对应任意i，j：
 * 如果 s中的第i个字符与p中的第j个字符相等，或p中的第j个字符是'？'，则匹配成功，dp[i][j]的取值取决于dp[i-1][j-1]是否是true。
 * 如果 p的第j个字符是'*'，则要区分 * 匹配当前字符和不匹配当前字符两种情况。如果'*"将s的第i个字符匹配掉，则dp[i][j]取决于dp[i-1][j]，
 * 即s的前i-1个字符能否与p的前j个字符匹配；若'*'不与s的第i个字符匹配，那么dp[i][j] = dp[i][j-1]。最后dp数组中的最后一个元素即最终结果。
 * <p>
 * 相关问题：
 * leetcode 第10题 {@link Solution10}
 */
public class Solution44 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
