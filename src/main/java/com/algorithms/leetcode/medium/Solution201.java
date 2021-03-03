package com.algorithms.leetcode.medium;

/**
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * 示例 1:
 * 输入: [5,7]
 * 输出: 4
 * 示例 2:
 * 输入: [0,1]
 * 输出: 0
 *
 * 解法：转换为求m和n的最长公共前缀
 */
public class Solution201 {
    public static void main(String[] args) {
        System.out.println(new Solution201().rangeBitwiseAnd(5, 7));
    }

    //    转换为求最长公共前缀
    public int rangeBitwiseAnd(int m, int n) {
        int i = 31;
        for (; i >= 0; i--) {
            if (((m >>> i) & 1) != ((n >>> i) & 1)) {
                break;
            }
        }
        return m >>> i + 1 << i + 1;
    }
}
