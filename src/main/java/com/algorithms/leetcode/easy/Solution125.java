package com.algorithms.leetcode.easy;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */
public class Solution125 {
    public static void main(String[] args) {

        System.out.println(new Solution125().isPalindrome("race a car"));
        System.out.println(new Solution125().isPalindrome("ab_a"));
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int head = 0;
        int tail = s.length() - 1;
        while (head < tail) {
            char headChar = s.charAt(head);
            char tailChar = s.charAt(tail);
            if (((headChar < 'A' || headChar > 'z') || headChar > 'Z' && headChar < 'a') && !(headChar >= '0' && headChar <= '9')) {
                head++;
                continue;
            }
            if (((tailChar < 'A' || tailChar > 'z') || tailChar > 'Z' && tailChar < 'a') && !(tailChar >= '0' && tailChar <= '9')) {
                tail--;
                continue;
            }
            if (headChar == tailChar || (headChar > '9' && tailChar > '9' && Math.abs(headChar - tailChar) == 32)) {
                head++;
                tail--;
            } else {
                return false;
            }
        }
        return true;
    }
}
