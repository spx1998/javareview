package com.algorithms.leetcode.hot100;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class _52MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int temp = 0;
        for (int num : nums) {
            if (temp < 0) {
                temp = num;
            } else {
                temp += num;
            }
            max = Math.max(temp, max);
        }
        return max;
    }
}
