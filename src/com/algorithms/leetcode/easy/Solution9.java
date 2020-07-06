package com.algorithms.leetcode.easy;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */

public class Solution9 {
    public boolean isPalindrome(int x) {
        int a = x;
        int b = 0;
        if (x < 0)
            return false;
        while (x > 0) {
            b *= 10;
            b += x % 10;
            x = x / 10;
        }
        return a == b;
    }
}
