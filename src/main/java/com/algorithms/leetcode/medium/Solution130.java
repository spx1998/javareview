package com.algorithms.leetcode.medium;

import java.util.ArrayList;

/**
 * 给定一个二维的矩阵，包含'X'和'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的'O' 用 'X' 填充。
 * 示例:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的'O'都不会被填充为'X'。
 * 任何不在边界上，或不与边界上的'O'相连的'O'最终都会被填充为'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * 解法1：
 * 根据题意从左上遍历矩阵 同时DFS
 * 解法2：
 * 只检查从四条边为起点的O的区域，并将他们标记为另外一个符号比如A，然后再遍历一次矩阵，将O设为X，A设为O
 */
public class Solution130 {

    static class Point {
        int x;
        int y;
    }

    int[][] ints;

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        ints = new int[board.length][board[0].length];
//        0是未访问，1是访问过
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 'X' && ints[i][j] == 0) {
                    ArrayList<Point> points = new ArrayList<>();
                    if (doSomething(i, j, board, points)) {
//                            染色
                        for (Point p : points) {
                            board[p.x][p.y] = 'X';
                        }
                    }
                }
            }
        }
    }

    private boolean doSomething(int i, int j, char[][] board, ArrayList<Point> points) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (board[i][j] == 'X') {
            return true;
        }
        if (ints[i][j] == 1) {
            return true;
        }
        Point point = new Point();
        point.x = i;
        point.y = j;
        points.add(point);
        ints[i][j] = 1;
//        要用& 不用&&，保证一次遍历完所有连接的'O'节点.
        return doSomething(i + 1, j, board, points) &
                doSomething(i - 1, j, board, points) &
                doSomething(i, j + 1, board, points) &
                doSomething(i, j - 1, board, points);
    }
}
