package com.algorithms.datastructure.graph;

import java.util.ArrayList;

/**
 * 邻接表表示有向图
 * directed  graph
 */
public class Digraph {
    public final int V;           // number of vertices in this digraph
    public int E;                 // number of edges in this digraph
    public ArrayList<Integer>[] adj;    // adj[v] = adjacency list for vertex v
    public int[] indegree;        // indegree[v] = indegree of vertex v

    public Digraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be non-negative");
        this.V = V;
        this.E = 0;
        indegree = new int[V];
        adj = (ArrayList<Integer>[]) new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }

    public Digraph reverse() {
        Digraph digraph = new Digraph(this.V);
        for (int i = 0; i < this.V; i++) {
            for (int v : this.adj[i]) {
                if (digraph.adj[v] == null) {
                    digraph.adj[v] = new ArrayList<>();
                }
                digraph.adj[v].add(i);
            }
        }
        return digraph;
    }
}
