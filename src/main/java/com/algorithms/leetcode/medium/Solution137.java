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
 * <p>
 * 解法：
 * 整个数组中，对于每一位，1出现的次数有4种可能：0次，1次，3次，4次。如果出现次数是0次或3次，res中此位为0，如果出现次数为1次或4次，res中此位为1。
 * 即，对每位1的出现次数除三取余，若余0则该位为0，余1该位为1。
 * 用一个两位的数字来表示某位1出现次数对3取余的结果。两位分别为twice和once。
 * 遍历数组，对于当前元素，该位的数组为n，n属于{0,1}:
 * * if twice = 0
 * *     if n = 0
 * *     once = once
 * *     if n = 1
 * *     once = ~once
 * * if twice = 1
 * *     once = 0 (余数为0，1，2，twice=1只有一种可能，余数=2，即once=0)
 * 上式简化可得：
 * * if twice = 0
 * *     once = n ^ once
 * * if twice = 1
 * *     once = 0
 * 再简化得：
 * * once = n ^ once & ~twice
 * 同理可得：
 * * twice = twice ^ n & ~once
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
