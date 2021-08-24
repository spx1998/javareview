package com.algorithms.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * 丑数 就是只包含质因数2、3 和/或5的正整数。
 * 示例 1：
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8,  9, 10, 12] 是由前 10 个丑数组成的序列。
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 */
public class Solution264 {
    public static void main(String[] args) {
        new Solution264().nthUglyNumber(10);
    }

    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> q3 = new LinkedList<>();
        Queue<Integer> q5 = new LinkedList<>();
        q2.offer(2);
        q3.offer(3);
        q5.offer(5);
        int i = 1;
        int res = 1;
        while (i < n) {
            i++;
            res = Math.min(q2.peek(), Math.min(q3.peek(), q5.peek()));
            if (q2.peek() == res) {
                q2.poll();
            }
            if (q3.peek() == res) {
                q3.poll();
            }
            if (q5.peek() == res) {
                q5.poll();
            }
            q2.offer(res * 2);
            q3.offer(res * 3);
            q5.offer(res * 5);
        }
        return res;
    }
}
