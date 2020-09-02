package com.algorithms.leetcode.medium;

import java.util.ArrayList;

/**
 * 给定一个 n×n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * 示例 1:
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 我的解法：转就完事了
 * 其他解法：先转置矩阵，再倒排每一行：
 * 1 2 3     1 4 7     7 4 1
 * 4 5 6  -> 2 5 8 ->  8 5 2
 * 7 8 9     3 6 9     9 6 3
 *
 *
 */
public class Solution48 {
    public static void main(String[] args) {
        int[][] ints;
        new Solution48().rotate((ints = new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}));
        System.out.println("1");
    }

    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int n = 0;
        while (n < length / 2) {
            for (int i = 0; i < matrix.length - 1 - 2 * n; i++) {
                int temp = matrix[n][n + i];
                matrix[n][n + i] = matrix[matrix.length - 1 - n - i][n];
                matrix[matrix.length - 1 - n - i][n] = matrix[matrix.length - 1 - n][matrix.length - 1 - n - i];
                matrix[matrix.length - 1 - n][matrix.length - 1 - n - i] = matrix[n + i][matrix.length - 1 - n];
                matrix[n + i][matrix.length - 1 - n] = temp;
            }
            n++;
        }
    }
}
