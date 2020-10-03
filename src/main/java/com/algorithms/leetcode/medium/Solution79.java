package com.algorithms.leetcode.medium;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 示例:
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * 提示：
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * 我的解法：
 * 回溯法
 */
public class Solution79 {
    public static void main(String[] args) {
        boolean see = new Solution79().exist(new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}},
                "SEE");
        System.out.println(see);
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0, board, used, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int row, int col, int index, char[][] board, boolean[][] used, String word) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (board[row][col] == word.charAt(index) && !used[row][col]) {
            used[row][col] = true;
            boolean res = dfs(row + 1, col, index + 1, board, used, word) ||
                    dfs(row - 1, col, index + 1, board, used, word) ||
                    dfs(row, col + 1, index + 1, board, used, word) ||
                    dfs(row, col - 1, index + 1, board, used, word);
            used[row][col] = false;
            return res;
        }
        return false;
    }
}
