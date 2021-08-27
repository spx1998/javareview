package com.algorithms.leetcode.medium;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * <p>
 * 解法：原地建小顶堆
 */
public class Solution215 {
    public static void main(String[] args) {
        Solution215 solution215 = new Solution215();
        System.out.println(solution215.findKthLargest(new int[]{5,2,4,1,3,6,0}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        buildHeap(nums, k);
        for (int i = k; i < nums.length; i++) {
            updateHeap(nums, k, i);
        }
        return nums[0];
    }

    private void buildHeap(int[] nums, int k) {
        for (int i = k / 2 - 1; i >= 0; i--) {
            doBuildHeap(nums, k, i);
        }
    }

    private void doBuildHeap(int[] nums, int k, int i) {
        int temp = 2 * (i + 1);
        while (temp - 1 < k) {
            int index;
            if (temp == k) {
                index = temp - 1;
            } else {
                index = nums[temp - 1] > nums[temp] ? temp : temp - 1;
            }
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
            } else {
                break;
            }
            temp = 2 * (index + 1);
            i = index;
        }
    }

    private void swap(int[] nums, int k, int index) {
        int temp = nums[k];
        nums[k] = nums[index];
        nums[index] = temp;
    }

    private void updateHeap(int[] nums, int k, int i) {
        if (nums[i] <= nums[0]) {
            return;
        }
        swap(nums, 0, i);
        doBuildHeap(nums, k, 0);
    }


}
