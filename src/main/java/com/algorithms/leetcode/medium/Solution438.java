package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串s和一个非空字符串p，找到s中所有是p的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串s和 p的长度都不超过 20100。
 * 说明：
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 */
public class Solution438 {
    public static void main(String[] args) {
        new Solution438().findAnagrams("abacbabc",
                "abc");
    }

    public List<Integer> findAnagrams(String s, String p) {
        int head = 0, tail = 0;
        ArrayList<Integer> result = new ArrayList<>();
        Map<Character, Integer> map1 = new HashMap<>();
        for (char c : p.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> map2 = new HashMap<>();
        while (tail < s.length()) {
            char c = s.charAt(tail);
            if (!map1.containsKey(c)) {
                head = tail + 1;
                map2.clear();
            } else {
                if (map1.get(c).equals(map2.get(c))) {
                    while (s.charAt(head) != c) {
                        map2.put(s.charAt(head), map2.get(s.charAt(head)) - 1);
                        head++;

                    }
                    head++;
                    if (check(map1, map2)) {
                        result.add(head);
                    }
                } else {
                    map2.put(c, map2.getOrDefault(c, 0) + 1);
                    if (check(map1, map2)) {
                        result.add(head);
                    }
                }
            }
            tail++;

        }
        return result;
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
