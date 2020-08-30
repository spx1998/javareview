package com.algorithms.leetcode.medium;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * 解法：
 * 维持一个当前能到达的下标最大元素max，初始化为0。遍历数组，如果max≥i,则说明当前元素可达，i+num[i]即从当前元素出发可达的下标最大的元素，
 * max设为该下标与当前max中的最大值；若max<i,说明当前元素已不可达，返回false。max≥nums.length-1说明已经可达最后一个元素，返回true。
 */
public class Solution55 {
    public static void main(String[] args) {
        System.out.println(new Solution55().canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
                if (max >= nums.length - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
