package com.algorithms.leetcode.medium;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * 示例1:
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例2:
 * 输入: m = 7, n = 3
 * 输出: 28
 * 提示：
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10 ^ 9
 * 我的解法：
 * 1 回溯法 超时
 * 2 动态规划 设置一个二维dp数组，dp[n][0],dp[0][n]都是1，其余的值dp[m][n] = dp[m-1][n]+dp[m][n-1].
 *
 * 相关问题：
 *  * leetcode 63题 {@link Solution63}
 */
public class Solution62 {
    public static void main(String[] args) {
        System.out.println(new Solution62().uniquePaths2(3, 2));
    }

    public int uniquePaths(int m, int n) {
        return doSomething(0, 0, m, n);
    }

    private int doSomething(int x, int y, int m, int n) {
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        if (x >= 0 && y >= 0 && x < m && y < n) {
            return doSomething(x + 1, y, m, n) + doSomething(x, y + 1, m, n);
        } else {
            return 0;
        }
    }

    public int uniquePaths2(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
