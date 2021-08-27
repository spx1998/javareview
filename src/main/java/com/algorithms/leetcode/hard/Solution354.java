package com.algorithms.leetcode.hard;


import java.util.Arrays;

/**
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 注意：不允许旋转信封。
 * 示例 1：
 * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出：3
 * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * 示例 2：
 * 输入：envelopes = [[1,1],[1,1],[1,1]]
 * 输出：1
 * 我的解法：
 * 先排序，再DP
 */
public class Solution354 {
    public int maxEnvelopes(int[][] envelopes) {
//        排序
        for (int i = 0; i < envelopes.length; i++) {
            int tar = i;
            int[] temp = new int[2];
            temp[0] = envelopes[i][0];
            temp[1] = envelopes[i][1];
            for (int j = i + 1; j < envelopes.length; j++) {
                if (envelopes[j][0] > envelopes[tar][0]) {
                    tar = j;
                }
            }
            envelopes[i][0] = envelopes[tar][0];
            envelopes[i][1] = envelopes[tar][1];
            envelopes[tar][0] = temp[0];
            envelopes[tar][1] = temp[1];
        }
//        DP
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int j = 0;
            dp[i] = 1;
            while (envelopes[j][0] > envelopes[i][0]) {
                if (envelopes[j][1] > envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                j++;
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
