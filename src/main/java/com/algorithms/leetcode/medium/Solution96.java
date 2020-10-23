package com.algorithms.leetcode.medium;

/**
 * 给定一个整数 n，求以1 ...n为节点组成的二叉搜索树有多少种？
 * 示例:
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * *   1         3     3      2      1
 * *    \       /     /      / \      \
 * *     3     2     1      1   3      2
 * *    /     /       \                 \
 * *   2     1         2                 3
 * <p>
 * 我的解法：
 * 规律：对于n，1-n的每个值作为根节点， 可以拆解为左右两侧分别为n=i和n=n-i-1 ，它们的积就是以i+1为根节点的二叉搜索树的个数（0<=i<n-1）。
 * 这些积的和即所得。
 *
 * 相似问题：
 * leetcode 95 {@link Solution95}
 */
public class Solution96 {
    public static void main(String[] args) {
        System.out.println(new Solution96().numTrees(1));
    }

    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
