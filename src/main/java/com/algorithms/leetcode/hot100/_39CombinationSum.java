package com.algorithms.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括target）都是正整数。
 * 解集不能包含重复的组合。
 */
public class _39CombinationSum {
    public static void main(String[] args) {
        new _39CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), lists);
        return lists;
    }

    private void dfs(int[] candidates, int target, int index, List<Integer> list, List<List<Integer>> lists) {
        if (0 == target) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target >= candidates[i]) {
                list.add(candidates[i]);
                dfs(candidates, target - candidates[i], i, list, lists);
                list.remove(list.size() - 1);
            }
        }
    }
}
