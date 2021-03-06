package com.algorithms.classical;

import java.util.Arrays;

/**
 * 字符串匹配的Kmp算法 TODO BM算法 hash算法？ LSM算法
 */
public class Kmp {
    /**
     * 朴素的字符串匹配算法
     */
    public boolean simpleMatch(String text, String pattern) {
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            boolean match = true;
            for (int j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }

    /**
     * Kmp算法
     * 字符串匹配：在文本串中找模式串
     * 确定有限状态自动机
     * 对于要匹配的模式串建立一个前缀数组next，每个元素表示到当前元素为止的子串的最长相等前后缀的长度。
     * aabaaac的前缀数组：
     * 0101220
     * 特别的第一个元素设置为0.
     */

    public boolean kmpMatch(String text, String pattern) {
        int[] next = getNext(pattern);
        //j是当前正在进行匹配的pattern串的下标。
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
                if (j == pattern.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Arrays.stream(new Kmp().getNext("abcabaabc")).forEach(System.out::println);
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


