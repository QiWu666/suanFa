package com.qi.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 迪克斯特拉 单源最短路径算法
 */
public class Dijkstra {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");

        v1.edges = List.of(new Edge(v3, 9), new Edge(v2, 7), new Edge(v6, 14));
        v2.edges = List.of(new Edge(v4, 15));
        v3.edges = List.of(new Edge(v4, 11), new Edge(v6, 2));
        v4.edges = List.of(new Edge(v5, 6));
        v5.edges = List.of();
        v6.edges = List.of(new Edge(v5, 9));
        List<Vertex> graph = List.of(v1, v2, v3, v4, v5, v6);
        dijkstra(graph, v1);
    }

    /**
     * @param graph  边的集合
     * @param source 初始顶点
     */
    private static void dijkstra(List<Vertex> graph, Vertex source) {
        // 将所有顶点标记为未访问。创建一个未访问顶点的集合。
        ArrayList<Vertex> list = new ArrayList<>(graph);
        source.distance = 0;

        while (!list.isEmpty()) {
            // 3. 选取当前顶点
            Vertex curr = chooseMinDistVertex(list);
            // 4. 更新当前顶点邻居距离
            updateNeighboursDist(curr, list);
            // 5. 移除当前顶点
            list.remove(curr);
        }

        for (Vertex v : graph) {
            System.out.println(v.name + " " + v.distance);
        }

    }

    private static Vertex chooseMinDistVertex(ArrayList<Vertex> list) {
        Vertex min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).distance < min.distance) {
                min = list.get(i);
            }
        }
        return min;
    }

    private static void updateNeighboursDist(Vertex curr, ArrayList<Vertex> list) {
        // 获取当前点的邻居
        for (Edge edge : curr.edges) {
            Vertex neigh = edge.linked;
            if (list.contains(neigh)) {
                int distance = curr.distance + edge.weight;
                if (distance < neigh.distance) {
                    neigh.distance = distance;
                    neigh.prev = curr;
                }
            }
        }
    }
}
