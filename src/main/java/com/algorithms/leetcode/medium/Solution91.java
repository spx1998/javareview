package com.algorithms.leetcode.medium;

/**
 * 一条包含字母A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 题目数据保证答案肯定是一个 32 位的整数。
 * 示例 1：
 * 输入："12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 * 输入："226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 示例 3：
 * 输入：s = "0"
 * 输出：0
 * 示例 4：
 * 输入：s = "1"
 * 输出：1
 * 示例 5：
 * 输入：s = "2"
 * 输出：1
 * 提示：
 * 1 <= s.length <= 100
 * s 只包含数字，并且可以包含前导零。
 * <p>
 * 我的解法1：
 * 回溯法，超时
 * 解法2：
 * dp，建立一个一维的dp数组dp[s.length+1],
 * 对于dp[i]，如果s.charAt(i-1)=='0',且s.charAt(i-2)==0|>'2',则无法匹配，直接返回0，否则，dp[i]=dp[i-2]；
 * 如果s.charAt(i-1)!='0',且s.charAt(i-2)==1或者s.charAt(i-1)!='0'且s.charAt(i-1)<'7'，且s.charAt(i-2)==2，dp[i]=dp[i-1]+dp[i-2].
 * dp[length-1]即所得。
 *
 * 相似问题：
 * leetcode 93 {@link Solution93}
 */
public class Solution91 {
    public static void main(String[] args) {
        System.out.println(new Solution91().numDecodings("01"));
        System.out.println(new Solution91().numDecodings2("01"));
    }

    int count;

    public int numDecodings(String s) {
        count = 0;
        int i = 0;
        for (; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                break;
            }
        }

        s = s.substring(i);
        if ("".equals(s)) {
            return count;
        }
        dfs(s, 0);
        return count;
    }

    private void dfs(String s, int index) {
        if (index >= s.length()) {
            count++;
            return;
        }
        if (s.charAt(index) != '0') {
            dfs(s, index + 1);
        }
        if (index < s.length() - 1 && ((s.charAt(index) == '1') || (s.charAt(index) == '2' && s.charAt(index + 1) < '7'))) {

            dfs(s, index + 2);
        }
    }

    /**
     * dp解法
     */
    public int numDecodings2(String s) {
        int length = s.length();
        if (!"".equals(s) && s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[length + 1];
        dp[0] = 1;
        for (int i = 1; i <= length; i++) {
            if (s.charAt(i - 1) == '0') {
                if (s.charAt(i - 2) == '0' || s.charAt(i - 2) > '2') {
                    return 0;
                }
                dp[i] = dp[i - 2];
            } else if (i > 1 && ((s.charAt(i - 2) == '1') || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7'))) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[length];
    }
}
