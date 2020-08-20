package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个无重复元素的数组candidates和一个目标数target，
 * 找出candidates中所有可以使数字和为target的组合。
 * candidates中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括target）都是正整数。
 * 解集不能包含重复的组合。
 * 提示：
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 * 我的算法：回溯 未剪枝
 * 优化：剪枝
 * 不剪枝时，例如「1，2」 tar = 4， 可能结果有1，1，2 /1，2，1/2，1，1 需要对每一个可能对结果在加入结果list前判断是否已经存在在结果列表中。
 * 剪枝 在回溯的过程中，对于每一个要加入当前list的candidate元素不允许其小于当前candidate值，不允许大于当前target值。例如：
 * <p>
 * <p>
 * *          1，1，1，2  不允许，因为2大于当前tar值1。
 * 当前tar值4，3，2，1
 * 2,1 * 是不允许的 因为<b>一定</b>会与之前的结果产生重复。
 */
public class Solution39 {
    public static void main(String[] args) {
        new Solution39().combinationSum(new int[]{1, 2}, 4);
    }

    /**
     * 不剪枝
     */
  /*  public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        doSomething(candidates, target, lists, new ArrayList<>());
        return lists;
    }

    private void doSomething(int[] candidates, int target, List<List<Integer>> lists, List<Integer> list) {
        if (target == 0) {
            Collections.sort(list);
            for (List<Integer> l : lists) {
                for (int i = 0; i < l.size(); i++) {
                    if (i >= list.size() || !list.get(i).equals(l.get(i))) {
                        break;
                    } else if (i == l.size() - 1 && l.get(i).equals(list.get(i))) {
                        return;
                    }
                }
            }
            lists.add(list);
        } else if (target > 0) {
            for (int candidate : candidates) {
                List<Integer> candidateList = new ArrayList<>(list);
                candidateList.add(candidate);
                doSomething(candidates, target - candidate, lists, candidateList);
            }
        }
    }
*/

    /**
     * 剪枝
     */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        doSomething(candidates, 0, target, lists, new ArrayList<>());
        return lists;
    }

    private void doSomething(int[] candidates, int index, int target, List<List<Integer>> lists, List<Integer> list) {
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;
            }
            list.add(candidates[i]);
            doSomething(candidates, i, target - candidates[i], lists, list);
            list.remove(list.size() - 1);
        }
    }

}
