package com.algorithms.leetcode.hot100;

import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class _42TrappingRainWater {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[i] > height[stack.peek()]) {
                int bottom = height[stack.pop()];
                if (stack.empty()) {
                    continue;
                }
                int left = height[stack.peek()];
                int right = height[i];
                res += (Math.min(left, right) - bottom) * (i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return res;
    }
}
