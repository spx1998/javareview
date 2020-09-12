package com.algorithms.leetcode.medium;

import java.util.*;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 示例 1:
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 提示：
 * intervals[i][0] <= intervals[i][1]
 * 我的解法：
 * 先根据区间下界排序，然后遍历数组，插入或合并即可。
 *
 * 相关问题：
 * leetcode 57题 {@link com.algorithms.leetcode.hard.Solution57}
 */
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
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
}
