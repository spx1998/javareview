package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 例如，给定三角形：
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为11（即，2+3+5+1= 11）。
 * 说明：
 * 如果你可以只使用 O(n)的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * <p>
 * 解法：
 * 动态规划，如果用入参list本身来记录，可以使空间复杂度为O(1) 时间复杂度O(n^2)，但是比起直接操作数组慢很多。
 * <p>
 * 更佳解法：
 * 从底到顶动态规划，最后结果不需要再取最小值。
 */
public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        List<Integer> minList;
        for (int i = 1; i < triangle.size(); i++) {
            minList = triangle.get(i - 1);
            List<Integer> list = triangle.get(i);
            list.set(0, list.get(0) + minList.get(0));
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, Math.min(minList.get(j - 1), minList.get(j)) + list.get(j));
            }
            list.set(list.size() - 1, minList.get(list.size() - 2) + list.get(list.size() - 1));
        }
        return triangle.get(triangle.size() - 1).stream().min(Comparator.comparingInt(a -> a)).orElse(0);
    }
}
