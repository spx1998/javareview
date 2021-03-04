package com.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串s和t，判断它们是否是同构的。
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * 示例 1:
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 * 输入：s = "paper", t = "title"
 * 输出：true
 * 提示：
 * 可以假设s和 t 长度相同。
 *
 * 解法：两个hash表。
 */
public class Solution205 {
    public static void main(String[] args) {
        System.out.println(new Solution205().isIsomorphic("badc", "baba"));
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> opMap = new HashMap<>();
        char[] sC = s.toCharArray();
        char[] tC = t.toCharArray();
        for (int i = 0; i < sC.length; i++) {
            if (!map.containsKey(sC[i])) {
                map.put(sC[i], tC[i]);
                opMap.putIfAbsent(tC[i], sC[i]);
            }
            if (map.get(sC[i]) != tC[i] || opMap.get(map.get(sC[i])) != sC[i]) {
                return false;
            }
        }
        return true;
    }
}
