package com.algorithms.leetcode.easy;

import com.algorithms.classical.Kmp;

/**
 * 实现strStr()函数。
 * 给定一个haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与C语言的strstr()以及 Java的indexOf()定义相符。
 * <p>
 * 我的解法：
 * 暴力解法
 * <p>
 * 应该参考经典的Kmp算法的实现来解决这个问题。{@link com.algorithms.classical.Kmp}
 */
public class Solution28 {

    public int simplestrStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)) {
            return 0;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.startsWith(needle, i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Kmp算法
     */

    public int kmpMatch(String text, String pattern) {
        int[] next = getNext(pattern);
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
                if (j == pattern.length()) {
                    return i - pattern.length() + 1;
                }
            }
        }
        return -1;
    }


    /**
     * @param pattern 模式串
     * @return next数组
     */
    private int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        int j = 0;
        for (int i = 1; i < next.length; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
