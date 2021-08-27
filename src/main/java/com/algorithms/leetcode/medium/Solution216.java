package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为n 的k个数的组合。组合中只允许含有 1 -9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解法：DFS回溯
 *
 * 相关问题：
 * leetcode第39题 {@link Solution39}
 * leetcode第40题 {@link Solution40}
 * leetcode第77题 {@link Solution77}
 * leetcode第216题 {@link Solution216}
 */
public class Solution216 {

    List<List<Integer>> lists;

    public List<List<Integer>> combinationSum3(int k, int n) {
        lists = new ArrayList<>();
        DFS(new ArrayList<>(), n, k, 0, 1);
        return lists;
    }

    private void DFS(List<Integer> list, int n, int k, int sum, int i) {
        if (list.size() == k && sum == n) {
            lists.add(new ArrayList<>(list));
            return;
        }
        if (list.size() == k || sum > n || i > 9) {
            return;
        }
        list.add(i);
        DFS(list, n, k, sum + i, i + 1);
        list.remove(list.size() - 1);
        DFS(list, n, k, sum, i + 1);
    }
}
