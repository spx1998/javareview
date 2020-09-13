package com.algorithms.leetcode.medium;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 给出集合[1,2,3,…,n]，其所有元素共有n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定n 和k，返回第k个排列。
 * 说明：
 * 给定 n的范围是 [1, 9]。
 * 给定 k的范围是[1, n!]。
 * 示例1:
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例2:
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * 我的解法：
 * 数学的解法，值得注意的是将k-1再运算，可以省去很多麻烦。
 */
public class Solution60 {
    public static void main(String[] args) {
        System.out.println(new Solution60().getPermutation(4, 9));
    }

    public String getPermutation(int n, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> integerList = IntStream.range(1, n + 1).boxed().collect(Collectors.toList());
        while (n > 0) {
            int temp = factorial(n - 1);
            stringBuilder.append(integerList.remove((k - 1) / temp));
            k = (k - 1) % temp + 1;
            n--;
        }
        return String.valueOf(stringBuilder);
    }

    private int factorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

}
