package com.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 现在你总共有 n 门课需要选，记为0到n-1。
 * 在选修某些课程之前需要一些先修课程。例如，想要学习课程 0 ，你需要先完成课程1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 * 示例1:
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释:总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例2:
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释:总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是[0,1,2,3] 。另一个正确的排序是[0,2,1,3] 。
 * 说明:
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 提示:
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 拓扑排序也可以通过BFS完成。
 *
 * {@link Solution207}
 */
public class Solution210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ints = new int[numCourses];
        if (numCourses == 0) {
            return ints;
        }
        int index = 0;

        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (integers.contains(i)) {
                continue;
            }
            boolean check = DFS(integers, prerequisites, i, new ArrayList<>(Collections.singletonList(i)));
            if (!check) {
                return new int[0];
            }
        }
        for (int i : integers) {
            ints[index++] = i;
        }
        return ints;
    }

    private boolean DFS(List<Integer> integers, int[][] prerequisites, int num, ArrayList<Integer> list) {
        for (int[] prerequisite : prerequisites) {
            if (prerequisite[0] == num) {
                if (integers.contains(prerequisite[1])) {
                    continue;
                }
                if (list.contains(prerequisite[1])) {
                    return false;
                }
                list.add(prerequisite[1]);
                boolean check = DFS(integers, prerequisites, prerequisite[1], list);
                if (!check) {
                    return false;
                }
                list.remove(list.size() - 1);
            }
        }
        integers.add(num);
        return true;
    }
}
