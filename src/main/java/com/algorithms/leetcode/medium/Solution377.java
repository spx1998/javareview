package com.algorithms.leetcode.medium;

/**
 * 给你一个由 不同 《正整数》（存在负数则无解）组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 题目数据保证答案符合 32 位整数范围。
 * 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？ TODO
 * 解法：DP DFS会超时
 */
public class Solution377 {
    public static void main(String[] args) {
        System.out.println(new Solution377().combinationSum4(new int[]{1, 2, 3}, 4));
    }


    public int combinationSum4(int[] nums, int target) {
        int[] DP = new int[target + 1];
        DP[0] = 1;
        for (int i = 1; i < DP.length; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    DP[i] += DP[i - num];
                }
            }
        }
        return DP[target];
    }

}
