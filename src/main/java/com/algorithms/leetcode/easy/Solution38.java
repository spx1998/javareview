package com.algorithms.leetcode.easy;

/**
 * 给定一个正整数 n（1 ≤n≤ 30），输出外观数列的第 n 项。
 * 注意：整数序列中的每一项将表示为一个字符串。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * <p>
 * 6.     312211
 * 7.     13112221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
 * 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
 * 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
 * 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
 * 我的解法：迭代 从n=1，依次推算到n。
 * 其他解法：递归 似乎比迭代快？
 */
public class Solution38 {
    public String countAndSay(int n) {
        if (n == 0) return "";
        if (n == 1) return "1";
        StringBuilder s = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 0; j < s.length(); j++) {
                if (j != s.length() - 1) {
                    if (s.charAt(j) == s.charAt(j + 1)) {
                        count++;
                    } else {
                        sb.append(count).append(s.charAt(j));
                        count = 1;

                    }
                } else {
                    sb.append(count).append(s.charAt(j));
                }
            }
            s = sb;
        }
        return String.valueOf(s);
    }
}
