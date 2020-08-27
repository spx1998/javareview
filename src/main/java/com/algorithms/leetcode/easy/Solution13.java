package com.algorithms.leetcode.easy;

import com.algorithms.leetcode.medium.Solution12;

/**
 * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做 XXVII, 即为XX+V+II。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1到 3999 的范围内。
 * 我的解法：暴力解法
 * 优化：hashmap 或者使用switch语句
 */
public class Solution13 {
    public static void main(String[] args) {
        System.out.println(new Solution13().romanToInt("IV"));
    }

    public int romanToInt(String s) {
        String[] strings = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] ints = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int num = 0;
        char[] chars = s.toCharArray();
        for (int i = 0, j = 0; i < chars.length; ) {
            if (String.valueOf(chars[i]).equals(strings[j])) {
                num += ints[j];
                i++;
            } else if (i < chars.length - 1 && ("" + chars[i] + chars[i + 1]).equals(strings[j])) {
                num += ints[j];
                i += 2;
                j++;
            } else {
                j++;

            }
        }
        return num;
    }
}
