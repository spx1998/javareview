package com.algorithms.leetcode.medium;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * 我的解法：
 * 回溯法，使用一个HashMap<Integer,hashMap<Integer,Integer>>记录每个位置某元素出现与否，出现过则跳过该元素，未出现过则将该元素移动到该位置。
 * 回溯时要将当前位置的hashmap置空，因为当上一位的值改变后，以后各位的情况都要重置。
 * <p>
 * 更佳解法：
 * 先将nums排序，用一个boolean数组标志当前值是否使用过，如果nums[i]==nums[i-1]，且i-1没有被使用过，则剪枝。
 * 1，1，1，2
 * *  1                      1
 * *   \                    / \
 * *    1                  1   1
 * *     \                     |
 * *      1                    |
 * * i-1被使用的情况          i-1未被使用的情况
 * 一个关键在于，剪枝之前往往要先进行排序。
 * <p>
 * 相关问题：
 * leetcode 46题 {@link Solution46}
 */
public class Solution47 {
    public static void main(String[] args) {
        new Solution47().permuteUnique(new int[]{1, 1, 2, 2}).forEach(System.out::println);
    }
    /*public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        HashMap<Integer, HashMap<Integer, Integer>> hashMap = new HashMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, 0);
        }
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(i, new HashMap<>(map));
        }
        doSomething(list, hashMap,map, result, 0);
        return result;
    }

    private void doSomething(List<Integer> list, HashMap<Integer, HashMap<Integer, Integer>> hashMap, HashMap<Integer, Integer> map, List<List<Integer>> result, int first) {
        if (first == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int j = first; j < list.size(); j++) {
            if (hashMap.get(first).get(list.get(j)) == 0) {
                hashMap.get(first).put(list.get(j), 1);
                Collections.swap(list, first, j);
                doSomething(list, hashMap, map, result, first + 1);
                Collections.swap(list, first, j);
            }
        }
        hashMap.put(first,new HashMap<>(map));
    }
    */

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        doSomething(nums, new boolean[nums.length], new ArrayDeque<>(), result, 0);
        return result;
    }

    private void doSomething(int[] nums, boolean[] used, ArrayDeque<Integer> deque, List<List<Integer>> result, int length) {
        if (length == nums.length) {
            result.add(new ArrayList<>(deque));
        } else {
            for (int j = 0; j < nums.length; j++) {
                if (used[j]) {
                    continue;
                }
                if (j > 0 && nums[j] == nums[j - 1] && !used[j - 1]) {
                    continue;
                }
                used[j] = true;
                deque.add(nums[j]);
                doSomething(nums, used, deque, result, length + 1);
                deque.removeLast();
                used[j] = false;

            }
        }
    }
}


