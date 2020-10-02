package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例:
 * 输入:n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 我的解法：
 * 回溯法
 * 优化：
 * 剪枝
 */
public class Solution77 {
    public static void main(String[] args) {
        new Solution77().combine(4, 2);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(1, n, k, new ArrayList<>(), lists);
        return lists;
    }

    private void dfs(int i, int n, int k, ArrayList<Integer> list, List<List<Integer>> lists) {
        if (list.size() == k) {
            lists.add(new ArrayList<>(list));
            return;
        }
        if (k - list.size() > n - i+1) {
            return;
        }
        if (i <= n) {
            list.add(i);
            dfs(i + 1, n, k, list, lists);
            list.remove(list.size() - 1);
            dfs(i + 1, n, k, list, lists);
        }
    }
}
