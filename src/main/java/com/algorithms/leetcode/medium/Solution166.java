package com.algorithms.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数，分别表示分数的分子numerator 和分母 denominator，以 字符串形式返回小数 。
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * 如果存在多个答案，只需返回 任意一个 。
 * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
 * 示例 1：
 * 输入：numerator = 1, denominator = 2
 * 输出："0.5"
 * 示例 2：
 * 输入：numerator = 2, denominator = 1
 * 输出："2"
 * 示例 3：
 * 输入：numerator = 2, denominator = 3
 * 输出："0.(6)"
 * 示例 4：
 * 输入：numerator = 4, denominator = 333
 * 输出："0.(012)"
 * 示例 5：
 * 输入：numerator = 1, denominator = 5
 * 输出："0.2"
 * 提示：
 * -2^31 <=numerator, denominator <= 2^31 - 1
 * denominator != 0
 * 我的解法：
 * 模拟除法运算的过程。
 */
public class Solution166 {
    public static void main(String[] args) {
        System.out.println(new Solution166().fractionToDecimal(7, -12));

    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (Math.abs(denominator) == 1) {
            return "" + (long) numerator * denominator;
        }
        StringBuilder res = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            res.append("-");
        }
        long nL = Math.abs((long) numerator);
        long dL = Math.abs((long) denominator);
        long integer = nL / dL;
        res.append(integer);
        nL = nL % dL;
        if (nL == 0L) {
            return res.toString();
        }
        res.append(".");
        int length = res.length();
        Map<String, Integer> map = new HashMap<>();
        int digit = 0;
        while (true) {
            digit++;
            nL *= 10;
            integer = nL / dL;
            nL = nL % dL;
            res.append(integer);
            if (nL == 0L) {
                return res.toString();
            }
            String s = integer + "-" + nL;
            if (map.containsKey(s)) {
                res.deleteCharAt(res.length() - 1);
                Integer start = map.get(s);
                res.insert(length + start - 1, "(");
                res.append(")");
                return res.toString();
            }
            map.put(s, digit);
        }
    }
}
