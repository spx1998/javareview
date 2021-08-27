package com.algorithms.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class _22GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(n, n, result, new StringBuilder());
        return result;
    }

    private void backTrack(int left, int right, List<String> result, StringBuilder str) {
        if (left == 0 && right == 0) {
            result.add(str.toString());
            return;
        }
        if (left > 0) {
            backTrack(left - 1, right, result, str.append('('));
            str.deleteCharAt(str.length() - 1);
        }
        if (left < right && right > 0) {
            backTrack(left, right - 1, result, str.append(')'));
            str.deleteCharAt(str.length() - 1);
        }
    }
}
