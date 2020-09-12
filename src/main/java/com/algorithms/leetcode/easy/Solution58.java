package com.algorithms.leetcode.easy;

/**
 * 给定一个仅包含大小写字母和空格' '的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * 如果不存在最后一个单词，请返回 0。
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 * 我的解法：
 * 将s根据空格划分为String数组，返回数组最后一个元素。
 */
public class Solution58 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.trim().length() == 0)
            return 0;
        String[] strings = s.split(" ");
        return strings[strings.length - 1].length();
    }
}
