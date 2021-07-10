package com.algorithms.leetcode.hot100;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 解法：
 * 暴力解法，双指针 时间复杂度O(n)
 * 二分解法
 * 把原问题转化成找两个数组中倒数第k大的元素,其中k = (n+m)/2+1;(区分m+n的奇偶)
 * 那么两个数组中第k/2个元素中的较小值大于 k/2-1 ~ ((k/2-1)*2-1 = k-1)个元素,这个较小值以及之前的元素可以抛弃掉，进而得到新的数组和新的k值。重复上述过程。
 * 特别地，如果k/2>某个数组的长度，那么要把临时下标k/2缩小到arr.length-1。
 * 循环结束的条件：
 * 1）其中一个数组的元素全部小于两个数组中的第k个较小元素，那么直接在另外一个数组中找即可；
 * 2）k值缩小到1，即取两个数组中的第一个元素比较。
 */
public class _4MedianofTwoSortedArrays$ {
    public static void main(String[] args) {
        double medianSortedArrays = new _4MedianofTwoSortedArrays$().findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        System.out.println(medianSortedArrays);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
//        将中位数转换为两个数组中的倒数第k大的数字。
//        并区分n+m的奇偶
        if ((l1 + l2) % 2 == 0) {
            return ((double) getKthNum(nums1, nums2, (l1 + l2) / 2 + 1) + getKthNum(nums1, nums2, (l1 + l2) / 2)) / 2;
        } else {
            return getKthNum(nums1, nums2, (l1 + l2) / 2 + 1);
        }
    }

    private int getKthNum(int[] nums1, int[] nums2, int k) {
//        用两个起点来表示缩容后新的数组而不用复制数组。
        int start1 = 0;
        int start2 = 0;
        while (true) {
//            两种退出循环的条件 收敛到求一个数组的k小数，或者k==1
            if (start1 == nums1.length) {
                return nums2[start2 + k - 1];
            }
            if (start2 == nums2.length) {
                return nums1[start1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[start1], nums2[start2]);
            }
//            两个数组中的倒数第 k/2个元素
            int temp1 = k / 2 - 1 + start1;
            int temp2 = k / 2 - 1 + start2;
            if (temp1 >= nums1.length) {
                temp1 = nums1.length - 1;
            }
            if (temp2 >= nums2.length) {
                temp2 = nums2.length - 1;
            }
            if (nums1[temp1] <= nums2[temp2]) {
                k -= temp1 - start1 + 1;
                start1 = temp1 + 1;
            } else {
                k -= temp2 - start2 + 1;
                start2 = temp2 + 1;
            }
        }
    }
}
