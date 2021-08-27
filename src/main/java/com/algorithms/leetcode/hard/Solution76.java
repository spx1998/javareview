package com.algorithms.leetcode.hard;


import java.util.HashMap;
import java.util.Iterator;
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
 * 滑动窗口,设置两个指针，指向一个s的子串的首尾。当这个字串没有包含t中当全部字符，则移动tail指针，增长子串；若已经包含了所有字符，则后移head指针，
 * 缩短子串的长度，直到子串不再包含t的所有元素。滑动过程中，记录最短的符合条件的子串，遍历结束后，作为结果返回。
 */
public class Solution76 {
    public static void main(String[] args) {
        System.out.println(new Solution76().minWindow("ADOBECODEBANC", "ABC"));
    }



    /**
     * 答案解法
     */
    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> cnt = new HashMap<>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

}
