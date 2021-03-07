package com.algorithms.leetcode.hard;

import com.algorithms.leetcode.medium.Solution153;

import java.util.Arrays;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组[0,1,2,4,5,6,7] 可能变为[4,5,6,7,0,1,2])。
 * 请找出其中最小的元素。
 * 注意数组中可能存在重复的元素。
 * 示例 1：
 * 输入: [1,3,5]
 * 输出: 1
 * 示例2：
 * 输入: [2,2,2,0,1]
 * 输出: 0
 * 说明：
 * 这道题是寻找旋转排序数组中的最小值的延伸题目。
 * 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 * <p>
 * 解法1：
 * 去重，转换成第153题。
 * <p>
 * 相关问题：
 * leetcode 第153题 {@link com.algorithms.leetcode.medium.Solution153}
 */

public class Solution154 {
    /**
     * 解法1
     */
    public int findMin0(int[] nums) {
        Integer[] distinctArr = Arrays.stream(nums).distinct().boxed().toArray(Integer[]::new);
        return findMin0(distinctArr);
    }

    public int findMin0(Integer[] nums) {
        int[] ints = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ints[i] = nums[i];
        }
        return new Solution153().findMin(ints);
    }

    /**
     * 解法2 153解法中的前两个判断条件其实是154中的特例，因为不存在相同数，所以可以提前判断；
     * 要注意的是如果出现中值和边界值相等的情况，边界向中间挪一位重新计算，这样保证不会出现偏差。
     */
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int temp = low + (high - low) / 2;
            if (nums[temp] < nums[high]) {
                high = temp;
            } else if (nums[temp] > nums[high]) {
                low = temp + 1;
            } else {
                high--;
            }
        }
        return nums[low];
    }

}
