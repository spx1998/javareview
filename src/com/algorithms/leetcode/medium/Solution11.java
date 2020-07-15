package com.algorithms.leetcode.medium;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2
 *
 * 我的解法：
 * 双指针，指向左右两侧，每次移动高度较小的一侧，比较当前面积与max。指针相遇时停止。
 */
public class Solution11 {
    public static void main(String[] args) {
        System.out.println(new Solution11().maxArea(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
    }

    public int maxArea(int[] height) {
        int max = Math.min(height[0], height[height.length - 1]) * (height.length - 1);
        int i = 0;
        int j = height.length - 1;
        while (i != j) {
            int temp = Math.min(height[i], height[j]) * (j - i);
            if (temp > max) {
                max = temp;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
