package com.algorithms.leetcode.medium;

import java.util.*;

/**
 * 给你一个有n个节点的 有向无环图（DAG），请你找出所有从节点 0到节点 n-1的路径并输出（不要求按特定顺序）
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
 * 译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。
 *
 * 解法：TODO
 */
public class Solution797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<List<Integer>>> nodePathMap = new HashMap<>();

        buildMap(0, graph, nodePathMap);

        return nodePathMap.get(0);
    }

    private void buildMap(int n, int[][] graph, Map<Integer, List<List<Integer>>> nodePathMap) {
        List<List<Integer>> res = new ArrayList<>();

        nodePathMap.put(n, res);
        if (n == graph.length - 1) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(n);
            res.add(list);
            return;
        }
        for (int i : graph[n]) {
            if (!nodePathMap.containsKey(i)) {
                buildMap(i, graph, nodePathMap);
            }
            List<List<Integer>> lists = nodePathMap.get(i);
            if (!lists.isEmpty()) {
                for (List<Integer> list : lists) {
                    ArrayList<Integer> arrayList = new ArrayList<>(list);
                    arrayList.add(0, n);
                    res.add(arrayList);
                }
            }
        }
    }
}
