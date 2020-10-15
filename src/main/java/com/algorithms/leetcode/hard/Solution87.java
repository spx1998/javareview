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
 * <p>
 * 解法：
 * 对于两个字符串判断其是否是扰乱字符串，要分别判断他们的两个子串是否相等或者是扰乱子串，两个子串可以是在任意位置划分得到的。
 * 可以将问题分解为子问题的解的和，因此有递归和DP两种解法。
 * 1）递归
 * 将两个字符串划分为S1 S2 和T1 T2两个，然后分别比较S1与T1，S2和T2或S1和T2，S2和T1是否相等或为扰乱字符串。
 * 2）用一个三维的DP数组dp[i][j][k]
 * i ,j,k分别是a串的起始位置，b串的起始位置和匹配长度。如dp[0][0][2]=true表示b的前两个字符组成的子串是b前两个字符组成的子串的扰乱字符串。
 * dp[i][j][k] =(dp[i][j][w]&&dp[i+w][j+w][k-w])||(dp[i][j+k-w][w]&&dp[i+w][j][k-w]),其中1≤w≤k-1.
 * 最终dp[0][0][n]即结果。
 */
public class Solution87 {
    public static void main(String[] args) {
        System.out.println(new Solution87().isScramble("cxaba", "cxaab"));
//        System.out.println(new Solution87().isScramble("abcdbdacbdac", "bdacabcdbdac"));

    }

    /**
     * 递归
     */
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

    /**
     * dp解法
     */
    public boolean dpSolution(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int length = s1.length();
        if (s1.length() != s2.length()) {
            return false;
        }
        boolean[][][] dp = new boolean[length][length][length + 1];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                dp[i][j][1] = chars1[i] == chars2[j];
            }
        }
//        len是划分的区间的长度
        for (int len = 2; len <= length; len++) {
            for (int i = 0; i <= length - len; i++) {
                for (int j = 0; j <= length - len; j++) {
                    for (int k = 1; k < len; k++) {
                        if (dp[i][j][k] && dp[i + k][j + k][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                        if (dp[i][j + len - k][k] && dp[i + k][j][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][length];
    }
}
