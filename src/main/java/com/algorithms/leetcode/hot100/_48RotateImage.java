package com.algorithms.leetcode.hot100;

/**
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class _48RotateImage {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            doRotate(matrix, i);
        }
    }

    private void doRotate(int[][] matrix, int start) {
        for (int i = start; i < matrix.length - start - 1; i++) {
            int temp = matrix[start][i];
            matrix[start][i] = matrix[matrix.length - i - 1][start];
            matrix[matrix.length - i - 1][start] = matrix[matrix.length - 1 - start][matrix.length - 1 - i];
            matrix[matrix.length - 1 - start][matrix.length - 1 - i] = matrix[i][matrix.length - 1 - start];
            matrix[i][matrix.length - 1 - start] = temp;
        }
    }
}
