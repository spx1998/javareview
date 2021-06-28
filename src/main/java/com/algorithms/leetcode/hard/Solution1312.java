package com.algorithms.leetcode.hard;

/**
 * 给你一个字符串s，每一次操作你都可以在字符串的任意位置插入任意字符。
 * 请你返回让s成为回文串的最少操作次数。
 * 「回文串」是正读和反读都相同的字符串。
 * 示例 1：
 * 输入：s = "zzazz"
 * 输出：0
 * 解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
 * 示例 2：
 * 输入：s = "mbadm"
 * 输出：2
 * 解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
 * 示例 3：
 * 输入：s = "leetcode"
 * 输出：5
 * 解释：插入 5 个字符后字符串变为 "leetcodocteel" 。
 * 示例 4：
 * 输入：s = "g"
 * 输出：0
 * 示例 5：
 * 输入：s = "no"
 * 输出：1
 *
 * 我的解法：
 * 区间dp，类似所有的子序列和子串问题。
 */
public class Solution1312 {
    public int minInsertions(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int l = 1; l < s.length(); l++) {
            for (int i = 0; i + l < s.length(); i++) {
                int j = i + l;
//                这里正常来讲应该区分i+1=j和i+1<j两种情况，但是dp[i+1][j-1]在i+1=j的情况也是0，所以合并成了一行。完全是取巧的做法。
                dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i + 1][j - 1] : dp[i + 1][j - 1] + 2;
                dp[i][j] = Math.min(dp[i][j], Math.min(dp[i][j - 1] + 1, dp[i + 1][j] + 1));
            }
        }
        return dp[0][s.length() - 1];
    }
}
