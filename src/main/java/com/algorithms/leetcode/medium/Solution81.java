package com.algorithms.leetcode.medium;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组[0,0,1,2,2,5,6]可能变为[2,5,6,0,0,1,2])。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回true，否则返回false。
 * 示例1:
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例2:
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 进阶:
 * 这是 搜索旋转排序数组的延伸题目，本题中的nums 可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 * 解法：
 * 与33题类似的二分查找，但是会出现因为重复数字，导致结果出错。如果nums[head]==nums[mid]就无法分辨mid左侧是有序的还是右侧是有序的，
 * 此时将head+1，再进行判断，直到nums[head]!=nums[mid]。
 * <p>
 * 相关问题：
 * leetcode 33题 {@link Solution33}
 */
public class Solution81 {
    public static void main(String[] args) {
        System.out.println(new Solution81().search(new int[]{1, 3, 1, 1, 1}, 3));
    }

    public boolean search(int[] nums, int target) {
        int head = 0;
        int tail = nums.length - 1;
        while (head <= tail) {
            int temp = head + (tail - head) / 2;
            if (nums[temp] == target) {
                return true;
            }
            /*
              用来处理重复数字
             */
            if (nums[head] == nums[temp]) {
                head++;
                continue;
            }
            if (nums[head] <= nums[temp]) {
                if (target < nums[temp] && target >= nums[head]) {
                    tail = temp - 1;
                } else {
                    head = temp + 1;
                }
            } else {
                if (target > nums[temp] && target <= nums[tail]) {
                    head = temp + 1;
                } else {
                    tail = temp - 1;
                }
            }
        }
        return false;
    }
}
