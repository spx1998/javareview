package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例：
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * 我的解法：
 * 回溯法
 */
public class Solution22 {
    public static void main(String[] args) {
        new Solution22().generateParenthesis(3).forEach(System.out::println);
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder("(");
        pushBracket(list, sb, 1, n - 1, n);
        return list;
    }

    private void pushBracket(List<String> list, StringBuilder sb, int cur, int l, int r) {
        if (l == 0 && r == 0) {
            if (cur == 0) {
                list.add(sb.toString());
            }
        }else {
            if (l > 0) {
                pushBracket(list, new StringBuilder(sb).append('('), cur + 1, l - 1, r);
            }
            if (r > 0) {
                if (cur <= 0) {
                    return;
                }
                pushBracket(list, new StringBuilder(sb).append(')'), cur - 1, l, r - 1);
            }
        }
    }
}
