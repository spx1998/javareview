package com.algorithms.leetcode.medium;

/**
 * 给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。
 * 进阶：
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为O(1) 的原地算法解决这个问题吗？
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 提示：
 * 1 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 * 我的解法：
 * O(1)空间复杂度，求step和length的最大公约数m，对于[0,m)遍历，逐个替换。
 */
public class Solution189 {
    public static void main(String[] args) {
        new Solution189().rotate(new int[]{1, 2, 3, 4, 5, 6,}, 4);
    }

    public void rotate(int[] nums, int k) {
        if (nums.length == 0 || k % nums.length == 0) {
            return;
        }
        int length = nums.length;
        int step = k % length;
        int a = length;
        int b = step;
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        for (int i = 0; i < b; i++) {
            int v = nums[i];
            int newIndex = i + step;
            while (newIndex % length != i) {
                int temp = nums[newIndex];
                nums[newIndex] = v;
                v = temp;
                newIndex = (newIndex + step) % length;
            }
            nums[i] = v;
        }
    }
}
