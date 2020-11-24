package com.algorithms.leetcode.hard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换后得到的单词必须是字典中的单词。
 * 说明:
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出:
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * 示例 2:
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 输出: []
 * 解释:endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 *
 * 解法：同127
 *
 * 相关问题：
 * leetcode 127题 {@link com.algorithms.leetcode.medium.Solution127}
 */
public class Solution126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> lists = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        List<List<String>> hierarchyList = new ArrayList<>();
        hierarchyList.add(list);
        boolean bl = true;
        while (!wordList.isEmpty() && bl) {
            List<List<String>> newHierarchyList = new ArrayList<>();
            Iterator<String> iterator = wordList.listIterator();
            while (iterator.hasNext()) {
                String a = iterator.next();
                boolean canTrans = false;
                for (List<String> strings : hierarchyList) {
                    if (canTrans(a, strings.get(strings.size() - 1))) {

                        canTrans = true;
                        ArrayList<String> arrayList = new ArrayList<>(strings);
                        arrayList.add(a);
                        newHierarchyList.add(arrayList);
                        if (a.equals(endWord)) {
//                            TODO
                            lists.add(arrayList);
                            bl = false;
                        }
                    }
                }
                if (canTrans) {
                    iterator.remove();
                }
            }
            hierarchyList = newHierarchyList;
            if (hierarchyList.isEmpty()) {
                return lists;
            }
        }
        return lists;
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
