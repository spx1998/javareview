package com.algorithms.leetcode.medium;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
 * 假定每组输入只存在唯一答案。
 * 示例：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 提示：
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 * 我的解法：双指针 类似第15题。
 * 相关问题：
 * leetcode第15题  {@link Solution15}
 */
public class Solution16 {
    public static void main(String[] args) {
        new Solution16().threeSumClosest(new int[]{0,2,1,-3},1);
    }
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int x = i + 1;
            int y = nums.length - 1;
            while (x < y) {
                int temp = nums[i] + nums[x] + nums[y];
                if (Math.abs(target - temp) < min) {
                    min = Math.min(Math.abs(target - temp), min);
                    res = temp;
                }
                if (min == 0) {
                    return res;
                }
                if (target - temp > 0) {
                    x++;
                } else {
                    y--;
                }
            }
        }
        return res;
    }
}
