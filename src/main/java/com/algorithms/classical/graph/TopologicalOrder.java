package com.algorithms.classical.graph;

import com.algorithms.datastructure.graph.Digraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 有向无环图的拓扑排序
 * 图的拓扑排序相当于逆后序
 */
public class TopologicalOrder {
    public Iterable<Integer> order;  // topological order
    public int[] rank;               // rank[v] = rank of vertex v in order

    public TopologicalOrder(Digraph G) {
        if (!hasCycle(G)) {
            order = reversePostOrder(G);
            rank = new int[G.V];
            int i = 0;
            for (int v : order)
                rank[v] = i++;
        }
    }

    /**
     * 逆后序排列
     */
    private Iterable<Integer> reversePostOrder(Digraph g) {
        ArrayList<Integer> postOrder = new ArrayList<>();
        for (int i = 0; i < g.V; i++) {
            dfs2(g,i,postOrder);
        }
        Collections.reverse(postOrder);
        return postOrder;
    }

    /**
     * 逆后序的DFS
     */
    private void dfs2(Digraph g, int i, ArrayList<Integer> postOrder) {
        for (int v:g.adj[i]){
            dfs2(g,v,postOrder);
        }
        postOrder.add(i);
    }

    /**
     * 判断是否有环
     */
    private boolean hasCycle(Digraph g) {
        List<Integer> cycle = new ArrayList<>();
        boolean[] marked = new boolean[g.V];
        for (int i = 0; i < g.V; i++) {
            if (dfs1(g, i, cycle, marked)) {
                return true;
            }
        }
        return false;
    }


        /**
         * 寻找环的DFS
         */
    private boolean dfs1(Digraph g, int i, List<Integer> cycle, boolean[] marked) {
//        形成了环 返回true
        if (cycle.contains(i)) {
            return true;
        }
        if (!marked[i]) {
            marked[i] = true;
            cycle.add(i);
            for (int v : g.adj[i]) {
                if (dfs1(g, v, cycle, marked)) {
                    return true;
                }
            }
            cycle.remove(cycle.size() - 1);
        }
        return false;
    }


    /**
     * 判断是否是有向无环图
     */
    public boolean isDAG() {
        return order == null;
    }
}
