package com.algorithms.leetcode.medium;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 我的解法：观察知道，字典中的下一序列，应该是数组从右向左，第一个非递增的值的位置a，与在它右侧最后一个比它大的值的位置b互换，然后将a位置以右排序。
 * 如：
 *    2 6 5 4 3 1 的下一个排序应该是2 3互换位置
 * -> 3 6 5 4 2 1 再将3以右的位置排序
 * -> 3 1 2 4 5 6
 *
 */
public class Solution31 {
    public static void main(String[] args) {
        new Solution31().nextPermutation(new int[]{1,5,1});
    }
    public void nextPermutation(int[] nums) {
        boolean sign = false;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                for (int j = i; j < nums.length; j++) {
                    if (j == nums.length - 1 || nums[j + 1] <= nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        break;
                    }
                }
                Arrays.sort(nums, i, nums.length);
                sign = true;
                break;
            }
        }

        if (!sign) {
            for (int i = 0; i < nums.length / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[nums.length - i - 1];
                nums[nums.length - i - 1] = temp;
            }
        }
    }
}
