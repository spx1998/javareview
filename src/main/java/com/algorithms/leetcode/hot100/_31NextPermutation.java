package com.algorithms.leetcode.hot100;

/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须 原地 修改，只允许使用额外常数空间。
 */
public class _31NextPermutation {
    public static void main(String[] args) {
        new _31NextPermutation().nextPermutation(new int[]{5, 4, 7, 5, 3, 2});
    }

    public void nextPermutation(int[] nums) {
        boolean hasNext = false;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        break;
                    }
                }
                reverse(nums, i);
                hasNext = true;
                break;
            }
        }
        if (!hasNext) {
            reverse(nums, 0);
        }
    }

    private void reverse(int[] nums, int start) {
        for (int i = start; i <= start + (nums.length - start) / 2 - 1; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - (i - start)];
            nums[nums.length - 1 - (i - start)] = temp;
        }
    }
}
