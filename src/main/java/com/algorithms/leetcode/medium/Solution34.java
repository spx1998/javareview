package com.algorithms.leetcode.medium;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是O(log n) 级别。
 * 如果数组中不存在目标值，返回[-1, -1]。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * 我的思路：
 * 类似二分查找，如果temp处的值不等于target，则完全与二分查找相同，若等于target，则两侧分别继续进行查找。
 * <p>
 * leetcode33题 {@link com.algorithms.leetcode.medium.Solution33}
 * leetcode35题 {@link com.algorithms.leetcode.easy.Solution35}
 */
public class Solution34 {
    public static void main(String[] args) {
        Arrays.stream(new Solution34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)).forEach(System.out::println);
    }

    public int[] searchRange0(int[] nums, int target) {
        int[] res = {-1, -1};
        int pre = 0;
        int tail = nums.length - 1;
        binary(nums, target, pre, tail, res);
        return res;
    }

    private void binary(int[] nums, int target, int pre, int tail, int[] res) {
        if (pre <= tail) {
            int temp = pre + (tail - pre) / 2;
            if (nums[temp] == target) {
                if (res[0] == -1) {
                    res[0] = temp;
                    res[1] = temp;
                } else if (temp < res[0]) {
                    res[0] = temp;
                } else if (temp > res[1]) {
                    res[1] = temp;
                }
                binary(nums, target, temp + 1, tail, res);
                binary(nums, target, pre, temp - 1, res);
            } else if (nums[temp] > target) {
                tail = temp - 1;
                binary(nums, target, pre, tail, res);
            } else {
                pre = temp + 1;
                binary(nums, target, pre, tail, res);
            }
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        res[0] = getLeft(nums, target);
        res[1] = getRight(nums, target);
        return res;
    }


    private int getLeft(int[] arr, int target) {
        int head = 0;
        int tail = arr.length - 1;
        while (head <= tail) {
            int temp = head + (tail - head) / 2;
            if (arr[temp] > target) {
                tail = temp - 1;
            } else if (arr[temp] < target) {
                head = temp + 1;
            } else {
                tail = temp - 1;
            }
        }
        return head < arr.length && arr[head] == target ? head : -1;
    }

    private int getRight(int[] arr, int target) {
        int head = 0;
        int tail = arr.length - 1;
        while (head <= tail) {
            int temp = head + (tail - head) / 2;
            if (arr[temp] > target) {
                tail = temp - 1;
            } else if (arr[temp] < target) {
                head = temp + 1;
            } else {
                head = temp + 1;
            }
        }
        return tail >= 0 && arr[tail] == target ? arr[target] : -1;
    }

}
