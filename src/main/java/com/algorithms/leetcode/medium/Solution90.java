package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * <p>
 * 我的解法：
 * 回溯法
 * 相关问题：
 * leetcode 78题 {@link Solution78}
 */
public class Solution90 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution90().subsetsWithDup(new int[]{0});
        lists.forEach(o -> {
            o.forEach(System.out::print);
            System.out.println();
        });
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), lists);
        return lists;
    }

    private void dfs(int[] nums, int index, ArrayList<Integer> list, List<List<Integer>> lists) {
        if (index >= nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        if (index == nums.length - 1 || nums[index] != nums[index + 1]) {
            dfs(nums, index + 1, list, lists);
            list.add(nums[index]);
            dfs(nums, index + 1, list, lists);
            list.remove(list.size() - 1);
        } else {
            int temp = 0;
            while (index + temp + 1 < nums.length && nums[index + temp] == nums[index + temp + 1]) {
                temp++;
            }
            for (int i = 0; i <= temp + 1; i++) {
                dfs(nums, index + temp + 1, list, lists);
                list.add(nums[index]);
            }
            for (int i = 0; i <= temp + 1; i++) {
                list.remove(list.size() - 1);
            }
        }

    }
}
