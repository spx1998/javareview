package com.algorithms.leetcode.medium;

/**
 * 给你四个整数：n 、a 、b 、c ，请你设计一个算法来找出第 n 个丑数。
 * <p>
 * 丑数是可以被 a 或 b 或 c 整除的 正整数 。
 */
public class Solution1201 {
    public static void main(String[] args) {
        int i = new Solution1201().nthUglyNumber(5, 2, 11, 13);
        System.out.println(i);
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        int res = 0;
        int p1 = 1, p2 = 1, p3 = 1;
        for (int i = 0; i < n; i++) {
            int num1 = p1 * a, num2 = p2 * b, num3 = p3 * c;
            res = Math.min(num1, Math.min(num2, num3));
            if (res == num1) {
                p1++;
            }
            if (res == num2) {
                p2++;
            }
            if (res == num3) {
                p3++;
            }
        }
        return res;
    }
}
