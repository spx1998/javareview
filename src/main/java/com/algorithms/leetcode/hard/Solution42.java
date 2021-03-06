package com.algorithms.leetcode.hard;

import com.algorithms.leetcode.medium.Solution43;
import com.algorithms.leetcode.medium.Solution503;
import com.algorithms.leetcode.medium.Solution739;

import java.util.Stack;

/**
 * 给定n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 3                       #
 * 2           #  @  @  @  #  #  @  #
 * 1     #  @  #  #  @  #  #  #  #  #  #
 * 0  1  2  3  4  5  6  7  8  9  10 11 12
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水。
 * <p>
 * 我的解法：
 * 利用了栈的思想。设置两个栈stack1和stack2，将数组中的数组逐个加入stack1，并保证stack1是数据递减的（递减时显然无法存雨水）。
 * 如果出现数组中数据大于前一个的时候，就出现了蓄水的可能。此时，从下向上，逐层计算蓄水量。将多边形的储水面积划分成每层的矩形面积。
 * <p>
 * 改进：stack2实际上并不需要设置为栈，设置为记录当前最低height和长度的两个变量即可。
 * stack中不存储height值，存储height的下标index.->单调栈解法
 * <p>
 * 更佳解法：双指针
 * 通过观察，应该发现一个事实：横坐标每跨一格可储存的水为1*min(left_max,right_max)，
 * left_max和right_max分别是这一格左右两侧柱子高度的最大值。
 * 因此，可以用双指针的方法，动态记录left_max和right_max的值，进而计算横坐标每跨一格的储水量，其和为总储水量。
 * <p>
 * 相关问题：
 * leetcode84题  {@link Solution84}
 * leetcode85题  {@link Solution85}
 * leetcode503题 {@link Solution503}
 * leetcode739题 {@link Solution739}
 */
public class Solution42  {
    public static void main(String[] args) {
//        int[] ints = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution42().stackTrap(new int[]{4, 2, 3}));
    }

    public int trap0(int[] height) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int rain = 0;
        for (int i = 0; i < height.length; i++) {
            //递减时直接加入stack1中
            if (stack1.isEmpty() || height[i] <= stack1.peek()) {
                stack1.push(height[i]);
            } else {
                //temp一定是stack1中的最小值（或之一），
                int temp = stack1.peek();
                //stack2.size()就是stack1中temp个数。
                while (stack1.size() > 1 && temp == stack1.peek()) {
                    stack2.push(stack1.pop());
                }
                if (!stack1.empty()) {
                    //底为temp，左右两壁分别为stack1中第一个大于temp的值和height[i]
                    //最低一层的储水量为(min(左壁，右壁)-temp)*temp的个数。
                    if (stack1.peek() >= height[i]) {
                        rain += (height[i] - temp) * stack2.size();
                        //若右壁低于左壁，将值为temp的部分增大到height[i]。因为这一层的储水量已经计算过。
                        while (!stack2.isEmpty()) {
                            stack2.pop();
                            stack1.push(height[i]);
                        }
                        stack1.push(height[i]);
                        stack2.clear();
                    } else {
                        rain += (stack1.peek() - temp) * stack2.size();
                        //若左壁低于右壁，且左壁已经是（stack1中）最边缘的墙壁，height[i]之前已达到最大储水量，将其从stack1中删除。
                        if (stack1.size() == 1) {
                            stack1.clear();
                            stack1.push(height[i]);
                            stack2.clear();
                        }
                        //左壁不是最边缘墙壁，将最底层填满，继续以height[i]为右壁，计算上一层的面积。
                        else {
                            i--;
                            while (!stack2.isEmpty()) {
                                stack2.pop();
                                stack1.push(stack1.peek());
                            }
                        }
                    }
                }

            }
        }
        return rain;
    }

    /**
     * 双指针法
     */
    public int doublePointer(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length - 1;
        int rain = 0;
        while (left <= right) {
            if (leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[left]);
                rain += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                rain += rightMax - height[right];
                right--;
            }
        }
        return rain;
    }

    /**
     * 单调栈
     */
    public int stackTrap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            if (!stack.empty() && height[stack.peek()] <= height[i]) {
                int temp = stack.peek();
                while (!stack.empty() && height[stack.peek()] < height[i]) {
                    res += Math.max(0, i - stack.peek() - 1) * (height[stack.peek()] - temp);
                    temp = height[stack.peek()];
                    stack.pop();
                }
                if (!stack.empty()) {
                    res += Math.max(0, i - stack.peek() - 1) * (height[i] - temp);
                }
            }
            stack.push(i);
        }
        return res;
    }

    /**
     * 又写了一遍 单调栈
     */
    public int trap(int[] height) {
        int res = 0;
        if (height.length == 0 || height.length == 1 || height.length == 2) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            Integer peek = stack.peek();
            if (height[i] >= height[peek])  {
                while (!stack.empty() && height[i] > height[peek]) {
                    Integer pop = stack.pop();
                    if (!stack.empty()) {
                        peek = stack.peek();
                        res += (Math.min(height[peek], height[i]) - height[pop]) * (i - peek - 1);
                    }
                }
            }
            stack.push(i);
        }
        return res;
    }

}
