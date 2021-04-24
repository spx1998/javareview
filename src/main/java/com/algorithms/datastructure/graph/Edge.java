package com.algorithms.datastructure.graph;


/**
 * 图的边
 */
public class Edge {
//    作为有向图的边时分别为起点和终点，作为无向图的边时不区分
    public final int from;
    public final int to;
    public final double weight;

    public Edge(int v, int w, double weight) {
        if (v < 0) throw new IllegalArgumentException("vertex index must be a non-negative integer");
        if (w < 0) throw new IllegalArgumentException("vertex index must be a non-negative integer");
        if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
        this.from = v;
        this.to = w;
        this.weight = weight;
    }

    public int other(Integer v) {
        return v == this.from ? to : this.from;
    }
}
