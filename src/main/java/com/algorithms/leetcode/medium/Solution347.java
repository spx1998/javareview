package com.algorithms.leetcode.medium;


/**
 * 快速选择
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 提示：
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n是数组大小。
 */
public class Solution347 {

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k + 1;
        if (nums.length < k) {
            return 0;
        }
        quickSelect(nums, k, 0, nums.length);
        return nums[k - 1];
    }

    private void quickSelect(int[] nums, int k, int head, int tail) {
        int index = partition(nums, head, tail);
        if (index == k - 1) {
            return;
        } else if (index < k - 1) {
            quickSelect(nums, k, index + 1, tail);
        } else {
            quickSelect(nums, k, head, index);
        }
    }

    private int partition(int[] nums, int head, int tail) {
        int temp = nums[head];
        tail = tail - 1;
        while (head < tail) {
            while (head < tail && nums[tail] > temp) {
                tail--;
            }
            swap(nums, head, tail);
            while (head < tail && nums[head] <= temp) {
                head++;
            }
            swap(nums, head, tail);
        }
        return head;
    }

    private void swap(int[] nums, int head, int tail) {
        int temp = nums[head];
        nums[head] = nums[tail];
        nums[tail] = temp;
    }
}
