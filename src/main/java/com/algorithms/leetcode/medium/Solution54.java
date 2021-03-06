package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵1
 * 给定一个包含m x n个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 我的解法：
 * 根据题意旋转即可，根据如下顺序遍历。需要注意一行或一列的情况,如 {{1 2 3 4}}，会出现 1 2 3 4 3 2 重复遍历的情况，
 * 需要在代码中判断是否是单行或单列，如果是，只输出第二行/列的第一个元素。
 * A A A A B
 * D E E E B
 * D C C C C
 *
 * 相似问题:
 * leetcode 59题 {@link com.algorithms.leetcode.medium.Solution59}
 */
public class Solution54 {
    public static void main(String[] args) {
        new Solution54().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}).forEach(System.out::println);
        System.out.println("--------------");
        new Solution54().spiralOrder(new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}}).forEach(System.out::println);
        System.out.println("--------------");

        new Solution54().spiralOrder(new int[][]{{1, 2, 3, 4}}).forEach(System.out::println);
        System.out.println("--------------");
        new Solution54().spiralOrder(new int[][]{{1}, {2}, {3}, {4}}).forEach(System.out::println);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int x = 0;
        int y = 0;
        while (matrix.length - 2 * x > 0 && matrix[0].length - 2 * y > 0) {
            int i = x;
            int j = y;
            boolean b1 = false;
            boolean b2 = false;
            while (j < matrix[0].length - 1 - y) {
                list.add(matrix[i][j++]);
                b2 = true;
            }
            while (i < matrix.length - 1 - x) {
                list.add(matrix[i++][j]);
                b1 = true;
            }
            if (b1) {
                while (j > y) {
                    list.add(matrix[i][j--]);
                }
            } else {
                list.add(matrix[i][j]);
                break;
            }
            if (b2) {
                while (i > x) {
                    list.add(matrix[i--][j]);
                }
            } else {
                list.add(matrix[i][j]);
                break;
            }
            x++;
            y++;
        }

        return list;
    }
}
