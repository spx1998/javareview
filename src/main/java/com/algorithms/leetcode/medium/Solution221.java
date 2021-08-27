package com.algorithms.leetcode.medium;

/**
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * TODO 解法
 */
public class Solution221 {
    public static void main(String[] args) {
        int i = new Solution221().maximalSquare(new char[][]{
                {'1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1', '0', '0', '0'},
                {'0', '1', '1', '1', '1', '0', '0', '0'}
        });
        System.out.println(i);
    }

    /**
     * 暴力
     */
    public int maximalSquare0(char[][] matrix) {
        int max = 0;
        if (matrix.length == 0 || matrix[0].length == 0) {
            return max;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int temp = 1;
                    while (check(matrix, i, j, temp)) {
                        temp++;
                    }
                    max = Math.max(temp, max);
                }
            }
        }
        return max * max;
    }

    private boolean check(char[][] matrix, int i, int j, int temp) {
        if (i + temp >= matrix.length || j + temp >= matrix[0].length) {
            return false;
        }
        for (int k = i; k <= i + temp; k++) {
            if (matrix[k][j + temp] != '1') {
                return false;
            }
        }
        for (int k = j; k <= j + temp; k++) {
            if (matrix[i + temp][k] != '1') {
                return false;
            }
        }
        return true;
    }

    /**
     * DP
     */
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        if (matrix.length == 0 || matrix[0].length == 0) {
            return max;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
