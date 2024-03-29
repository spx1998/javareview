package com.algorithms.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 示例1：
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例2：
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10]重叠。
 * 我的解法：
 * 插入新数组，然后做法与56题一致。
 * <p>
 * 相关问题：
 * leetcode 56题 {@link com.algorithms.leetcode.medium.Solution56}
 */
public class Solution57 {
    public int[][] insert0(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        list.add(newInterval);
        list.sort(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i)[1] >= list.get(i + 1)[0]) {
                list.get(i)[1] = Math.max(list.get(i)[1], list.get(i + 1)[1]);
                list.remove(i + 1);
                i--;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    /**
     * 不取巧的做法
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> resList = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                if (!placed) {
                    resList.add(new int[]{left, right});
                    placed = true;
                }
                resList.add(interval);
            } else if (interval[1] < left) {
                resList.add(interval);
            } else {
                left = Math.min(interval[0], left);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            resList.add(new int[]{left, right});
        }
        return resList.toArray(new int[resList.size()][2]);
    }
}
