package com.algorithms.leetcode.easy;

import java.util.Arrays;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 * 相关问题：
 * leetcode 168题 {@link Solution168}
 */
public class Solution171 {
    public static void main(String[] args) {
        System.out.println(new Solution171().titleToNumber("Z"));
        System.out.println(new Solution171().titleToNumber("AA"));
        System.out.println(new Solution171().titleToNumber("ZY"));
    }

    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        int temp = 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            res += temp * (chars[i] - 'A' + 1);
            temp *= 26;
        }
        return res;
    }
}
