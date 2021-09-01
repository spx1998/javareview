package com.algorithms.leetcode.easy;

/**
 * 给你一个正整数数组arr，请你计算所有可能的奇数长度子数组的和。
 * 子数组 定义为原数组中的一个连续子序列。
 * 请你返回 arrR中 所有奇数长度子数组的和 。
 */
public class Solution1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        for (int i = 1; i <= arr.length; i += 2) {
            for (int j = 0; j <= arr.length - i; j++) {
                for (int k = 0; k < i; k++) {
                    res += arr[j + k];
                }
            }
        }
        return res;
    }
}
