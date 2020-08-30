package com.algorithms.leetcode.hard;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
 * 说明:
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 我的解法：反向查找
 * 设置一个数组，记录每一个位置到达末尾的最少步数。steps[nums.length-1]显然是0。从后向前遍历，step[0]的值即所得。时间复杂度O(n^2)
 * 正向查找的解法：
 * 本题可以使用贪心的解法。每次在可跳范围内选择可以跳的更远的位置，那么到达末尾的跳跃次数一定是最少的。
 * 例如第一次跳跃可达的位置是3 ，1 ：1+3>2+1 则跳往下标为1处。
 * 重要的是发现本题可以使用贪心算法，即局部最优解是全局最优解的一部分。
 * <p>
 * <p>
 * 相关问题：
 * leetcode 55题 {@link com.algorithms.leetcode.medium.Solution55}
 */
public class Solution45 {
    public static void main(String[] args) {
        System.out.println(new Solution45().jump(new int[]{2, 3, 1, 1, 4}));
    }

    public int jump(int[] nums) {
        int[] steps = new int[nums.length];
        steps[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j < nums.length && j <= i + nums[i]; j++) {
                if (steps[j] != Integer.MAX_VALUE) {
                    min = Math.min(min, steps[j] + 1);
                }
            }
            steps[i] = min;
        }
        return steps[0];
    }

    /**
     * 正向查找
     */
    public int jump2(int[] nums) {
        int step = 0;
        //end 来记录当前一次跳的范围（(i,end]）
        int end = 0;
        int maxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            // i==end 说明已经到达了此次跳跃的最远距离，例如 第0次跳的最远距离是0（即从下标0开始），第1次跳跃的最远距离是2。
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }
}
