package com.algorithms.leetcode.hard;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回符合要求的最少分割次数。
 * 示例:
 * 输入:"aab"
 * 输出: 1
 * 解释: 进行一次分割就可将s 分割成 ["aa","b"] 这样两个回文子串。
 * 解法：
 * DP,先利用{@link com.algorithms.leetcode.medium.Solution5}中的做法预处理，建立一个某个子串是否是回文的判断数组。
 * 然后，建立一维DP数组，下标为从头开始的子串的长度。dp[i]=Min(dp[i-j])+1||0，
 * 其中j属于[0,i）且s.sub(i-j,i)必须为回文，当整个子串都是回文时dp[i]=0。
 */
public class Solution132 {
    public int minCut(String s) {
//        预处理
        int length = s.length();
        boolean[][] isPalindrome = new boolean[length][length];
        for (int l = 0; l < length; l++) {
            for (int i = 0; i < length - l; i++) {
                int j = i + l;
                if (i == j) {
                    isPalindrome[i][j] = true;
                } else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (l == 1) {
                        isPalindrome[i][j] = b;
                    } else {
                        isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && b;
                    }
                }
            }
        }
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = i;
        }
        for (int i = 1; i < length; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j + 1][i]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[length - 1];
    }
}
