package com.algorithms.leetcode.medium;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数dividend除以除数 divisor得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 提示：
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31, 2^31− 1]。本题中，如果除法结果溢出，则返回 2^31− 1。
 * 我的解法：暴力解法，除法可以看作多次进行的减法。即减去divisor次1，结果加1。需要考虑界限问题。而且当dividend很大时会超时。
 * 优化的解法：假设dividend是100，divisor是3，当dividend-divisor是正数的时候，将divisor*2（divisor+divisor），再进行比较，直到divisor*2（此时divisor=96）>dividend的时候，
 * dividend减此时的divisor，再将新的dividend（4）与最初的divisor（3）重复上面的操作。
 */
public class Solution29 {
    public static void main(String[] args) {
        System.out.println(new Solution29().divide(-2147483648, -1));
    }

    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend ^ divisor) >>> 31 == 1) {
            sign = -1;
        }
        long res;
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        res = div(a, b);
        if (sign == -1) {
            res = 0 - res;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) res;

    }

    private long div(long a, long b) {
        if (a < b) return 0;
        long count = 1;
        long tb = b;
        while ((tb + tb) <= a) {
            count = count << 1;
            tb = tb << 1;
        }
        return count + div(a - tb, b);
    }

}
