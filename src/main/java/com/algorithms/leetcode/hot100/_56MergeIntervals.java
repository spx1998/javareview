package com.algorithms.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 */
public class _56MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        list.sort(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < list.size(); i++) {
            int right = list.get(i)[1];
            int j = i + 1;
            while (j < list.size() && list.get(j)[0] <= right) {
                right = Math.max(right, list.get(j)[1]);
                list.remove(j);
            }
            list.get(i)[1] = right;
        }
        int[][] res = new int[list.size()][2];
        int i = 0;
        for (int[] ints : list) {
            res[i] = ints;
            i++;
        }
        return res;
    }
}
