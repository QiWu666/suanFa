package com.qi.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 拓扑排序
 */
public class TopologicalSoft {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("网页基础");
        Vertex v2 = new Vertex("Java基础");
        Vertex v3 = new Vertex("数据库");
        Vertex v4 = new Vertex("JavaWeb");
        Vertex v5 = new Vertex("Spring框架");
        Vertex v6 = new Vertex("微服务框架");
        Vertex v7 = new Vertex("实战项目");
        v1.edges = List.of(new Edge(v4));
        v2.edges = List.of(new Edge(v4));
        v3.edges = List.of(new Edge(v5));
        v4.edges = List.of(new Edge(v5));
        v5.edges = List.of(new Edge(v6));
        v6.edges = List.of(new Edge(v7));
        v7.edges = List.of();

        List<Vertex> vertices = List.of(v1, v2, v3, v4, v5, v6, v7);

        // 1. 统计每个顶点的入度
        for (Vertex vertex : vertices) {
            for (Edge edge : vertex.edges) {
                edge.linked.inDegree++;
            }
        }
        LinkedList<Vertex> queue = new LinkedList<>(List.of(v1, v2, v3, v4, v5, v6, v7));
        // 2. 将入度为0的顶点加入队列
        for (Vertex vertex : vertices) {
            if (vertex.inDegree == 0) {
                queue.offer(vertex);
            }
        }
        // 3. 队列中不断移除顶点，每移除一个顶点，把它相邻点入度减1，若减到0移除节点
        while (!queue.isEmpty()) {
            Vertex polled = queue.poll();
            System.out.println(polled.name);
            for (Edge edge : polled.edges) {
                edge.linked.inDegree--;
                if (edge.linked.inDegree == 0) {
                    queue.offer(edge.linked);
                }
            }

        }

/*        for (Vertex vertex : vertices) {
            System.out.println(vertex.name + " " + vertex.inDegree);
        }*/
    }
}
