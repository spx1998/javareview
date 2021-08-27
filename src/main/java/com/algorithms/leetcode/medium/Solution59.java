package com.algorithms.leetcode.medium;

/**
 * 螺旋矩阵2
 * 给定一个正整数n，生成一个包含 1 到n2所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 示例:
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 * <p>
 * 我的解法：
 * 与54题类似，由于是正方形，不需判断单行单列的情况，但需要判断一个元素的情况。
 * 相似问题：
 * leetcode 54题 {@link Solution54}
 */

public class Solution59 {
    public static void main(String[] args) {
        new Solution59().generateMatrix(3);
    }

    public int[][] generateMatrix(int n) {
        if (n < 0) {
            return null;
        }
        int[][] result = new int[n][n];
        int temp = 0;
        int val = 1;
        while (n - 2 * temp > 0) {
            int x = temp;
            int y = temp;
            if (n - 2 * temp == 1) {
                result[x][y] = val;
                break;
            }
            while (y < n - temp - 1) {
                result[x][y++] = val;
                val++;
            }
            while (x < n - temp - 1) {
                result[x++][y] = val;
                val++;
            }
            while (y > temp) {
                result[x][y--] = val;
                val++;
            }
            while (x > temp) {
                result[x--][y] = val;
                val++;
            }
            temp++;
        }
        return result;
    }
}
