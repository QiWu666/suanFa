package com.qi.graph;

/**
 * 边
 */
public class Edge {
    Vertex linked; // 终点对应的顶点
    int weight; // 权重
    public Edge(Vertex linked, int weight) {
        this.linked = linked;
        this.weight = weight;
    }

    public Edge(Vertex linked) {
        this(linked, 1);
    }
}
