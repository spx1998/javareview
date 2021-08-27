package com.algorithms.leetcode.hot100;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 */
public class _55JumpGame {
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        int cur = 0;
        while (cur <= maxIndex) {
            if (cur + nums[cur] > maxIndex) {
                maxIndex = cur + nums[cur];
            }
            if (maxIndex >= nums.length - 1) {
                return true;
            }
            cur++;
        }
        return false;
    }
}
