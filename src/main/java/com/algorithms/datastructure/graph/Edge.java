package com.algorithms.datastructure.graph;


/**
 * 图的边
 */
public class Edge {

    public final int v;
    public final int w;
    public final double weight;

    public Edge(int v, int w, double weight) {
        if (v < 0) throw new IllegalArgumentException("vertex index must be a non-negative integer");
        if (w < 0) throw new IllegalArgumentException("vertex index must be a non-negative integer");
        if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int other(Integer v) {
        return v == this.v ? w : this.v;
    }
}
