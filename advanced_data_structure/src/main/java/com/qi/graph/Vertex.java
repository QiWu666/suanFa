package com.qi.graph;

import java.util.List;

/**
 * 顶点类
 */
public class Vertex {
    String name;
    List<Edge> edges;
    boolean visited = false; // 是否被访问过
    int inDegree = 0; // 入度的次数
    int status; // 状态 0-未访问 1-访问中 2-访问过，用在拓扑排序

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        a.edges = List.of(new Edge(b), new Edge(c));
        b.edges = List.of(new Edge(d));
        c.edges = List.of(new Edge(d));
        d.edges = List.of();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
