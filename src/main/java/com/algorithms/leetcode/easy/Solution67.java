package com.algorithms.leetcode.easy;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字1和0。
 * 示例1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 提示：
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零
 * 我的解法：
 * 模拟加法即可。
 */
public class Solution67 {
    public String addBinary(String a, String b) {
        char[] arrA = (a.length() >= b.length() ? a : b).toCharArray();
        char[] arrB = (a.length() < b.length() ? a : b).toCharArray();
        int m = arrA.length - 1;
        int n = arrB.length - 1;
        int add = 0;
        for (int i = 0; i < arrA.length; i++) {
            if (i <= n) {
                int temp = add + arrA[m - i] + arrB[n - i] - 48 - 48;
                add = 0;
                switch (temp) {
                    case 0:
                        arrA[m - i] = '0';
                        break;
                    case 1:
                        arrA[m - i] = '1';
                        break;
                    case 2:
                        add = 1;
                        arrA[m - i] = '0';
                        break;
                    case 3:
                        add = 1;
                        arrA[m - i] = '1';
                        break;
                    default:
                }
            } else {
                if (add == 1) {
                    int temp = add + arrA[m - i] - 48;
                    switch (temp) {
                        case 1:
                            arrA[m - i] = '1';
                            add = 0;
                            break;
                        case 2:
                            add = 1;
                            arrA[m - i] = '0';
                            break;
                        default:
                    }
                } else {
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (add == 1) {
            sb.append("1");
        }
        for (char c : arrA) {
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * str长度太长时报错。
     */
    public String addBinary2(String a, String b) {
        return Long.toBinaryString(Long.parseLong(a, 2) + Long.parseLong(b, 2));
    }
}