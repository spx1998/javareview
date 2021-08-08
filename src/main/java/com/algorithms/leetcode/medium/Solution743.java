package com.algorithms.leetcode.medium;

import java.util.*;

/**
 * 有 n 个网络节点，标记为1到 n。
 * 给你一个列表times，表示信号经过 有向 边的传递时间。
 * times[i] = (ui, vi, wi)，其中ui是源节点，vi是目标节点， wi是一个信号从源节点传递到目标节点的时间。
 * 现在，从某个节点K发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回-1 。
 * 转换成求一个顶点到所有顶点的最短路径的最大值的问题。
 */
public class Solution743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] minTime = new int[n];
        for (int i = 0; i < n; i++) {
            minTime[i] = Integer.MAX_VALUE;
        }
        Map<Integer, Integer> map = new HashMap<>();
        boolean[] visited = new boolean[n];
        visited[k - 1] = true;
        minTime[k - 1] = 0;
        for (int[] time : times) {
            if (time[0] == k) {
                map.put(time[1], time[2]);
            }
        }
        while (!map.isEmpty()) {
            int toAdd = -1;
            Integer num = Integer.MAX_VALUE;
            for (int key : map.keySet()) {
                if (map.get(key) < num) {
                    num = map.get(key);
                    toAdd = key;
                }
            }
            map.remove(toAdd);
            minTime[toAdd - 1] = num;
            visited[toAdd - 1] = true;
            for (int[] time : times) {
                if (time[0] == toAdd && !visited[time[1] - 1]) {
                    if (map.get(time[1]) == null || time[2] + num < map.get(time[1])) {
                        map.put(time[1], time[2] + num);
                    }
                }
            }
        }
        int max = -1;
        for (int min : minTime) {
            if (min == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, min);
        }
        return max;
    }
}
