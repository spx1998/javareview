package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * 我的解法：回溯法
 * 优化：用遍历的list本身来记录已经遍历过的值：将遍历过的值交换到当前位置前，未遍历的值交换到之后。
 *
 * 相关问题：
 * leetcode 47题 {@link Solution47}
 */
public class Solution46 {
    //    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> lists = new ArrayList<>();
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            map.put(num, 1);
//        }
//        doSomething(map, new ArrayList<>(), lists);
//        return lists;
//    }
//
//    private void doSomething(Map<Integer, Integer> map, ArrayList<Integer> integers, List<List<Integer>> lists) {
//        boolean temp = true;
//        for (Integer key : map.keySet()) {
//            if (map.get(key) == 1) {
//                map.put(key, 0);
//                integers.add(key);
//                doSomething(map, integers, lists);
//                map.put(key, 1);
//                integers.remove(key);
//                temp = false;
//            }
//        }
//        if (temp) {
//            lists.add(new ArrayList<>(integers));
//        }
//    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }
        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;

    }

    private void backtrack(int n, ArrayList<Integer> output, List<List<Integer>> res, int i) {
        if (i == n) {
            res.add(new ArrayList<>(output));
            return;
        }
        for (int j = i; j < n; j++) {
            Collections.swap(output, i, j);
            backtrack(n, output, res, i + 1);
            Collections.swap(output, i, j);
        }
    }
}
