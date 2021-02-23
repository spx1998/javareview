package com.algorithms.leetcode.easy;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 * 示例 1：
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 01110010111100000101001010000000
 * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 * 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 */
public class Solution190 {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("01010101010101010101010101010101", 2));
        System.out.println(Integer.toBinaryString(1431655765));
        System.out.println(Integer.toBinaryString(-715827882));

        System.out.println(new Solution190().reverseBits(1431655765));
    }

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result += n & 1;
            n = n >>> 1;
        }
        return result;
    }
}
