package com.algorithms.leetcode.hard;

/**
 * 验证给定的字符串是否可以解释为十进制数字。
 * 例如:
 * "0"=>true
 * " 0.1 "=>true
 * "abc"=>false
 * "1 a"=>false
 * "2e10"=>true
 * " -90e3 "=>true
 * " 1e"=>false
 * "e3"=>false
 * " 6e-1"=>true
 * " 99e2.5"=>false
 * "53.5e93"=>true
 * " --6 "=>false
 * "-+3"=>false
 * "95a54e53"=>false
 * 说明:我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
 * 数字 0-9
 * 指数 - "e"
 * 正/负号 - "+"/"-"
 * 小数点 - "."
 * 当然，在输入中，这些字符的上下文也很重要。
 *
 * 解法：
 * 考虑的情况太多了  ORZ
 */
public class Solution65 {
    public static void main(String[] args) {
        System.out.println(new Solution65().isNumber(" 277707e26"));
    }

    boolean e = true;
    int status = 0;

    public boolean isNumber(String s) {
        if (s == null || s.trim().length() == 0) {
            return false;
        }
        s = s.trim();
        char[] chars = s.toCharArray();
        boolean sign = false;
        boolean dot = true;
        status++;
        if (status == 3) {
            dot = false;
        }
        for (int i = 0; i < chars.length; i++) {
            if (i == 0 && (chars[i] == '+' || chars[i] == '-')) {
                if(chars.length==1){
                    return false;
                }
                sign = true;
                continue;
            }
            if (e && i != 0 && i != chars.length - 1 && (chars[i] == 'e' || chars[i] == 'E')) {
                if (sign && i == 1) {
                    return false;
                }
                e = false;
                return isNumber(s.substring(0, i)) && isNumber(s.substring(i + 1));
            }
            if (dot && (chars.length != 1 && chars[i] == '.')) {

                if (sign && i == 1 && chars.length == 2) {
                    return false;
                }
                dot = false;
                continue;
            }
            if (chars[i] >= 48 && chars[i] < 58) {
                continue;
            }
            return false;
        }
        return true;
    }
}
