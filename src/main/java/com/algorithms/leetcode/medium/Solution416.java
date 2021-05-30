package com.algorithms.leetcode.medium;

/**
 * 给你一个 只包含正整数 的 非空 数组nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 示例 1：
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 */
public class Solution416 {
    public static void main(String[] args) {
        System.out.println(new Solution416().canPartition(new int[]{1, 2, 5}));
    }

    /**
     * 解法1：为了验证背包问题的恰好装满的变型的初始化问题，效率低
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum = sum / 2;
        boolean[][] dp = new boolean[sum + 1][nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= nums.length; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i >= nums[j - 1]) {
                    dp[i][j] |= dp[i - nums[j - 1]][j - 1];
                }
            }
        }


        return dp[sum][nums.length];
    }
}
