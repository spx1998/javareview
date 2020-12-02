package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 * 示例:
 * 输入:"aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * <p>
 * 我的解法：
 * 包含s的[0,i]个字符的子串可拆解为的回文子串的列表由包含[0,i-1]个字符的子串可拆解为的回文子串的列表推导得到。
 * 其中又只有每个列表的最后一个子字符串决定能否推导而来。如果最后一个字符串新增i处的字符，是回文，则原有列表新增一种可能。
 * 遍历完成判断结果集中每个列表的最后一个字符串是否是回文，不是则剔除。
 * <p>
 * 回溯解法：
 * 先利用第五题的做法，DP得到所有的子串是否是回文串，然后回溯遍历所有可能的划分结果，将所有子串都是回文的划分方式加入结果集。
 */
public class Solution131 {

    public List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return lists;
        }
        List<String> list = new ArrayList<>();
        list.add(s.substring(0, 1));
        lists.add(list);
        for (int i = 1; i < s.length(); i++) {
            List<List<String>> newLists = new ArrayList<>();
            for (List<String> strings : lists) {
                String lastStr = strings.get(strings.size() - 1);
                if (isPalindromic(lastStr)) {
                    ArrayList<String> arrayList = new ArrayList<>(strings);
                    arrayList.add(String.valueOf(s.charAt(i)));
                    newLists.add(arrayList);
                }
                ArrayList<String> arrayList = new ArrayList<>(strings);
                arrayList.set(arrayList.size() - 1, arrayList.get(arrayList.size() - 1) + s.charAt(i));
                newLists.add(arrayList);
            }
            lists = newLists;
        }

        Iterator<List<String>> iterator = lists.iterator();
        while (iterator.hasNext()) {
            for (String str : iterator.next()) {
                if (!isPalindromic(str)) {
                    iterator.remove();
                    break;
                }
            }
        }
        return lists;
    }

    private boolean isPalindromic(String str) {
        return new StringBuffer(str).reverse().toString().equals(str);
    }

    /**
     * 回溯解法
     */
    public List<List<String>> partition2(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int l = 0; l < length; l++) {
            for (int i = 0; i < length - l; i++) {
                int j = i + l;
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (l == 1) {
                        dp[i][j] = b;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] && b;
                    }
                }
            }
        }
        List<List<String>> lists = new ArrayList<>();
        backtracking(s, 0, length, new ArrayList<>(), dp, lists);
        lists.sort(Comparator.comparingInt(List::size));
        return lists;
    }

    private void backtracking(String s, int start, int length, ArrayList<String> list, boolean[][] dp, List<List<String>> lists) {
        if (start == length) {
            lists.add(new ArrayList<>(list));
        }
        for (int i = start; i < length; i++) {
            if (dp[start][i]) {
                list.add(s.substring(start, i + 1));
                backtracking(s, i + 1, length, list, dp, lists);
                list.remove(list.size() - 1);
            }
        }
    }

}
