package com.algorithms.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
 * 示例：
 * 输入：S = "ADOBECODEBANC", T = "ABC"
 * 输出："BANC"
 * 提示：
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * 解法：
 * 滑动窗口
 */
public class Solution76 {
    public static void main(String[] args) {
        System.out.println(new Solution76().minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int head = 0;
        int tail = s.length() - 1;
        while (check(map, t, s.charAt(head))) {
            head++;
        }
        while (check(map, t, s.charAt(tail))) {
            tail--;
        }
        return s.substring(head, tail + 1);
    }

    private boolean check(Map<Character, Integer> map, String t, char c) {
        if (t.contains(new StringBuilder(c)) && map.get(c) == 1) {
            return false;
        } else {
            map.put(c, map.get(c) - 1);
            return true;
        }
    }


}
