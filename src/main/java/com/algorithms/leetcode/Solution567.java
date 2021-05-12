package com.algorithms.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 */
public class Solution567 {
    public static void main(String[] args) {
        boolean b = new Solution567().checkInclusion("hello", "ooolleoooleh");
        System.out.println(b);
    }

    public boolean checkInclusion(String s1, String s2) {
        int head = 0, tail = 0;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        while (tail < s2.length()) {
            char c = s2.charAt(tail);
            if (!map1.containsKey(c)) {
                map2.clear();
                head = tail + 1;
            } else if (map1.get(c).equals(map2.get(c))) {
                while (s2.charAt(head) != c) {
                    if (map2.get(s2.charAt(head)) != null) {
                        map2.put(s2.charAt(head), map2.get(s2.charAt(head)) - 1);
                    }
                    head++;

                }
                head++;
            } else {
                map2.put(c, map2.getOrDefault(c, 0) + 1);
                if (check(map1, map2)) {
                    return true;
                }
            }
            tail++;
        }
        return false;
    }

    private boolean check(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Character c : map1.keySet()) {
            if (!map1.get(c).equals(map2.get(c))) {
                return false;
            }
        }
        return true;
    }


}
