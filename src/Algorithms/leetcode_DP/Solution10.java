package Algorithms.leetcode_DP;

/**
 * 实现简单的正则
 * 只有 . *
 */
public class Solution10 {
    public static void main(String[] args) {
        System.out.println(new Solution10().isMatch("aaa",
                "ab*ac*a"));

    }


    public boolean isMatch(String s, String p) {
        int ns = s.length() + 1, np = p.length() + 1;
        boolean[][] dp = new boolean[ns][np];
        dp[0][0] = true;
        for (int i = 0; i < ns; i++) {
            for (int j = 1; j < np; j++) {
                if (i > 0 && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1))) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    if (i == 0 || (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.')) {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                    }
                }
            }
        }
        return dp[ns - 1][np - 1];

    }
}
