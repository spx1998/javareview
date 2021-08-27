package com.algorithms.leetcode.hot100;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
 */
public class _33SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int head = 0;
        int tail = nums.length - 1;
        while (head <= tail) {
            int temp = head + (tail - head) / 2;
            if (nums[head] == target) {
                return head;
            }
            if (nums[tail] == target) {
                return tail;
            }
            if (nums[temp] == target) {
                return temp;
            }
            if (nums[temp] >= nums[head]) {
                if (target > nums[head] && target < nums[temp]) {
                    tail = temp - 1;
                } else {
                    head = temp + 1;
                }
            } else if (nums[temp] < nums[head]) {
                if (target < nums[head] && target > nums[temp]) {
                    head = temp + 1;
                } else {
                    tail = temp - 1;
                }
            }
        }
        return -1;
    }
}
