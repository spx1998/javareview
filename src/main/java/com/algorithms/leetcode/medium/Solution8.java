package com.algorithms.leetcode.medium;

/**
 * 请你来实现一个atoi函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 * 提示：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为[−231, 231− 1]。如果数值超过这个范围，请返回 INT_MAX (231− 1) 或INT_MIN (−231) 。
 *
 * 我的解法：遍历
 * 注意考虑各种边界
 */
public class Solution8 {
    public static void main(String[] args) {
        new Solution8().myAtoi("42");
    }

    public int myAtoi(String str) {
        str = str.trim();
        char[] chars = str.toCharArray();
        long l = 0;
        boolean temp = false;
        for (int i = 0; i < chars.length; i++) {
            if (i == 0 && (chars[i] == '-' || chars[i] == '+')) {
                if (chars[i] == '-') {
                    temp = true;
                }
                continue;
            }
            if ((chars[i] >= '0' && chars[i] <= '9')) {
                if (temp) {
                    l = l * 10 - chars[i] + 48;
                } else {
                    l = l * 10 + chars[i] - 48;

                }
                if (l >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (l <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }

            } else {
                break;
            }
        }
        return Integer.parseInt(String.valueOf(l));
    }
}
