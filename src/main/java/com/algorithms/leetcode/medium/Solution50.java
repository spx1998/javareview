package com.algorithms.leetcode.medium;

/**
 * 实现pow(x, n)，即计算 x 的 n 次幂函数。
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * -100.0 <x< 100.0
 * n是 32 位有符号整数，其数值范围是[−231,231− 1] 。
 * <p>
 * 我的解法：超时，与快速幂算法的迭代实现类似，但是从大向下，且没有记录中间的值，导致相同的值被算了很多次。例如：
 * 2^15 -> 2^8 * 2^4 * 2^2 * 2^1
 * 2^15 -> 2*1 * 2^2 * 2^4 * 2^8
 * 第二种分解方式可以将前项的结果作为后项的中间值。且
 * 1 2 4 8 是15的二进制表示 1111 各位的值。
 * 2^ 10 -> 2^1 * 2^8 ->  1010
 * 快速幂算法：有迭代和递归两种实现方式。
 *
 * 相似问题：
 * leetcode 29题 {@link Solution29}
 */
public class Solution50 {
    public static void main(String[] args) {
        System.out.println(new Solution50().myPow(2, 11));
    }

    /**
     * 我的解法
     */
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        double res = 1;
        int count = Math.abs(n);
        int temp = 1;
        while (temp * 2 <= count) {
            double midResult = x;
            while (temp * 2 <= count) {
                midResult *= midResult;
                temp *= 2;
            }
            res *= midResult;
            count -= temp;
            temp = 1;
        }
        if (count == 1) {
            res *= x;
        }
        return n > 0 ? res : 1 / res;
    }

    /**
     * 快速幂算法的递归实现
     */
    public double myPow2(double x, int n) {
        //因为要取负值，所以要转换为long类型，否则当n = Integer.MIN_VALUE的时候会溢出。
        long l = n;
        return n >= 0 ? doSomething(x, l) : 1 / doSomething(x, -l);
    }

    private double doSomething(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double y = doSomething(x, n / 2);
        return n % 2 == 1 ? y * y * x : y * y;
    }


    /**
     * 快速幂算法的迭代实现
     */
    public double myPow3(double x, int n) {
        if (n == 0) {
            return 1;
        }
        long l = Math.abs((long)n);
        double result = 1;
        double temp = x;
        while (l > 0) {
            if (l % 2 == 1) {
                result *= temp;
            }
            temp *= temp;
            l = l >> 1;
        }
        return n >= 0 ? result : 1 / result;
    }

}
