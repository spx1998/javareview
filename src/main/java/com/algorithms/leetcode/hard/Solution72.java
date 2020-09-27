package com.algorithms.leetcode.hard;

/**
 * 给你两个单词word1 和word2，请你计算出将word1转换成word2 所使用的最少操作数。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例1：
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例2：
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * 我的解法：
 * dp，word1的第i个字符跟word2的第j个字符匹配时的时候的最小操作数，一定来自于dp[i-1][j] dp[i][j-1] dp[i-1][j-1]三个数中的最小值加一。
 * 但是，这样无法处理zoolo zoo word1第3个o与word2第二个o匹配的情况。
 * 正确的解法：
 * 应该是dp[i-1][j]+1 dp[i][j-1]+1 和dp[i-1][j-1]/dp[i-1][j-1]+1 三者中的最小值。因为word1或word2中一个的字串多一个字符，那么最短操作数一定会加一。
 * 这样可以处理上面处理不了的情况。
 */
public class Solution72 {
    public static void main(String[] args) {
        System.out.println(new Solution72().minDistance("zoolo",
                "zoo"));
    }

    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        int[][] dp = new int[l1 + 1][l2 + 1];

        dp[0][0] = 0;
        for (int i = 1; i < l1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < l2 + 1; i++) {
            dp[0][i] = i;
        }
        int i = 1;
        for (; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                int num = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    num++;
                }
                dp[i][j] = Math.min(num, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
            }
        }
        return dp[l1][l2];
    }
}
