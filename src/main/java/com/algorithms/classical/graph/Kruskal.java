package com.algorithms.classical.graph;

import com.algorithms.datastructure.graph.Edge;
import com.algorithms.datastructure.graph.EdgeWeightedGraph;


import java.util.*;

/**
 * kruskal算法求最小生成树
 * 从所有边的集合中选择最短的边，如果两个顶点不在同一棵树中，则把对应的顶点加入同一棵树中。
 */
public class Kruskal {
    private double weight;                        // weight of MST
    private final Map<Integer, List<Integer>> map;

    public Kruskal(EdgeWeightedGraph G) {
        map = new HashMap<>();
        Edge[] edges = new Edge[G.E];
        int t = 0;
        for (Edge e : G.edges) {
            edges[t++] = e;
        }
        Arrays.sort(edges);
        for (Edge e : edges) {
            if (!inSameTree(e.w, e.v)) {
                weight += e.weight;
                putInSameTree(e.w, e.v);
            }
        }
    }

    private void putInSameTree(int w, int v) {
        List<Integer> vertices = map.get(w);
        vertices.addAll(map.get(v));
        map.put(v, vertices);
    }

    private boolean inSameTree(int w, int v) {
        map.computeIfAbsent(w, k -> new ArrayList<>());
        map.computeIfAbsent(v, k -> new ArrayList<>());
        return map.get(w) == map.get(v);
    }
}
