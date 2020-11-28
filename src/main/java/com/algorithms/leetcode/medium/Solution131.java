package com.algorithms.leetcode.medium;

import java.util.ArrayList;
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
}
