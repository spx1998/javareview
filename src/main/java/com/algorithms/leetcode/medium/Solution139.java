package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 我的解法1：
 * 暴力法(BFS)。超时 时间复杂度为O(n^3)
 *
 * 我的解法2：
 * DP，时间复杂度为O(n^2)
 *
 * 相关问题：
 * leetcode 第132题 {@link com.algorithms.leetcode.hard.Solution132}
 * leetcode 第140题 {@link com.algorithms.leetcode.hard.Solution140}
 */
public class Solution139 {
    public static void main(String[] args) {
        boolean b = new Solution139().wordBreak2("leetcode", Arrays.asList("leet", "code"));
        System.out.println(b);
    }

    /**
     * 暴力法，超时
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        List<Integer> newList;
        while (!list.isEmpty()) {
            newList = new ArrayList<>();
            for (String str : wordDict) {
                for (Integer i : list) {
                    if (i + str.length() <= s.length()) {
                        if (s.startsWith(str, i)) {
                            if (i + str.length() == s.length()) {
                                return true;
                            }
                            newList.add(i + str.length());
                        }
                    }
                }
            }
            list = newList;
        }
        return false;
    }

    /**
     * DP解法
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (String str : wordDict) {
                if (i - str.length() >= 0 && s.startsWith(str, i - str.length()) && dp[i - str.length()]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
