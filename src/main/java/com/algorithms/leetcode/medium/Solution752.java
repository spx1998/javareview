package com.algorithms.leetcode.medium;

import java.util.*;

/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 * 解法：BFS
 */
public class Solution752 {
    public static void main(String[] args) {
        System.out.println(new Solution752().openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }

    /**
     * 单向BFS
     */
    public int openLock0(String[] deadends, String target) {
        Queue<String> stringQueue = new LinkedList<>();
//        deadends等价被访问过的可能
        HashSet<String> visitedSet = new HashSet<>(Arrays.asList(deadends));
        if (visitedSet.contains("0000")) {
            return -1;
        }
        stringQueue.add("0000");
        visitedSet.add("0000");

        int depth = 0;
        while (!stringQueue.isEmpty()) {
            int size = stringQueue.size();
            int i = 0;
            while (i < size) {
                i++;
                String poll = stringQueue.poll();
                if (poll.equals(target)) {
                    return depth;
                }
                for (int j = 0; j < 4; j++) {
                    String s1 = change(poll, j, true);
                    String s2 = change(poll, j, false);
                    if (!visitedSet.contains(s1)) {
                        stringQueue.offer(s1);
                        visitedSet.add(s1);
                    }
                    if (!visitedSet.contains(s2)) {
//                        当把新的元素加入queue中时，就要把它加入visitedSet
                        stringQueue.offer(s2);
                        visitedSet.add(s2);
                    }
                }
            }
            depth++;

        }
        return -1;
    }

    /**
     * 双向BFS
     */
    public int openLock(String[] deadends, String target) {
        HashSet<String> visitedSet = new HashSet<>(Arrays.asList(deadends));
        if (visitedSet.contains("0000")) {
            return -1;
        }
        HashSet<String> preSet = new HashSet<>();
        HashSet<String> postSet = new HashSet<>();
        preSet.add("0000");
        postSet.add(target);
        int depth = 0;
        int size;
        while (!preSet.isEmpty() && !postSet.isEmpty()) {
            HashSet<String> temp = new HashSet<>();
            for (String str : preSet) {
                if (postSet.contains(str)) {
                    return depth;
                }
//                    双向BDF 不能在下面加入visitedSet
                visitedSet.add(str);
                for (int j = 0; j < 4; j++) {
                    String s1 = change(str, j, true);
                    String s2 = change(str, j, false);
                    if (!visitedSet.contains(s1)) {
                        temp.add(s1);
                    }
                    if (!visitedSet.contains(s2)) {
                        temp.add(s2);
                    }
                }
            }
            preSet = postSet;
            postSet = temp;
            depth++;
        }
        return -1;
    }


    private String change(String s, int index, boolean increment) {
        StringBuilder stringBuilder = new StringBuilder(s);
        if (increment) {
            if (s.charAt(index) == '9') {
                stringBuilder.setCharAt(index, '0');

            } else {
                stringBuilder.setCharAt(index, (char) (s.charAt(index) + 1));
            }
        } else {
            if (s.charAt(index) == '0') {
                stringBuilder.setCharAt(index, '9');
            } else {
                stringBuilder.setCharAt(index, (char) (s.charAt(index) - 1));
            }
        }
        return stringBuilder.toString();
    }


}
