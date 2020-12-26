package com.algorithms.leetcode.medium;

/**
 * 给你一个整数数组 nums，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释:子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释:结果不能为 2, 因为 [-2,-1] 不是子数组。
 * 我的解法：
 * DP 二维dp数组，第二个纬度为0记录包含当前数组元素的最大正值，为1记录包含当前数组元素的最小负值。结果为遍历过程中所有do[i][0]的最大值.
 */
public class Solution152 {
    public static void main(String[] args) {
        int i = new Solution152().maxProduct(new int[]{2, 3, -2, 4});
        System.out.println(i);
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length][2];
        int max = nums[0];
        dp[0][0] = Math.max(nums[0], 0);
        dp[0][1] = Math.min(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                dp[i][0] = dp[i][1] = 0;
            } else if (nums[i] > 0) {
                dp[i][0] = dp[i - 1][0] == 0 ? nums[i] : nums[i] * dp[i - 1][0];
                dp[i][1] = dp[i - 1][1] * nums[i];

            } else {
                dp[i][0] = dp[i - 1][1] * nums[i];
                dp[i][1] = dp[i - 1][0] == 0 ? nums[i] : nums[i] * dp[i - 1][0];
            }
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }
}
