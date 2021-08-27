package com.algorithms.leetcode.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class _03LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int length = 1;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            length = Math.max(length, i - left + 1);
        }

        return length;
    }
}
