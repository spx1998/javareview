package com.algorithms.leetcode.medium;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * 我的解法：暴力解法。
 */
public class Solution12 {
    public static void main(String[] args) {
        new Solution12().intToRoman(3);
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int m = num / 1000;
        num %= 1000;
        for (int i = 0; i < m; i++) {
            sb.append("M");
        }
        int cm = num / 900;
        num %= 900;
        for (int i = 0; i < cm; i++) {
            sb.append("CM");
        }
        int d = num / 500;
        num %= 500;
        for (int i = 0; i < d; i++) {
            sb.append("D");
        }
        int cd = num / 400;
        num %= 400;
        for (int i = 0; i < cd; i++) {
            sb.append("CD");
        }
        int c = num / 100;
        num %= 100;
        for (int i = 0; i < c; i++) {
            sb.append("C");
        }
        int xc = num / 90;
        num %= 90;
        for (int i = 0; i < xc; i++) {
            sb.append("XC");
        }
        int l = num / 50;
        num %= 50;
        for (int i = 0; i < l; i++) {
            sb.append("L");
        }
        int xl = num / 40;
        num %= 40;
        for (int i = 0; i < xl; i++) {
            sb.append("XL");
        }
        int x = num / 10;
        num %= 10;
        for (int i = 0; i < x; i++) {
            sb.append("X");
        }
        int ix = num / 9;
        num %= 9;
        for (int i = 0; i < ix; i++) {
            sb.append("IX");
        }
        int v = num / 5;
        num %= 5;
        for (int i = 0; i < v; i++) {
            sb.append("V");
        }
        int iv = num / 4;
        num %= 4;
        for (int i = 0; i < iv; i++) {
            sb.append("IV");
        }
        for (int i = 0; i < num; i++) {
            sb.append("I");
        }
        return sb.toString();
    }
}
