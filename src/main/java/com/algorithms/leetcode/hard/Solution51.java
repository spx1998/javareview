package com.algorithms.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的n皇后问题的解决方案。
 * 每一种解法包含一个明确的n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 皇后彼此不能相互攻击，即：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 * 我的解法：回溯法
 */
public class Solution51 {
    boolean[] columns;

    public static void main(String[] args) {
        List<List<String>> lists = new Solution51().solveNQueens(4);
        System.out.println(lists);
    }

    public List<List<String>> solveNQueens(int n) {
        columns = new boolean[n];
        List<List<String>> result = new ArrayList<>();
        char[][] chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = '.';
            }
        }
        doSomething(0, n, chars, result);
        return result;
    }

    private void doSomething(int i, int n, char[][] chars, List<List<String>> result) {
        if (i == n) {
            List<String> list = new ArrayList<>();
            StringBuilder sb;
            for (int j = 0; j < n; j++) {
                sb = new StringBuilder();
                for (int k = 0; k < n; k++) {
                    sb.append(chars[j][k]);
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!columns[j]) {
                boolean temp = true;
                for (int k = 1; k <= i; k++) {
                    if (i - k >= 0 && j + k < n) {
                        if (chars[i - k][j + k] == 'Q') {
                            temp = false;
                            break;
                        }
                    }
                    if (i - k >= 0 && j - k >= 0) {
                        if (chars[i - k][j - k] == 'Q') {
                            temp = false;
                            break;
                        }
                    }
                }
                if (!temp) {
                    continue;
                }
                chars[i][j] = 'Q';
                columns[j] = true;
                doSomething(i + 1, n, chars, result);
                columns[j] = false;
                chars[i][j] = '.';

            }
        }
    }
}
