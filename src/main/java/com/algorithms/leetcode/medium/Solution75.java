package com.algorithms.leetcode.medium;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * 示例:
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * 我的解法：
 * 遍历一次数组，遍历过程中不停交换位置。
 * 优化解法：
 * 双指针 头指针之前都为0，尾指针之后都为2，从前向后遍历并交换。注意如果是与尾指针处的值交换后，要对当期位置的元素再判断一次。遍历到尾指针处停止。
 */
public class Solution75 {
    public static void main(String[] args) {
        int[] ints = {2, 0, 1};
        new Solution75().sortColors2(ints);
        System.out.println(Arrays.toString(ints));
    }

    public void sortColors(int[] nums) {
        if (nums == null) {
            return;
        }
        int tail = nums.length - 1;
        for (int i = 0; i <= tail; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (nums[i] == 2) {
                while (tail > i && nums[tail] == 2) {
                    tail--;
                }
                nums[i] = nums[tail];
                nums[tail] = 2;
            }
            if (nums[i] == 1) {
                int j = i + 1;
                while (j < nums.length && nums[j] != 0) {
                    j++;
                }
                if (j == nums.length) {
                    continue;
                }
                nums[i] = 0;
                nums[j] = 1;
            }
        }
    }

    public void sortColors2(int[] nums) {
        int head = 0;
        int tail = nums.length - 1;
        int cur = 0;
        while (cur <= tail) {
            if (nums[cur] == 0) {
                nums[cur++] = nums[head];
                nums[head++] = 0;
            } else if (nums[cur] == 2) {
                nums[cur] = nums[tail];
                nums[tail--] = 2;
            } else {
                cur++;
            }
        }
    }
}
