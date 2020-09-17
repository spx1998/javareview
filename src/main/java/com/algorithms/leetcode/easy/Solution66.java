package com.algorithms.leetcode.easy;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 示例1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * 我的解法：
 * 从末位开始加一，结果为10则设为0，上一位加1。
 * 更好的解法：
 * 从末位开始加一，若当前位的结果不为10，则直接返回dights数组即可；若当前位的结果是10，则设为0，然后前一位+1。
 * 如果遍历完数组，说明结果是10，100，1000的形式，返回一个长度+1，首位为1的新数组。
 */
public class Solution66 {
    public static void main(String[] args) {
        new Solution66().plusOne(new int[]{9});
    }

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        digits[digits.length - 1] += 1;
        boolean tar = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i != 0) {
                if (digits[i] == 10) {
                    digits[i] = 0;
                    digits[i - 1] += 1;
                }
            } else if (digits[i] == 10) {
                digits[i] = 0;
                tar = true;
            }
        }
        if (tar) {
            int[] array = new int[digits.length + 1];
            System.arraycopy(digits, 0, array, 1, digits.length);
            array[0] = 1;
            digits = array;
        }

        return digits;
    }


    public int[] plusOne2(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 10) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        return digits;
    }
}
