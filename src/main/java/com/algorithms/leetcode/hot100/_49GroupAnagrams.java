package com.algorithms.leetcode.hot100;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词指字母相同，但排列不同的字符串。
 */
public class _49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            String standardStr = standardize(str);
            if (!map.containsKey(standardStr)) {
                map.put(standardStr, new ArrayList<>());
            }
            map.get(standardStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String standardize(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
