package com.algorithms.leetcode.medium;

import com.algorithms.leetcode.hard.Solution42;
import com.algorithms.leetcode.hard.Solution84;
import com.algorithms.leetcode.hard.Solution85;

import java.util.Stack;

/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。
 * 如果之后都不会升高，请在该位置用 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * <p>
 * 我的解法：（单调栈）
 * 构建一个栈和一个int数组res。数组为结果数组。遍历数组，如果当前元素小于等于下标为栈顶数字的元素，将下标入栈；
 * 如果当前元素大于栈顶元素，则取出栈顶数字，并计算当前下标与栈顶数字的差，即res中下标为栈顶数字的位置的值。
 * 重复取栈顶元素的操作直到栈顶元素大于当前元素。将当前元素下标入栈，继续遍历数组。
 * <p>
 * 相关问题：
 * leetcode42题  {@link Solution42}
 * leetcode84题  {@link Solution84}
 * leetcode85题  {@link Solution85}
 * leetcode503题 {@link Solution503}
 */
public class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        if (T.length == 0) return new int[0];
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            if (!stack.empty() && T[stack.peek()] <= T[i]) {
                while (!stack.empty() && T[stack.peek()] <= T[i]) {
                    res[stack.peek()] = i - stack.pop();
                }
            }
            stack.push(i);
        }
        return res;
    }
}
