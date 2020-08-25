package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * num1和num2的长度小于110。
 * num1 和num2 只包含数字0-9。
 * num1 和num2均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *
 * 相关问题：
 * leetcode 415题 {@link com.algorithms.leetcode.easy.Solution415}
 */
public class Solution42 {
    public static void main(String[] args) {
        System.out.println(new Solution42().multiply("93553535314",
                "25247452591474"));
    }

    public String multiply(String num1, String num2) {
        List<StringBuilder> stringBuilders = new ArrayList<>();
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int i = 0;
        while (i < num1.length()) {
            i += 4;
            String s1;
            if (i <= num1.length()) {
                s1 = num1.substring(num1.length() - i, num1.length() - i + 4);
            } else {
                s1 = num1.substring(0, num1.length() - i + 4);
            }
            int j = 0;
            while (j < num2.length()) {
                j += 4;
                String s2;
                if (j <= num2.length()) {
                    s2 = num2.substring(num2.length() - j, num2.length() - j + 4);
                } else {
                    s2 = num2.substring(0, num2.length() - j + 4);
                }
                int sum = Integer.parseInt(s1) * Integer.parseInt(s2);
                stringBuilders.add(new StringBuilder(sum + String.join("", Collections.nCopies(i + j - 8, "0"))));
            }
        }
        StringBuilder result = new StringBuilder("0");
        for (StringBuilder stringBuilder : stringBuilders) {
            result =new StringBuilder( addStrings(String.valueOf(result), String.valueOf(stringBuilder)));
        }
        return String.valueOf(result);
    }

    private String addStrings(String num1, String num2) {
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
