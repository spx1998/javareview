package com.algorithms.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * 说明：
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * 示例 2：
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例3：
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * <p>
 * 注意应该先判断能否进行拆分，相当于剪枝。
 * 解法1：
 * 回溯法
 * 解法2：
 * DP
 * 相关问题
 * leetcode 第139题 {@link com.algorithms.leetcode.medium.Solution139}
 */
public class Solution140 {
    public static void main(String[] args) {
        new Solution140().wordBreak("catsandog", Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"}.clone()));
    }

    /**
     * 回溯法 直接回溯超时，先利用139题的做法判断是否可拆解，不可直接返回结果，可拆解则进行回溯。
     * 预剪枝的思路类似 {@link com.algorithms.leetcode.medium.Solution131}
     * *              {@link Solution132}
     */
    public List<String> wordBreak0(String s, List<String> wordDict) {
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
        if (!dp[s.length()]) {
            return new ArrayList<>();
        }
        List<String> resList = new ArrayList<>();
        backTracking(0, s, new ArrayList<>(), resList, wordDict);
        return resList;
    }

    private void backTracking(int index, String s, ArrayList<String> list, List<String> resList, List<String> wordDict) {
        if (index == s.length()) {
            resList.add(String.join(" ", list));
            return;
        }
        for (int i = index; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(index, i))) {
                list.add(s.substring(index, i));
                backTracking(i, s, list, resList, wordDict);
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * DP,同样需要先判断
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        boolean[] canMakeSentence = new boolean[s.length() + 1];
        canMakeSentence[0] = true;
        for (int i = 1; i < canMakeSentence.length; i++) {
            for (String str : wordDict) {
                if (i - str.length() >= 0 && s.startsWith(str, i - str.length()) && canMakeSentence[i - str.length()]) {
                    canMakeSentence[i] = true;
                    break;
                }
            }
        }
        if (!canMakeSentence[s.length()]) {
            return new ArrayList<>();
        }
        List<List<String>>[] dp = new List[s.length() + 1];
        dp[0] = new ArrayList<>();
        dp[0].add(new ArrayList<>());
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = new ArrayList<>();
            for (String str : wordDict) {
                int start = i - str.length();
                if (start >= 0 && s.startsWith(str, start)) {
                    dp[i].addAll(
                            dp[start].stream().map(l -> {
                                List<String> newList = new ArrayList<>(l);
                                newList.add(s.substring(start, start + str.length()));
                                return newList;
                            }).collect(Collectors.toList())
                    );
                }
            }
        }
        return dp[s.length()].stream().map(list -> String.join(" ", list)).collect(Collectors.toList());
    }
}