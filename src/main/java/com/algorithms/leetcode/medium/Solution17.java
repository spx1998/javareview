package com.algorithms.leetcode.medium;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 1   2 abc 3 def
 * 4 ghi  5 jkl 6 mno
 * 7 pqrs 8tuv  9wwxyz
 * <p>
 * 我的解法：
 */
public class Solution17 {
    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        list.add('c');
        list.add('d');
        Character[] chars = list.toArray(new Character[0]);
        System.out.println(chars);
    }
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, List<Character>> hashMap = new HashMap<>();
        hashMap.put(2, new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        hashMap.put(3, new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        hashMap.put(4, new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        hashMap.put(5, new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        hashMap.put(6, new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        hashMap.put(7, new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        hashMap.put(8, new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        hashMap.put(9, new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
        char[] chars = digits.toCharArray();
        List<List<Character>> charsList = new ArrayList<>();
        for (char aChar : chars) {
            charsList = addLetter(charsList, aChar - 48, hashMap);
        }
        List<String> stringList = new ArrayList<>();
        for (List<Character> l : charsList) {
            Character[] cs = l.toArray(new Character[0]);
            char[] chars1 = new char[cs.length];
            for(int i=0;i<cs.length;i++){
                chars1[i] = cs[i];
            }
            stringList.add(String.valueOf(chars1));
        }
        return stringList;
    }

    private List<List<Character>> addLetter(List<List<Character>> charsList, int i, HashMap<Integer, List<Character>> hashMap) {
        List<List<Character>> newList = new ArrayList<>();
        if (charsList.isEmpty()) {
            for (char c : hashMap.get(i)) {
                newList.add(new ArrayList<>());
                newList.get(newList.size() - 1).add(c);

            }
        } else {
            for (List<Character> list : charsList) {
                for (char c : hashMap.get(i)) {
                    newList.add(new ArrayList<>(list));
                    newList.get(newList.size() - 1).add(c);
                }
            }

        }
        return newList;
    }
}
