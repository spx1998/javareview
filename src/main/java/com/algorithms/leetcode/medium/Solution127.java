package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 给定两个单词（beginWord和 endWord）和一个字典，找到从beginWord 到endWord 的最短转换序列的长度。转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例1:
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出: 5
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 输出:0
 * 解释:endWord "cog" 不在字典中，所以无法进行转换。
 *
 * 我的解法：
 * BFS
 */
public class Solution127 {
    public static void main(String[] args) {
        String a = "hot";
        String b = "dog";
        List<String> strings = Arrays.asList("hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot");
        System.out.println(new Solution127().ladderLength(a, b, strings));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList = new ArrayList<>(wordList);
        List<List<String>> processList = new ArrayList<>();
        int num = 1;
        List<String> hierarchyList = new ArrayList<>();
        hierarchyList.add(beginWord);
        while (!wordList.isEmpty()) {
            List<String> newHierarchyList = new ArrayList<>();
            Iterator<String> iterator = wordList.listIterator();
            num++;
            while (iterator.hasNext()) {
                String a = iterator.next();
                for (String b : hierarchyList) {
                    if (canTrans(a, b)) {
                        if (a.equals(endWord)) {
                            return num;
                        }
                        iterator.remove();
                        newHierarchyList.add(a);
                        break;
                    }
                }
            }
            hierarchyList = newHierarchyList;
            if (hierarchyList.isEmpty()) {
                return 0;
            }
        }
        return 0;
    }

    private boolean canTrans(String a, String b) {
        boolean diffLetter = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (diffLetter) {
                    return false;
                } else {
                    diffLetter = true;
                }
            }
        }
        return diffLetter;
    }
}
