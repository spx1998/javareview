package com.algorithms.leetcode.hot100;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * 进阶：
 * 你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
 */
public class _34FindFirstandLastPositionofElementinSortedArray {
    public static void main(String[] args) {
        int[] ints = new _34FindFirstandLastPositionofElementinSortedArray().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);

    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};

        res[0] = getLeft(nums, target);
        if (res[0] == -1) {
            return res;
        }
        res[1] = getRight(nums, target);

        return res;
    }

    private int getRight(int[] nums, int target) {
        int head = 0;
        int tail = nums.length - 1;
        while (head <= tail) {
            int temp = head + (tail - head) / 2;
            if (nums[temp] == target) {
                head = temp + 1;
            } else if (nums[temp] < target) {
                head = temp + 1;
            } else if (nums[temp] > target) {
                tail = temp - 1;
            }
        }
        return tail == -1 || nums[head - 1] != target ? -1 : head - 1;
    }

    private int getLeft(int[] nums, int target) {
        int head = 0;
        int tail = nums.length - 1;
        while (head <= tail) {
            int temp = head + (tail - head) / 2;
            if (nums[temp] == target) {
                tail = temp - 1;
            } else if (nums[temp] < target) {
                head = temp + 1;
            } else if (nums[temp] > target) {
                tail = temp - 1;
            }
        }
        return head == nums.length || nums[tail + 1] != target ? -1 : tail + 1;
    }
}
