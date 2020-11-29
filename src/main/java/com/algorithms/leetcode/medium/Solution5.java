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
 * TODO 解法
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

}
