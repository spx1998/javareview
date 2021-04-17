package com.algorithms.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 加权无向图
 */
public class EdgeWeightedGraph {

    public final int V;
    public int E;
    public List<Edge>[] adj;
    public List<Edge> edges;

    /**
     * Initializes an empty edge-weighted graph with {@code V} vertices and 0 edges.
     *
     * @param V the number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public EdgeWeightedGraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be non-negative");
        this.V = V;
        this.E = 0;
        adj = (List<Edge>[]) new List[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<Edge>();
        }
    }
}