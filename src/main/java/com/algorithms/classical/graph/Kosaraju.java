package com.algorithms.classical.graph;

import com.algorithms.datastructure.graph.Digraph;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 查找有向图的强连通分量
 * 1）邻接表表示有向图
 * 2）反向图的逆后序
 * 3）根据2）中的顺序来遍历图中的顶点，最外层循环每进入一个内层循环表示图的一个强连通分量
 */
public class Kosaraju {

    //    强连通分量个数
    private int count;

    public int calculate(Digraph digraph) {
        Iterable<Integer> reversePostOrder = reversePostOrder(digraph.reverse());
        boolean[] marked = new boolean[digraph.V];
        for (int i : reversePostOrder) {
            if (!marked[i]) {
                dfs(digraph, i, marked);
                count++;
            }
        }
        return count;
    }

    /**
     * 3)中的DFS
     */
    private void dfs(Digraph digraph, int i, boolean[] marked) {
        if (!marked[i]) {
            marked[i] = true;
            for (int v : digraph.adj[i]) {
                dfs(digraph, v, marked);
            }
        }
    }

    /**
     * 逆后序排列
     */
    private Iterable<Integer> reversePostOrder(Digraph g) {
        ArrayList<Integer> postOrder = new ArrayList<>();
        boolean[] marked = new boolean[g.V];
        for (int i = 0; i < g.V; i++) {
            dfs(g, i, postOrder, marked);
        }
        Collections.reverse(postOrder);
        return postOrder;
    }

    /**
     * 逆后序的DFS
     */
    private void dfs(Digraph g, int i, ArrayList<Integer> postOrder, boolean[] marked) {
        if (marked[i]) {
            marked[i] = true;
            for (int v : g.adj[i]) {
                dfs(g, v, postOrder, marked);
            }
            postOrder.add(i);
        }
    }
}
