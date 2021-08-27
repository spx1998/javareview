package com.algorithms.leetcode.hard;

/**
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 * 思路： 可以将题意转化为求s从左边界开始的最长的回文子串，将剩余的部分reverse，放到s前即所得。
 * 那么问题的关键就变成了如何判断一个字符串是不是回文串:
 *
 * TODO
 * 相关问题：
 * {@link com.algorithms.leetcode.medium.Solution5}
 * {@link com.algorithms.leetcode.medium.Solution131}
 * {@link com.algorithms.leetcode.medium.Solution131}
 * 647
 */
public class Solution214 {
    public String shortestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        for (int i = s.length(); i > 0; i--) {
            if (isPalindrome(s.substring(0, i))) {
                String substring = s.substring(i);
                return new StringBuilder(substring).reverse().toString() + s;
            }
        }
        return s;
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
