package com.qi.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * TODO 下P76
 */
public class Dfs {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");

        v1.edges = List.of(new Edge(v3), new Edge(v2), new Edge(v6));
        v2.edges = List.of(new Edge(v4));
        v3.edges = List.of(new Edge(v4), new Edge(v6));
        v4.edges = List.of(new Edge(v5));
        v5.edges = List.of();
        v6.edges = List.of(new Edge(v5));

        //dfs(v1);

        dfs2(v1);
    }

    /**
     * 非递归深度优先搜索
     */
    private static void dfs2(Vertex vertex) {
        LinkedList<Vertex> stack = new LinkedList<>();
        stack.push(vertex);
        while (!stack.isEmpty()) {
            Vertex pop = stack.pop();
            pop.visited = true;
            System.out.println(pop.name);
            for (Edge edge : pop.edges) {
                if (!edge.linked.visited) {
                    stack.push(edge.linked);
                }
            }
        }
    }

    private static void dfs(Vertex vertex) {
        vertex.visited = true;
        System.out.println(vertex.name);
        for (Edge edge : vertex.edges) {
            if (!edge.linked.visited) {
                dfs(edge.linked);
            }
        }
    }
}
