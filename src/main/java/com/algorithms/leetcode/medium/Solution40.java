package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * <p>
 * candidates中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 我的解法：回溯
 * 优化：代码中
 * 相关问题：
 * leetcode 39题 {@link Solution39}
 */
public class Solution40 {
    public static void main(String[] args) {
        new Solution40().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }

    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        doSomething(candidates, 0, target, list);
        return resultList;
    }

    private void doSomething(int[] candidates, int index, int target, List<Integer> list) {
        if (target == 0) {

            resultList.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            /**
             * i >index 保证不是第一个元素
             * candidates[i]==candidates[i-1]剪枝
             * 如题例中有
             *  1-2-2 和
             *    1
             *   / \
             *  2   2
             *  两种可能，i>Index保证不会剪去第一种可能，candidates[i]==candidates[i-1]减去第二种可能。
             */

            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                return;
            }
            list.add(candidates[i]);
            doSomething(candidates, i + 1, target - candidates[i], list);
            list.remove(list.size() - 1);
        }
    }
}
