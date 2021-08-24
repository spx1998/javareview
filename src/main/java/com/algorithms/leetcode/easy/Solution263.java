package com.algorithms.leetcode.easy;

/**
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * 丑数 就是只包含质因数2、3 和/或5的正整数。
 * <p>
 * 相关问题：
 * leetcode 263题 {@link Solution263}
 * leetcode 264题 {@link com.algorithms.leetcode.medium.Solution264}
 * leetcode 1201题 {@link com.algorithms.leetcode.medium.Solution1201}
 * leetcode 313题 {@link com.algorithms.leetcode.medium.Solution313}
 */
public class Solution263 {
    public boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 5 == 0) {
            n = n / 5;
        }
        while (n % 2 == 0) {
            n = n / 2;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }

        return n == 1;
    }
}
