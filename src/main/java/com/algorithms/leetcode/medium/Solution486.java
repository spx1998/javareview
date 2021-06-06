package com.algorithms.leetcode.medium;

/**
 * 给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，…… 。
 * 每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 * <p>
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 * 解法：
 * 记dp[i][j]为如果区间为[i,j]，先选的玩家与后选玩家的总分差。
 */
public class Solution486 {
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        for (int l = 1; l < nums.length; l++) {
            for (int i = 0; i + l < nums.length; i++) {
                int j = i + l;
                dp[i][j] = Math.max(-dp[i][j - 1] + nums[j], -dp[i + 1][j] + nums[i]);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }
}
