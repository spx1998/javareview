package com.algorithms.classical.graph;

import com.algorithms.datastructure.graph.Edge;
import com.algorithms.datastructure.graph.EdgeWeightedGraph;

import java.util.TreeMap;

/**
 * prim算法求最小生成树(用了treeMap，所以不允许有相同的权重)
 * 每次加入最短的相邻边对应的顶点，构造子图和新的相邻边集合，重复上述过程。
 */
public class Prim {

    private Edge[] edgeTo;        // edgeTo[v] = shortest edge from tree vertex to non-tree vertex
    private double[] distTo;      // distTo[v] = weight of shortest such edge
    private boolean[] marked;     // marked[v] = true if v on tree, false otherwise
    private TreeMap<Double, Integer> pq; //

    public Prim(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V];
        distTo = new double[G.V];
        marked = new boolean[G.V];
        pq = new TreeMap<>();
        for (int i = 0; i < G.V; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[0] = 0.0;
        pq.put(0.0, 0);
        while (!pq.isEmpty()) {
            visit(G, pq.remove(pq.firstKey()));
        }
    }

    private void visit(EdgeWeightedGraph g, Integer remove) {
        marked[remove] = true;
        int v = 0;
        for (Edge e : g.adj[remove]) {
            v = e.other(remove);
            if (!marked[v]) {
                if (e.weight < distTo[v]) {
                    edgeTo[v] = e;
                    distTo[v] = e.weight;
                    pq.put(e.weight,v);
                }
            }
        }
    }
}
