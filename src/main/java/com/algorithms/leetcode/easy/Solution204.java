package com.algorithms.leetcode.easy;

/**
 * 统计所有小于非负整数n的质数的数量。
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 * 输入：n = 1
 * 输出：0
 * 提示：
 * 0 <= n <= 5 * 10^6
 * 解法1：
 * 暴力，超时
 * 解法2：
 * 埃氏筛：用一个数组标记[2,n)是否是质数，初始设为0，表示质数。
 * 从前向后遍历，如果i是质数则2i，3i，4i……都是合数，在数组中将他们设为1，表示合数。
 * 如果是i是合数则直接跳过（c = a*b，那么e = c*d = a*b*d，一定已经在之前的遍历中对c赋值过1，不必再赋一次）。
 * 最终，统计数组中0的个数即所得。
 * 优化：i的倍数不必从2i开始，直接从i*i开始。因为i*j（j<i）一定在遍历到j时赋值过了。
 */
public class Solution204 {
    public static void main(String[] args) {
        System.out.println(new Solution204().countPrimes(10));
    }

    //    超时
    public int countPrimes0(int n) {
        int result = 0;
        for (int i = 2; i <= n; i++) {
            int j = 2;
            for (; j <= i / 2; j++) {
                if (i % j == 0) {
                    break;
                }
            }
            if (j == i / 2 + 1) {
                result++;
            }
        }
        return result;
    }

    //    埃氏筛
    public int countPrimes(int n) {
        int[] ints = new int[n + 1];
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (ints[i] == 0) {
                result++;
                if ((long) i * i < n) {
                    int j = i;
                    while (i * j < n) {
                        ints[i * j] = 1;
                        j++;
                    }
                }
            }
        }
        return result;
    }
}
