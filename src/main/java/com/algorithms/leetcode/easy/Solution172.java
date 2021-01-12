package com.algorithms.leetcode.easy;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * 示例 1:
 * 输入: 3
 * 输出: 0
 * 解释:3! = 6, 尾数中没有零。
 * 示例2:
 * 输入: 5
 * 输出: 1
 * 解释:5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为O(logn)。
 * 我的解法：
 * 计算n中5的个数，每个5对应一个0；然后计算n中5^2的个数，每个5^2多一个0；然后5^3，以此类推。
 */
public class Solution172 {
    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            System.out.println(new Solution172().trailingZeroes(i));
        }
    }

    public int trailingZeroes(int n) {
        int res = 0;
        int i = 5;
        while (n / i != 0) {
            res += (n / i);
            i *= 5;
        }
        return res;
    }
}
