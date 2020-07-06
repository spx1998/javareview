package com.algorithms.leetcode.medium;

import com.algorithms.leetcode.hard.Solution42;
import com.algorithms.leetcode.hard.Solution84;
import com.algorithms.leetcode.hard.Solution85;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * <p>
 * 我的解法（单调栈）：
 * 先利用单调栈的方法遍历一次数组，找到每个元素后方大于它的第一个元素；
 * 再从头遍历一次数组，找到stack中剩余元素前方大于它的第一个元素。
 * 仍在stack中的元素即整个数组中的最大值。
 * <p>
 * 相关问题：
 * leetcode42题  {@link Solution42}
 * leetcode84题  {@link Solution84}
 * leetcode85题  {@link Solution85}
 * leetcode739题 {@link Solution739}
 */
public class Solution503 {
    public static void main(String[] args) {
        int[] ints = {5,3,1,2,4};
        System.out.println(Arrays.toString(new Solution503().nextGreaterElements(ints)));
    }
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = -1;
            if (!stack.empty() && nums[i] > nums[stack.peek()]) {
                while (!stack.empty() && nums[i] > nums[stack.peek()]) {
                    res[stack.pop()] = nums[i];
                }
            }
            stack.push(i);
        }
        if (stack.empty()) return res;
        for (int num : nums) {
            if (!stack.empty() && num > nums[stack.peek()]) {
                while (!stack.empty() && num > nums[stack.peek()]) {
                    res[stack.pop()] = num;
                }
            }
        }
        return res;
    }
}
