package com.algorithms.leetcode.hard;

import java.util.HashMap;

/**
 * 给定一个字符串s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
 * <p>
 * 下图是字符串s1="great"的一种可能的表示形式。
 * <p>
 * *      great
 * *     /    \
 * *    gr    eat
 * *   / \    /  \
 * *  g   r  e   at
 * * / \
 * *a   t
 * 在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。
 * 例如，如果我们挑选非叶节点"gr"，交换它的两个子节点，将会产生扰乱字符串"rgeat"。
 * *        rgeat
 * *       /    \
 * *     rg    eat
 * *    / \    /  \
 * *   r   g  e   at
 * *  / \
 * * a   t
 * 我们将"rgeat”称作"great"的一个扰乱字符串。
 * 同样地，如果我们继续交换节点"eat"和"at"的子节点，将会产生另一个新的扰乱字符串"rgtae"。
 * *        rgtae
 * *       /    \
 * *     rg    tae
 * *    / \    /  \
 * *   r   g  ta  e
 * *  / \
 * * t   a
 * 我们将"rgtae”称作"great"的一个扰乱字符串。
 * 给出两个长度相等的字符串 s1 和s2，判断s2是否是s1的扰乱字符串。
 * 示例1:
 * 输入: s1 = "great", s2 = "rgeat"
 * 输出: true
 * 示例2:
 * 输入: s1 = "abcde", s2 = "caebd"
 * 输出: false
 */
public class Solution87 {
    public static void main(String[] args) {
        System.out.println(new Solution87().isScramble("cxaba", "cxaab"));
//        System.out.println(new Solution87().isScramble("abcdbdacbdac", "bdacabcdbdac"));

    }

    public boolean isScramble(String s1, String s2) {
        // 长度不等，必定不能变换
        if (s1.length() != s2.length()) {
            return false;
        }
        // 长度相等，先特判下
        if (s1.equals(s2)) {
            return true;
        }
        // 看一下字符个数是否一致，不同直接return false
        int n = s1.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            map.put(c2, map.getOrDefault(c2, 0) - 1);
        }
        for (Character key : map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }

        // 相同的话，开始判断判断，满足一个就能 return true
        for (int i = 1; i < n; i++) {
            boolean flag =
                    // S1 -> T1，S2 -> T2
                    (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) ||
                            // S1 -> T2，S2 -> T1
                            (isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)));
            if (flag) {
                return true;
            }
        }
        return false;
    }

/*
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int length = s1.length();
        int diff = -1;
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff = i;
                break;
            }
        }
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) == s2.charAt(diff)) {
                if (isScramble(s1.substring(0, i), s2.substring(i, i + i)) && isScramble(s1.substring(i, i + i), s2.substring(0, i)) && isScramble(s1.substring(i + i, length), s2.substring(i + i, length))) {
                    return true;
                }
            }
        }
        return false;
    }
*/
}
