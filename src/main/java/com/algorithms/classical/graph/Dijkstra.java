package com.algorithms.classical.graph;

import com.algorithms.datastructure.graph.Edge;
import com.algorithms.datastructure.graph.EdgeWeightedGraph;

import java.util.TreeMap;

/**
 * 最短路径，贪心算法，不可有负权重边
 */
public class Dijkstra {

    int vertex;
    private Edge[] edgeTo;        // edgeTo[v] = shortest edge from tree vertex to non-tree vertex
    private double[] distTo;      // distTo[v] = weight of shortest such edge
    private TreeMap<Double, Integer> pq;

    public Dijkstra(EdgeWeightedGraph G, int v) {
        vertex = v;
        edgeTo = new Edge[G.V];
        distTo = new double[G.V];
        pq = new TreeMap<>();
        for (int i = 0; i < G.V; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[v] = 0;
        pq.put(0.0, v);
        while (!pq.isEmpty()) {
            Integer remove = pq.remove(pq.firstKey());
            relax(G, remove);
        }
    }

    private void relax(EdgeWeightedGraph g, Integer remove) {
        for (Edge edge : g.adj[remove]) {
            if (edge.weight + distTo[edge.from] < distTo[edge.to]) {
                edgeTo[edge.to] = edge;
                distTo[edge.to] = edge.weight + distTo[edge.from];
                pq.put(edge.weight + distTo[edge.from], edge.to);
            }
        }
    }
}
