package com.algorithms.classical.graph;

/**
 * 弗洛伊德算法，多源最短路径，动态规划思想
 *
 * i j两点间的最短路径要么是i直达j，要么是i->a->b .. v .. e->f->j，且i->v ，v->j分别是i v和v j之间的最短路径。
 * 当引入前k个顶点作为中间节点，i j之前的最小距离就是i->j经过前k-1个节点，但不包含第k个节点时的距离，与i到k与k到j的距离之和之中的较小值。
 * 滑动数组，减小dp数组的维度，降低空间复杂度
 */
public class Floyd {
    int[][] path;

    public Floyd(int[][] graph) {
        path = new int[graph.length][graph.length];
        for (int k = 0; k < graph.length; k++) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    path[i][j] = Math.min(path[i][j], path[i][k] + path[k][j]);
                }
            }
        }
    }
}
