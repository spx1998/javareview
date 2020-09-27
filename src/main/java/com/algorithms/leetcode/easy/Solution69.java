package com.algorithms.leetcode.easy;

/**
 * 实现int sqrt(int x)函数。
 * 计算并返回x的平方根，其中x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 示例 1:
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 * 我的解法：
 * <p>
 * 二分查找：
 * 应该用二分查找。也要注意溢出的情况，所以用long。
 * <p>
 * 牛顿迭代：
 */
public class Solution69 {
    public static void main(String[] args) {
        System.out.println(new Solution69().mySqrtErr(
                2147395599));
    }

    /**
     * 我的解法
     */
    public int mySqrtErr(int x) {
        long res = 0;
        long temp = 1;
        while ((res + temp) * (res + temp) <= x) {
            temp = temp * 2;
            if ((res + temp) * (res + temp) > x) {
                res += temp / 2;
                temp = 1;
            }
        }
        return (int) res;
    }

    /**
     * 二分查找
     */
    public int mySqrt(int x) {
        long head = 1;
        long tail = x;
        while (head <= tail) {
            long temp = head + (tail - head) / 2;
            if (temp * temp == x) {
                return (int) temp;
            } else if (temp * temp < x) {
                head = temp + 1;
            } else {
                tail = temp - 1;
            }
        }
        return (int) tail;
    }


}
