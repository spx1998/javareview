package com.algorithms.leetcode.hard;

/**
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE"是"ABCDE"的一个子序列，而"AEC"不是）
 * 题目数据保证答案符合 32 位带符号整数范围。
 * 示例1：
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * * rabbbit
 * * ^^^^ ^^
 * * rabbbit
 * * ^^ ^^^^
 * * rabbbit
 * * ^^^ ^^^
 * 示例2：
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * * babgbag
 * * ^^ ^
 * * babgbag
 * * ^^    ^
 * * babgbag
 * * ^    ^^
 * * babgbag
 * *   ^  ^^
 * * babgbag
 * *     ^^^
 * 提示：
 * 0 <= s.length, t.length <= 1000
 * s 和 t 由英文字母组成
 * <p>
 * 我的解法：
 * dp 初始化二维dp数组，dp[i][0]为1，因为无论s长度为多少，t为空串时，s的子序列中必包含一个t。
 * 对于dp[i][j],
 * 当s.charAt(i-1)!=t.charAt(j-1)，则s的前i-1个字符的子串中，包含t的前j-1个字符的子序列数目与s的前i-2个字符的子串相同，即dp[i][j]=dp[i-1][j].
 * 当s.charAt(i-1)==t.charAt(j-1),则s的前i-1个字符的子串中包含t的前j-1个字符的子序列，既包括s的前i-2个字符的子串中包含的t的前j-1个字符的子串的子序列，
 * 又包括s的前i-2个字符的子串中包含的t的前j-2个字符的子串的子序列，即dp[i][j] = dp[i-1][j]+dp[i-1][j-1].
 */
public class Solution115 {
    public int numDistinct(String s, String t) {
        int sL = s.length();
        int tL = t.length();
        int[][] dp = new int[sL + 1][tL + 1];
        for (int i = 0; i <= sL; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= sL; i++) {
            for (int j = 1; j <= tL; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[sL][tL];
    }
}
