package com.algorithms.leetcode.easy;

import java.util.stream.IntStream;

/**
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 * 说明：
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。
 * 你可以假设nums1有足够的空间（空间大小大于或等于m + n）来保存 nums2 中的元素。
 * 示例：
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出：[1,2,2,3,5,6]
 * 提示：
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n
 */
public class Solution88 {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 0, 0, 0};
        new Solution88().merge(ints, 3, new int[]{2, 5, 6}, 3);
        IntStream.of(ints).boxed().forEach(System.out::println);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        for (; i < n + m; i++) {
            if (j == n) {
                return;
            }
            if (nums1[i] > nums2[j]) {
                System.arraycopy(nums1, i, nums1, i + 1, m + n - 1 - i);
                nums1[i] = nums2[j];
                j++;
            }
        }
        if (j != n) {
            System.arraycopy(nums2, j, nums1, m + j, n - j);
        }
    }
}
