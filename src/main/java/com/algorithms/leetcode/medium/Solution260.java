package com.algorithms.leetcode.medium;

/**
 * 只出现一次的数字3
 * 数组中两个元素只出现了一次，其他元素均出现了两次，求这两个元素。
 * {@link Solution137}
 * {@link com.algorithms.leetcode.easy.Solution136}
 */
public class Solution260 {
    public int[] singleNumber(int[] nums) {
        int res1 = 0;
        int res2 = 0;

        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int dev = 1;
        while ((ret & dev) == 0) {
            dev = dev << 1;
        }
        for (int n : nums) {
            if ((n & dev) == 0) {
                res1 ^= n;
            } else {
                res2 ^= n;
            }
        }
        return new int[]{res1, res2};
    }
}
