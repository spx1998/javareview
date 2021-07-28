package com.algorithms.leetcode.medium;

/**
 * 编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * TODO 解法+更优解
 */
public class Solution240 {

    public static void main(String[] args) {
//        boolean b = new Solution240().searchMatrix(new int[][]
//                        {
//                                {1, 2, 3, 4, 5},
//                                {6, 7, 8, 9, 10},
//                                {11, 12, 13, 14, 15},
//                                {16, 17, 18, 19, 20},
//                                {21, 22, 23, 24, 25}
//                        },
//                19);
        boolean b = new Solution240().searchMatrix(new int[][]{{1, 2, 3, 4, 5}}, 2);
        System.out.println(b);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        return doSearch(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    private boolean doSearch(int[][] matrix, int target, int a, int b, int x, int y) {
        if (a > x || b > y) {
            return false;
        }
        if (matrix[a][b] == target || matrix[x][y] == target) {
            return true;
        }
        if (a == x && b == y) {
            return false;
        }
        int t1 = a + (x - a) / 2;
        int t2 = b + (y - b) / 2;
        if (matrix[t1][t2] == target) {
            return true;
        }
        if (target > matrix[t1][y] && target > matrix[x][t2]) {
            return doSearch(matrix, target, t1 + 1, t2 + 1, x, y);
        }
        if (target > matrix[t1][t2]) {
            return doSearch(matrix, target, t1 + 1, t2 + 1, x, y) || doSearch(matrix, target, t1 + 1, b, x, t2) || doSearch(matrix, target, a, t2 + 1, t1, y);
        }
        return doSearch(matrix, target, a, b, t1, t2) || doSearch(matrix, target, t1 + 1, b, x, t2) || doSearch(matrix, target, a, t2 + 1, t1, y);
    }
}
