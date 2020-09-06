package com.algorithms.leetcode.hard;

/**
 * n皇后问题研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * 我的解法： 与51题一样的回溯法。
 * 相关问题：
 * leetcode 51题 {@link Solution51}
 */
public class Solution52 {
    boolean[] col;
    boolean[] x;
    boolean[] y;
    int result = 0;

    public static void main(String[] args) {
        new Solution52().totalNQueens(1);
    }

    public int totalNQueens(int n) {
        col = new boolean[n];
        x = new boolean[2 * n - 1];
        y = new boolean[2 * n - 1];
        dfs(n, 0);
        return result;
    }

    private void dfs(int n, int row) {
        if (row == n) {
            result++;
            return;
        }
        for (int i = 0; i < n; i++) {

            if (!col[i] && !x[row + i] && !y[row - i + n - 1]) {
                col[i] = true;
                x[row + i] = true;
                y[row - i + n - 1] = true;
                dfs(n, row + 1);
                col[i] = false;
                x[row + i] = false;
                y[row - i + n - 1] = false;
            }
        }
    }
}
