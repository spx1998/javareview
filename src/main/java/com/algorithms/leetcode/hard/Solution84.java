package com.algorithms.leetcode.hard;

import com.algorithms.leetcode.medium.Solution503;

import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 例如： [2,1,5,6,2,3]
 * 7        6
 * 6      5 #
 * 5      # #
 * 4      # #   3
 * 3  2   # # 2 #
 * 2  # 1 # # # #
 * 1  # # # # # #
 * 最大面积就是 5*2 = 10;
 * <p>
 * 我的解法：（暴力解法）
 * 包含某一列（一根柱子）全部面积的最大长方形的面积很好计算，即向左右扩展，寻找高度低于该列的柱子。从而得到总宽度。
 * 总宽度*柱高即包含该列的长方形的最大面积。
 * 整个图形中最大的长方形一定是包含某列全部面积的最大长方形。这类似于木桶效应。
 * 于是计算包含每列的最大长方形后，其中面积最大的一个就是图形中的最大长方形。
 * 这样要遍历数组元素，对于每个元素再向左右分别进行遍历，时间复杂度是O(n²)，空间复杂度是O(1)。
 * <p>
 * 分治解法：
 * 找到高度最低的柱子，面积最大的长方形有三种可能：在该柱子左、右和包含该柱子。
 * 而柱子左侧的最大面积也是找出该部分的最矮柱子，取上述三种可能之一。右侧亦然。
 * 于是通过分治的思想，不断找局部最大面积，最后比较得出整个图形的最大长方形面积。
 * <p>
 * 单调栈解法：
 * 单调栈是一类利用单调递增或递减的栈来解决问题的模型。
 * 设置一个栈，来存储每根柱子的高度。在本题中，观察可知，从第k根柱子起，第i根柱子比第i-1根柱子长（i>k），则总面积一定更大。
 * 因此，当柱子高度递增的时候，将下标压入栈中，面积一定还在增大中；
 * 当第i根柱子高度低于栈顶柱子时，从第i-1根向前，逐步计算高为heights[h]的最大矩形面积。h为当前栈顶柱子的高度。(①)
 * 直到栈空或栈顶元素小于第i根柱子的高度时停止。因为以该柱子高度为高的最大面积的宽不会在i-1处终止，会继续延长，此时无法计算。
 * 将i压入栈中。继续向后遍历，直到数组结尾。
 * 此时，如果栈中仍有剩余元素，肯定是递增的，可以根据与上述(①)一致的方法从后向前计算最大面积。
 * 最终比较得到的最大面积即结果。
 * 值得注意的是：在stack栈底先压入了一个-1，这是为了计算以所有柱子中最矮的柱子高度为高时的最大矩形面积。
 * 例如: [3,1,5,2,4] 将数组遍历完得到的栈中元素为 1,2,4的下标，分别为1，3，4 。
 * 高度4对应宽度为（5-3-1），高度2对应的宽度为（5-1-1），而高度1对应的下标应该为（5-（-1）+1）。
 * 因为，最低高度对应的宽一定是整个图形的总宽，即数组长度。
 * <p>
 * 相关问题：
 * leetcode42题  {@link Solution42}
 * leetcode85题  {@link Solution85}
 * leetcode503题 {@link Solution503}
 * leetcode739题 {@link com.algorithms.leetcode.medium.Solution739}
 */
public class Solution84 {
    /**
     * 暴力解法
     */
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int temp = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] >= heights[i]) {
                    temp++;
                } else {
                    break;
                }
            }
            for (int k = i + 1; k < heights.length; k++) {
                if (heights[k] >= heights[i]) {
                    temp++;
                } else {
                    break;
                }
            }
            max = Math.max(max, temp * heights[i]);
        }
        return max;
    }

    /**
     * 分治解法
     */
    public int divideAndConquer(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }

    public int calculateArea(int[] heights, int start, int end) {
        if (start > end) {
            return 0;
        }
        int min = start;
        for (int i = start; i <= end; i++) {
            if (heights[i] < heights[min]) {
                min = i;
            }
        }
        return Math.max(calculateArea(heights, start, min - 1), Math.max(calculateArea(heights, min + 1, end), (end - start + 1) * heights[min]));
    }

    /**
     * 单调栈解法
     */
    public int monotonousStack(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxarea;

    }
}
