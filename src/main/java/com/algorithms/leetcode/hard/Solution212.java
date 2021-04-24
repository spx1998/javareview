package com.algorithms.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个m x n 二维字符网格board和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 * 我的解法：直接DFS 耗时久
 * 优化解法：trie剪枝
 */
public class Solution212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> arrayList = new ArrayList<>();
        boolean[][] marked = new boolean[board.length][board[0].length];
        loop1:
        for (String s : words) {
            if (arrayList.contains(s)) {
                continue;
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (s.charAt(0) == board[i][j] && dfs(board, marked, i, j, s, 0)) {
                        arrayList.add(s);
                        continue loop1;
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean dfs(char[][] board, boolean[][] marked, int i, int j, String word, int index) {
        if (marked[i][j]) {
            return false;
        }
        if (board[i][j] == word.charAt(index)) {
            if (index == word.length() - 1) {
                return true;
            }
            marked[i][j] = true;
            boolean contains = false;
            if (i < board.length - 1 && dfs(board, marked, i + 1, j, word, index + 1)) {
                contains = true;
            }
            if (!contains && i > 0 && dfs(board, marked, i - 1, j, word, index + 1)) {
                contains = true;

            }
            if (!contains && j < board[0].length - 1 && dfs(board, marked, i, j + 1, word, index + 1)) {
                contains = true;

            }
            if (!contains && j > 0 && dfs(board, marked, i, j - 1, word, index + 1)) {
                contains = true;

            }
            marked[i][j] = false;
            return contains;
        }
        return false;
    }
}
