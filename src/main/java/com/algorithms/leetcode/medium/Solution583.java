package com.algorithms.leetcode.medium;

/**
 * 给定两个单词word1和word2，找到使得word1和word2相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 * 示例：
 * 输入: "sea", "eat"
 * 输出: 2
 * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 * 提示：
 * 给定单词的长度不超过500。
 * 给定单词中的字符只含有小写字母。
 * 我的解法：
 * 转化为求最长公共子序列的问题。
 *
 * {@link Solution712}
 * {@link Solution1143}
 */
public class Solution583 {
    public static void main(String[] args) {
        System.out.println(new Solution583().minDistance("sea", "eat"));
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return word1.length() + word2.length() - dp[word1.length()][word2.length()] * 2;
    }
}
