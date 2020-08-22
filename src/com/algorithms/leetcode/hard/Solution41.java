package com.algorithms.leetcode.hard;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 * 我的解法：做不出来 ^^
 * 官方解法：
 * <p>
 * 首先，看到题目很容易想到，将nums中的值放入hashmap中，然后从1开始遍历正整数，第一个不在hash表中的数即所得。
 * 但是，问题在于建立hashmap会占用格外空间，所以这种解法的空间复杂度为O(n),不符合题目要求。
 * 于是想到（想不到^^）使用原有的数组空间来模拟hashmap。有一些两种方法
 * 1）hash 首先，结果值的区间是[1,n+1]，若nums包含从1开始的连续正数，则结果为n+1，否则结果是[1,n]中的第一个缺失的数。
 * 那么我们遍历数组，若元素值x属于[1,n]，则利用其对应下标处（x-1）的值来标注元素存在即可。遍历结束后再遍历一次数组，第一个未被标注的下标即结果。
 * 重点在于，如何标记元素已存在？非常巧妙的办法：将数组中的负数全部转换为不在[1,n]区间内的正值，然后用负号来标记即可。
 * 例如[2,1,-1] ,将-1转换为4，然后第一次遍历后结果为[-1,-2,4],发现下标为2的元素仍为正值，结果即2+1=3；
 * 2）置换
 * 通过置换，将元素值与下标匹配，例如将n = 2 的元素移动到 下标为2 - 1处。完成后再进行一次遍历，元素值与下标无法对应的值即结果，若全部对应结果则为n+1。
 */
public class Solution41 {
    /**
     * hash
     */
    public int firstMissingPositiveHash(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) <= nums.length && nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    /**
     * 置换
     */
    public int firstMissingPositiveExchange(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            //while是因为被交换过来的数可能仍然是[1,n]内的数，所以要继续交换这个数；
            // nums[nums[i] - 1] != nums[i]是防止nums[nums[i] - 1] = nums[i]导致死循环。
            //[1,1] i=1,nums[1 - 1] = 1，会导致两个值一直交换位置，陷入死循环。
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

}
