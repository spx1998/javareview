package com.algorithms.leetcode.easy;

/**
 * 给定一个整数数组nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * TODO： 解法
 */
public class Solution53 {
    public static void main(String[] args) {
        System.out.println(new Solution53().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /**
     * 时间复杂度为n的方法
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            max = Math.max(max, temp);
            if (temp < 0) {
                temp = 0;
            }
        }
        return max;
    }

    /**
     * 分治法
     */
    public int maxSubArray2(int[] nums) {
        return 0;
    }


}
