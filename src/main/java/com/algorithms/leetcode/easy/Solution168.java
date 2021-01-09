package com.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * 例如，
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * 示例 1:
 * 输入: 1
 * 输出: "A"
 * 示例2:
 * 输入: 28
 * 输出: "AB"
 * 示例3:
 * 输入: 701
 * 输出: "ZY"
 */
public class Solution168 {
    public static void main(String[] args) {
        System.out.println(new Solution168().convertToTitle(52));
        System.out.println(new Solution168().convertToTitle(28));
        System.out.println(new Solution168().convertToTitle(701));
    }

    public String convertToTitle(int n) {
        if (n < 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add(n % 26);
            n = n / 26;
        }
        Collections.reverse(list);
        list.forEach(System.out::println);
        return stringBuilder.reverse().toString();
    }
}
