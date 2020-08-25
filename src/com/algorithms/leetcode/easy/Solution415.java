package com.algorithms.leetcode.easy;

import java.util.Collections;

/**
 * 给定两个字符串形式的非负整数num1 和num2，计算它们的和。
 * 提示：
 * num1 和num2的长度都小于 5100
 * num1 和num2 都只包含数字0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库，也不能直接将输入的字符串转换为整数形式
 */
public class Solution415 {
    public static void main(String[] args) {
        System.out.println(new Solution415().addStrings("1", "300"));
    }

    public String addStrings(String num1, String num2) {
        int l = Math.max(num1.length(), num2.length());
        int temp = 0;
        StringBuilder res = new StringBuilder();
        int add = 0;
        for (; l > 0; l--) {
            temp++;
            int i = num1.length() >= temp ? num1.charAt(num1.length() - temp) - 48 : 0;
            int j = num2.length() >= temp ? num2.charAt(num2.length() - temp) - 48 : 0;
            res.append((i + j + add) % 10);
            if (i + j + add >= 10) {
                add = 1;
            } else {
                add = 0;
            }
        }
        if (add == 1) {
            res.append(1);
        }
        return String.valueOf(res.reverse());
    }
}
