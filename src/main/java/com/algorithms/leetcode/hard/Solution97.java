package com.algorithms.leetcode.hard;

/**
 * 给定三个字符串s1、s2、s3，请你帮忙验证s3是否是由s1和s2 交错 组成的。
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 提示：a + b 意味着字符串 a 和 b 连接。
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出：true
 * 示例 2：
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出：false
 * 示例 3：
 * 输入：s1 = "", s2 = "", s3 = ""
 * 输出：true
 * 提示：
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1、s2、和 s3 都由小写英文字母组成
 * 解法1：
 * 递归 超时
 * 解法2：
 * dp
 */
public class Solution97 {
    public static void main(String[] args) {
        System.out.println(new Solution97().isInterleave2("ab",
                "c",
                "acb"));
    }

    /**
     * 递归
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return isInterleave(0, 0, 0, s1, s2, s3);

    }

    private boolean isInterleave(int cur1, int cur2, int cur3, String s1, String s2, String s3) {
        if (cur3 == s3.length()) {
            return true;
        }
        boolean b1 = false, b2 = false;
        if (cur1 < s1.length() && s1.charAt(cur1) == s3.charAt(cur3)) {
            b1 = isInterleave(cur1 + 1, cur2, cur3 + 1, s1, s2, s3);
        }
        if (cur2 < s2.length() && s2.charAt(cur2) == s3.charAt(cur3)) {
            b2 = isInterleave(cur1, cur2 + 1, cur3 + 1, s1, s2, s3);
        }
        return b1 || b2;
    }

    /**
     * dp
     */
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i < dp[0].length; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int cur = i + j - 1;
                boolean b1 = false, b2 = false;
                if (s1.charAt(i - 1) == s3.charAt(cur)) {
                    b1 = dp[i - 1][j];
                }
                if (s2.charAt(j - 1) == s3.charAt(cur)) {
                    b2 = dp[i][j - 1];
                }
                dp[i][j] = b1 || b2;
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    /**
     * dp的优化写法
     */
    public boolean booleaninInterleave3(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();
        if (n + m != t) {
            return false;
        }
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return f[n][m];
    }
}
