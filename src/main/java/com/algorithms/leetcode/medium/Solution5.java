package com.algorithms.leetcode.medium;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 我的解法：
 * 类似中心扩展，遍历字符串 ，以每个字符为回文的中心，向左右扩展，找到最长的回文子串。
 * <p>
 * dp解法：
 * 二维DP数组，第一个维度为子串的初始字符，第二个维度为子串的结束字符。dp[i][j]是回文的必要条件是dp[i+1][j-1]是回文。
 * 值得注意的是，一般的DP往往是由某一个维度中的前一个状态转向后一个，但这里是由后一个转向前一个。
 *
 * 马拉车解法(manacher) ：{@link com.algorithms.classical.Manacher}
 */
public class Solution5 {
    public static void main(String[] args) {
        System.out.println(new Solution5().longestPalindrome("wwww"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int max = 1;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = 1;
            while (i - j >= 0 && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j)) {
                if (2 * j + 1 > max) {
                    max = Math.max(2 * j + 1, max);
                    index = i - j;
                }
                j++;
            }
            j = 1;
            while (i - j + 1 >= 0 && i + j < s.length() && s.charAt(i - j + 1) == s.charAt(i + j)) {
                if (2 * j > max) {
                    max = Math.max(2 * j, max);
                    index = i - j + 1;
                }
                j++;
            }
        }
        return s.substring(index, index + max);
    }

    /**
     * dp解法
     */
    public String dp(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        String sub = "";
        for (int l = 0; l < length; l++) {
            for (int i = 0; i < length - l; i++) {
                int j = i + l;
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (l == 1) {
                        dp[i][j] = b;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] && b;
                    }
                }
                if (dp[i][j] && l + 1 > sub.length()) {
                    sub = s.substring(i, i + l + 1);
                }
            }
        }
        return sub;
    }
}
