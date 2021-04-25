package com.algorithms.classical.graph;

import com.algorithms.datastructure.graph.Edge;
import com.algorithms.datastructure.graph.EdgeWeightedGraph;

import java.util.*;

/**
 * BellmanFord 最短路径通用解法（原始方式或队列优化SPFA）
 * 不能有负环，同时这个算法可以用来检测负环。
 */
public class BellmanFord {
    int vertex;
    private Edge[] edgeTo;        // edgeTo[v] = shortest edge from tree vertex to non-tree vertex
    private double[] distTo;      // distTo[v] = weight of shortest such edge
    private boolean[] onQueue;
    private Queue<Integer> queue;

    public BellmanFord(EdgeWeightedGraph G, int v) {
        vertex = v;
        edgeTo = new Edge[G.V];
        distTo = new double[G.V];
        queue = new LinkedList<>();
        onQueue = new boolean[G.V];
        for (int i = 0; i < G.V; i++)
            distTo[i] = Double.POSITIVE_INFINITY;
        distTo[v] = 0;
        onQueue[v] = true;
        queue.offer(v);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            onQueue[poll] = false;
            relax(G, poll);
        }
    }

    private void relax(EdgeWeightedGraph g, Integer remove) {
        for (Edge edge : g.adj[remove]) {
            if (distTo[edge.to] > distTo[edge.from] + edge.weight) {
                if (!onQueue[edge.to]) {
                    queue.offer(edge.to);
                    onQueue[edge.to] = true;
                }
                edgeTo[edge.to] = edge;
                distTo[edge.to] = distTo[edge.from] + edge.weight;
            }
        }
    }
}
