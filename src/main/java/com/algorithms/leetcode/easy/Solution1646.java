package com.algorithms.leetcode.easy;

/**
 * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
 * <p>
 * nums[0] = 0
 * nums[1] = 1
 * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 * 返回生成数组 nums 中的 最大 值。
 * 解法：
 * 模拟
 */
public class Solution1646 {
    public int getMaximumGenerated(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] num = new int[n + 1];
        num[1] = 1;
        int max = 1;
        for (int i = 2; i < n + 1; i++) {
            if (i % 2 == 0) {
                num[i] = num[i / 2];
            } else {
                num[i] = num[i / 2] + num[i / 2 + 1];
            }
            max = Math.max(max, num[i]);
        }
        return max;
    }
}
