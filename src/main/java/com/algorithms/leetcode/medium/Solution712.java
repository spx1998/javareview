package com.algorithms.leetcode.medium;

/**
 * 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
 * 示例 1:
 * 输入: s1 = "sea", s2 = "eat"
 * 输出: 231
 * 解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
 * 在 "eat" 中删除 "t" 并将 116 加入总和。
 * 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
 * 示例2:
 * 输入: s1 = "delete", s2 = "leet"
 * 输出: 403
 * 解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
 * 将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
 * 结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
 * 如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
 * 解法：
 * DP，状态转移方程完全如同583题，但是dp数组中记录的值不是当前的最大字符数，而是最大字符数对应的最大ascii码和。
 * <p>
 * {@link Solution583}
 * {@link Solution1143}
 *
 */
public class Solution712 {
    public static void main(String[] args) {
        System.out.println(new Solution712().minimumDeleteSum("sea", "eat"));
    }

    public int minimumDeleteSum(String s1, String s2) {
        int[][] temp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    temp[i][j] = temp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    temp[i][j] = Math.max(temp[i][j - 1], temp[i - 1][j]);
                }
            }
        }
        int res = 0;
        for (char c : s1.toCharArray()) {
            res += c;
        }
        for (char c : s2.toCharArray()) {
            res += c;
        }
        return res - 2 * temp[s1.length()][s2.length()];
    }
}
