package com.algorithms.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int pre = 0;
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (characters.contains(s.charAt(i))) {
                result = Math.max(result, i - pre);
                while (s.charAt(pre) != s.charAt((i))) {
                    characters.remove(s.charAt(pre));
                    pre++;
                }
                characters.remove(s.charAt(pre));
                pre++;
            }
            characters.add(s.charAt(i));
        }
        return Math.max(result, s.length() - pre);
    }

}
