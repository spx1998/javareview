package com.algorithms.leetcode.medium;

/**
 * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例1:
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例2:
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * <p>
 * 我的解法：
 * 把二维数组看作一个有序的一位数组。将二维数组的坐标与一维数组坐标相映射。二分查找即可。
 *
 * 相关问题：
 * leetcode 36题 {@link Solution36}
 */
public class Solution74 {
    public static void main(String[] args) {
        boolean b = new Solution74().searchMatrix(new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}
                }, 3
        );
        /*boolean b = new Solution74().searchMatrix(new int[][]{
                {1, 1}}, 3
        );*/
        System.out.println(b);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int head = 0;
        int tail = matrix.length * matrix[0].length - 1;
        while (head <= tail) {
            int temp = head + (tail - head) / 2;
            int i = temp / matrix[0].length;
            int j = temp % matrix[0].length;
            if (target == matrix[i][j]) {
                return true;
            } else if (target > matrix[i][j]) {
                head = temp + 1;
            } else {
                tail = temp - 1;
            }
        }
        return false;
    }
}
