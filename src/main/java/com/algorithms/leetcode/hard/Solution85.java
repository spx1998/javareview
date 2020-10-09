package com.algorithms.leetcode.hard;

import com.algorithms.leetcode.medium.Solution503;
import com.algorithms.leetcode.medium.Solution739;

import java.util.Stack;

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 例如输入:
 * ["1","0","1","0","0"],  #   #
 * ["1","0","1","1","1"],  #   # # #
 * ["1","1","1","1","1"],  # # # # #
 * ["1","0","0","1","0"]   #     #
 * 输出: 6
 * 暴力解法：
 * 遍历数组中的元素，如果为0则向右向下寻找以之为左上方角的矩形的最大值，比较得出所有矩形的最大值。
 * 时间复杂度惊人，但是居然通过了。^_^
 * 优化：把向下向由找修改为向上向左找。
 * <p>
 * 单调栈解法：
 * 分别为每一行为底，构造柱状图。
 * 例如题例中，可以构造：(@用来占位，实际该处为空)
 * 1.         2.           3.          4.
 * 1                                      #
 * 2                          #   #       #     #
 * 3             #   #        #   # # #   #     #
 * 4 # @ # @ @   # @ # # #    # # # # #   # @ @ # @
 * 由此转换为四个单调栈问题的最大值。
 * <p>
 * 相关问题：
 * leetcode42题  {@link Solution42}
 * leetcode84题  {@link Solution84}
 * leetcode503题 {@link Solution503}
 * leetcode739题 {@link Solution739}
 */
public class Solution85 {
    public static void main(String[] args) {
        char[][] chars = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(new Solution85().monotonousStack(chars));
    }

    /**
     * 暴力解法
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0] == null || (matrix.length == 1 && matrix[0].length == 0)) {
            return 0;
        }
        int row = matrix.length;//行数
        int col = matrix[0].length;//列数
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    int n = j;
                    int minHeight = Integer.MAX_VALUE;
                    while (n < col && matrix[i][n] == '1') {
                        int m = i;
                        while (m < row && matrix[m][n] == '1') {
                            m++;
                        }
                        n++;
                        minHeight = Math.min(minHeight, m - i);
                        maxArea = Math.max(maxArea, minHeight * (n - j));
                    }
                }
            }
        }
        return maxArea;
    }

    /**
     * 单调栈解法
     */
    public int monotonousStack(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length + 1];
        int maxArea = 0;
        for (char[] chars : matrix) {
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            for (int col = 0; col <= matrix[0].length; col++) {
//                记录每一列在当前柱状图的高度。如果当前行该列为1，则上一个柱状图中该列高度+1；若当前行该列为0，则置为0。
                if (col < matrix[0].length) {
                    if (chars[col] == '1') {
                        heights[col] += 1;
                    } else {
                        heights[col] = 0;
                    }
                }
                while (stack.peek() != -1 && heights[stack.peek()] > heights[col]) {
                    maxArea = Math.max(maxArea, heights[stack.pop()] * (col - stack.peek() - 1));
                }
                stack.push(col);
            }
            while (stack.peek() != -1) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
            }
        }
        return maxArea;
    }

}
