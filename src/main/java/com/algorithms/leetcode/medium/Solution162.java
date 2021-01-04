package com.algorithms.leetcode.medium;

/**
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给定一个输入数组nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * 你可以假设nums[-1] = nums[n] = -∞。
 * 示例 1:
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 示例2:
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 * 或者返回索引 5， 其峰值元素为 6。
 * 说明:
 * 你的解法应该是O(logN)时间复杂度的。
 * 解法： 二分查找
 * 如果区间的左侧nums[l]大于nums[l-1]，右侧nums[r]大于nums[r+1]，那么区间[l,r]中就一定有至少一个峰。
 * 因此如二分查找的做法，如果nums[temp]>nums[temp+1]，则temp为右边界，否则，temp+1为左边界。最终l=r时，得到的一定是一个峰的下标。
 */
public class Solution162 {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
