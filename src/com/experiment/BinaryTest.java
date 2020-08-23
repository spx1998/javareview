package com.experiment;

/**
 * -2147483647
 * -1073741824
 * 1073741824
 * 10000000000000000000000000000001 原数字；
 * 11000000000000000000000000000000 >>是算术右移，左侧的位置用原序列的最高位补齐，对于原数字来说即1；
 * 1000000000000000000000000000000  >>>是逻辑右移，左侧的位置用0补齐。因此i>>>变成了正数1073741824（打印的字符串省略了高位的0）
 * 11 3的二进制表示
 */
public class BinaryTest {
    public static void main(String[] args) {
        int i = Integer.MIN_VALUE + 1;
        System.out.println(i);
        System.out.println(i >> 1);
        System.out.println(i >>> 1);
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(i >> 1));
        System.out.println(Integer.toBinaryString(i >>> 1));
        System.out.println(Integer.toBinaryString(3));

    }
}
