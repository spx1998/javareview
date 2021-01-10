package com.algorithms.leetcode.easy;

import java.util.Arrays;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例1：
 * 输入：[3,2,3]
 * 输出：3
 * 示例2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * 进阶：
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * 解法1：
 * hash表 O(n) O(n)
 * 解法2：
 * 排序，中间元素为结果。O(nlogn) O(1)
 * 解法3：
 * 摩尔投票法 O(n) O(n)
 * 初始候选人cand设为nums[0]，count为0。遍历nums，如果nums[i]==cand，count+1；如果nums[i]!=cand，count-1。
 * 若count变为0，则cand设为当前元素，count重置为1。遍历结束，cand即结果。
 *
 * 相关问题：
 * leetcode 第229题{@link com.algorithms.leetcode.medium.Solution229}
 */
public class Solution169 {
    /**
     * 排序法
     */
    public int majorityElement0(int[] nums) {
        Arrays.sort(nums);
        return nums[(nums.length - 1) / 2];
    }

    /**
     * 摩尔投票法
     */
    public int majorityElement(int[] nums) {
        int cand = nums[0];
        int count = 0;
        for (int num : nums) {
            if (num == cand) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    cand = num;
                    count = 1;
                }
            }
        }
        return cand;
    }
}
