package com.algorithms.leetcode.medium;

/**
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * 示例 1：
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * 示例 2：
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 * 提示：
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i]仅由'0' 和'1' 组成
 * 1 <= m, n <= 100
 * 二维背包，多一个限制条件即可
 */
public class Solution474 {
    public static void main(String[] args) {
        System.out.println(new Solution474().findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[] zeroNum = new int[strs.length];
        int[] oneNum = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            zeroNum[i] = count(strs[i], '0');
            oneNum[i] = count(strs[i], '1');
        }
//        注意从0开始遍历
        int[][][] dp = new int[m + 1][n + 1][strs.length + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 1; k <= strs.length; k++) {
                    dp[i][j][k] = dp[i][j][k - 1];
                    if (i - zeroNum[k - 1] >= 0 && j - oneNum[k - 1] >= 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - zeroNum[k - 1]][j - oneNum[k - 1]][k - 1] + 1);
                    }
                }
            }
        }
        return dp[m][n][strs.length];
    }

    private int count(String str, char c) {
        int res = 0;
        for (char cc : str.toCharArray()) {
            if (c == cc) {
                res++;
            }
        }
        return res;
    }
}
