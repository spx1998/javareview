package com.algorithms.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 进阶：你可以设计并实现时间复杂度为O(n) 的解决方案吗？
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 提示：
 * 0 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * <p>
 * 解法1：
 * 先排序，时间复杂度O(nlog(n))。
 * <p>
 * 解法2：
 * 用两个hashmap，维持所有的连续区间，最后比较最大的一个.
 */
public class Solution128 {
    public static void main(String[] args) {
        new Solution128().longestConsecutive(new int[]{-7, -1, 3, -9, -4, 7, -3, 2, 4, 9, 4, -9, 8, -7, 5, -1, -7});
    }

    public int longestConsecutive(int[] nums) {
        int max = 0;
        Map<Integer, Integer> preMap = new HashMap<>();
        Map<Integer, Integer> sufMap = new HashMap<>();
        for (Integer i : nums) {
            if (preMap.get(i) != null || sufMap.get(i) != null) {
                continue;
            }
            if (preMap.get(i - 1) != null && sufMap.get(i + 1) != null) {
                int head = preMap.remove(i - 1);
                int tail = sufMap.remove(i + 1);
                preMap.put(tail, head);
                sufMap.put(head, tail);
            } else if (preMap.get(i - 1) != null) {
                Integer remove = preMap.remove(i - 1);
                preMap.put(i, remove);
                sufMap.put(remove, i);
            } else if (sufMap.get(i + 1) != null) {
                Integer remove = sufMap.remove(i + 1);
                sufMap.put(i, remove);
                preMap.put(remove, i);
            } else {
                preMap.put(i, i);
                sufMap.put(i, i);
            }
        }
        for (Integer i : sufMap.keySet()) {
            max = Math.max(sufMap.get(i) - i + 1, max);
        }
        return max;
    }

}
