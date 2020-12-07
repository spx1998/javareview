package com.algorithms.leetcode.medium;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例2:
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 * TODO 题解
 * 相关问题：
 * leetcode 第136题 {@link com.algorithms.leetcode.easy.Solution136}
 */
public class Solution137 {
    public int singleNumber(int[] nums) {
        int once = 0;
        int twice = 0;
        for (int num : nums) {
            once = ~twice & (once ^ num);
            twice = ~once & (twice ^ num);
        }
        return once;
    }
}
