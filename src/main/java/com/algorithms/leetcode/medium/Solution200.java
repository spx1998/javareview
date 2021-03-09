package com.algorithms.leetcode.medium;

/**
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 示例 1：
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 * 题解：
 * 新加一个状态2，表示已经遍历过。然后逐个遍历二维数组，0或2则跳过，1则以之为起点，寻找"岛"。递归寻找岛边界。
 */
public class Solution200 {
    //    2:已遍历过
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    traverse(i, j, grid);
                }
            }
        }
        return result;
    }

    private void traverse(int i, int j, char[][] grid) {
        if (grid[i][j] == '1') {
            grid[i][j] = '2';
            if (i > 0)
                traverse(i - 1, j, grid);
            if (i < grid.length - 1)
                traverse(i + 1, j, grid);
            if (j > 0)
                traverse(i, j - 1, grid);
            if (j < grid[0].length - 1)
                traverse(i, j + 1, grid);
        }
    }
}
