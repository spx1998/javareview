package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 我的解法：
 * 回溯法
 */
public class Solution78 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution78().subsets(new int[]{1, 2, 3});
        lists.forEach(o -> {
            o.forEach(System.out::print);
            System.out.println();
        });
    }

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        dfs(0, nums, new ArrayList<>(), lists, true);
        return lists;
    }

    private void dfs(int n, int[] nums, ArrayList<Integer> list, ArrayList<List<Integer>> lists, boolean bl) {
        if (bl) {
            lists.add(new ArrayList<>(list));
        }
        if (n == nums.length) {
            return;
        }
        list.add(nums[n]);
        dfs(n + 1, nums, list, lists, true);
        list.remove(list.size() - 1);
        dfs(n + 1, nums, list, lists, false);
    }
}
