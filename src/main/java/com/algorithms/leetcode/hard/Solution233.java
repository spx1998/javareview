package com.algorithms.leetcode.hard;

/**
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * 通过数学的方式找规律
 */
public class Solution233 {
    public static void main(String[] args) {
        new Solution233().countDigitOne(10);
    }

    public int countDigitOne(int n) {
        int temp = n;
        int res = 0;
        int digit = 0;
        while (temp != 0) {
            temp = temp / 10;
            digit++;
        }
        int[] count = new int[digit];
        for (int i = 1; i < digit; i++) {
            count[i] = (int) (i * Math.pow(10, i - 1));
        }

        temp = n;
        digit = 1;
        while (temp != 0) {
            int cur = temp % 10;
            if (cur == 1) {
                int t = (int) Math.pow(10, digit - 1);
                res += n - n / t * t + 1;
            } else if (cur != 0) {
                res += Math.pow(10, digit - 1);
            }
            res += cur * count[digit - 1];
            temp = temp / 10;
            digit++;
        }
        return res;
    }
}
