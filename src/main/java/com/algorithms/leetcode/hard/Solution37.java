package com.algorithms.leetcode.hard;

/**
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。
 * 空白格用'.'表示。
 * <p>
 * Note:
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 * <p>
 * 我的解法：回溯法 遍历二维数组，对每一个'.'赋1-9，使用Solution36中的方法验证此时数独是否成立，若成立，则继续遍历，若不成立，赋下一个值。
 * 若赋值1-9均不成立，则将当前值设回'.'，然后返回前一个'.'的位置，继续遍历。
 * 更佳解法：利用三个全局的二维数组标记插入情况，而不要每次构建并判定。
 *
 * 相关问题：
 * leetcode 36题 {@link com.algorithms.leetcode.medium.Solution36}
 */
public class Solution37 {
    public static void main(String[] args) {
        new Solution37().solveSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        });
    }

    /*public void solveSudoku(char[][] board) {
        fillSudoKu(board, 0, 0);
    }

    private boolean fillSudoKu(char[][] board, int row, int col) {
        if (!isValidSudoku(board)) {
            board[row][col] = '.';
            return false;
        }
        while (row < 9) {
            while (col < 9) {
                if (board[row][col] == '.') {
                    for (int i = 1; i <= 9; i++) {
                        board[row][col] = (char) (i + '0');
                        if (fillSudoKu(board, row, col)) {
                            return true;
                        }
                    }
                    board[row][col] = '.';
                    return false;
                }
                col++;
            }
            row++;
            col = 0;
        }
        return true;
    }

    private boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = (int) c;
                    int boxIndex = i / 3 + (j / 3) * 3;
                    rows[i].put(num, rows[i].getOrDefault(num, 0) + 1);
                    columns[j].put(num, columns[j].getOrDefault(num, 0) + 1);
                    boxes[boxIndex].put(num, boxes[boxIndex].getOrDefault(num, 0) + 1);
                    if (rows[i].get(num) > 1 || columns[j].get(num) > 1 || boxes[boxIndex].get(num) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }*/

    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][] boxes = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        //初始化数组
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[(i / 3) * 3 + j / 3][num] = true;
                }
            }
        }
        sudoku(board, 0);
    }

    private boolean sudoku(char[][] board, int n) {
        if (n == 81) {
            return true;
        }
        int row = n / 9;
        int col = n % 9;
        int k = (row / 3) * 3 + col / 3;
        if (board[row][col] != '.') {
            return sudoku(board, n + 1);
        }
        for (int i = 0; i < 9; i++) {
            if (rows[row][i] || cols[col][i] || boxes[k][i]) {
                continue;
            }
            board[row][col] = (char) (i + '1');
            rows[row][i] = cols[col][i] = boxes[k][i] = true;
            if (sudoku(board, n + 1)) {
                return true;
            }
            rows[row][i] = cols[col][i] = boxes[k][i] = false;
        }
        board[row][col] = '.';

        return false;
    }
}
