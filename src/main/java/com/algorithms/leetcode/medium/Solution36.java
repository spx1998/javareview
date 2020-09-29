package com.algorithms.leetcode.medium;

import java.util.HashMap;

/**
 * 判断一个9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 说明:
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字1-9和字符'.'。
 * 给定数独永远是9x9形式的。
 * <p>
 * 我的解法：根据题意三次遍历二维数组，判断行、列、子矩形的情况。
 * 更佳解法：遍历一次二维数组，对于每个位置的元素判断是否符合行列矩形的规则。通过三个hashmap数组记录情况。hashmap的key是元素值1-9，value是出现次数
 * 若任意key出现次数大于1则返回false。数组下标代表第i个行/列/矩形。
 * <p>
 * 值得注意的是，子矩阵的判断，如何判定某元素应该属于哪一个矩阵。对于每个元素board[i][j],可以通过index = i / 3 + (j / 3) * 3 来确定矩阵的index。
 *
 *
 * 相关问题：
 * leetcode 37题 {@link com.algorithms.leetcode.hard.Solution37}
 * leetcode 74题 {@link Solution74}
 */
public class Solution36 {
    public static void main(String[] args) {
        char[][] chars = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(new Solution36().isValidSudoku(chars));
    }

    public boolean isValidSudoku(char[][] board) {
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
    }
}
