package com.algorithms.leetcode.medium;

import java.util.Arrays;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7]可能变为[4,5,6,7,0,1,2])。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回-1。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是O(logn) 级别。
 * 我的解法：先找到旋转的位置，然后将数组还原，再二分查找。寻找的方式也类似二分查找。
 * 其他解法：直接查找target。
 * <p>
 * 相关问题：
 * leetcode 第153题 {@link Solution153}
 * leetcode35题 {@link com.algorithms.leetcode.easy.Solution35}
 * leetcode34题 {@link com.algorithms.leetcode.medium.Solution34}
 */
public class Solution33 {
    public static void main(String[] args) {
//        System.out.println(new Solution33().search2(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
//        System.out.println(new Solution33().search2(new int[]{5, 1, 3}, 5));
        System.out.println(new Solution33().search2(new int[]{5, 1, 2, 3, 4}, 1));
//        System.out.println(new Solution33().search(new int[]{1, 3}, 0));

    }

    /**
     * 我的解法
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int pre = 0;
        int tail = nums.length - 1;
        int cur = -1;
        if (nums[tail] < nums[0]) {
            while (pre < tail) {
                int temp = pre + (tail - pre) / 2;
                if (temp != 0 && nums[temp] < nums[temp - 1]) {
                    cur = temp;
                    break;
                }
                if (temp != nums.length - 1 && nums[temp] > nums[temp + 1]) {
                    cur = temp + 1;
                    break;
                }
                if (nums[temp] < nums[pre]) {
                    tail = temp - 1;
                } else {
                    pre = temp + 1;
                }
            }
        }
        if (cur != -1) {
            int[] newArray = new int[nums.length];
            System.arraycopy(nums, cur, newArray, 0, nums.length - cur);
            System.arraycopy(nums, 0, newArray, nums.length - cur, cur);
            int newIndex = Arrays.binarySearch(newArray, target);
            if (newIndex < 0) {
                return -1;
            }
            if (newIndex < nums.length - cur) {
                return newIndex + cur;
            } else {
                return newIndex - nums.length + cur;
            }
        } else {
            int index = Arrays.binarySearch(nums, target);
            if (index < 0) {
                return -1;
            } else {
                return index;
            }
        }
    }

    /**
     * 直接查找target的解法
     */
    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int pre = 0;
        int tail = nums.length - 1;
        while (pre <= tail) {
            int temp = pre + (tail - pre) / 2;
            if (target == nums[temp]) {
                return temp;
            } else if (nums[pre] <= nums[temp]) {
                if (target >= nums[pre] && target <= nums[temp]) {
                    tail = temp - 1;
                } else {
                    pre = temp + 1;
                }
            } else {
                if (target >= nums[temp] && target <= nums[tail]) {
                    pre = temp + 1;
                } else {
                    tail = temp - 1;
                }
            }
        }
        return -1;
    }
}
