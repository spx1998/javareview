package com.algorithms.leetcode.easy;

/**
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * 提示：
 * 你可以假设 nums中的所有元素是不重复的。
 * n将在[1, 10000]之间。
 * nums的每个元素都将在[-9999, 9999]之间。
 */
public class Solution704 {
    public int search(int[] nums, int target) {
        int head = 0;
        int tail = nums.length - 1;
        while (head <= tail) {
            int temp = head + (tail - head) / 2;
            if (nums[temp] == target) {
                return temp;
            } else if (nums[temp] > target) {
                tail = temp - 1;
            } else {
                head = temp + 1;
            }
        }
        return -1;
    }
}
