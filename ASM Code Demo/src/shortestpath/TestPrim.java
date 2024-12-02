package shortestpath;

import java.util.*;

public class TestPrim {
    static class Edge implements Comparable<Edge> {
        int vertex, weight;
        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    public static void prim(int start, int n, List<List<Edge>> graph) {
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        int totalWeight = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (visited[current.vertex]) continue;

            visited[current.vertex] = true;
            totalWeight += current.weight;

            for (Edge neighbor : graph.get(current.vertex)) {
                if (!visited[neighbor.vertex]) {
                    pq.add(neighbor);
                }
            }
        }

        System.out.println("Total weight of MST: " + totalWeight);
    }

    public static void main(String[] args) {
        // Create graph
        int vertices = 6;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) graph.add(new ArrayList<>());

        // Add edges (u <-> v, weight)
        graph.get(0).add(new Edge(1, 2));
        graph.get(1).add(new Edge(0, 2));
        graph.get(0).add(new Edge(2, 4));
        graph.get(2).add(new Edge(0, 4));
        graph.get(1).add(new Edge(2, 1));
        graph.get(2).add(new Edge(1, 1));
        graph.get(1).add(new Edge(3, 7));
        graph.get(3).add(new Edge(1, 7));
        graph.get(2).add(new Edge(4, 3));
        graph.get(4).add(new Edge(2, 3));
        graph.get(3).add(new Edge(4, 1));
        graph.get(4).add(new Edge(3, 1));
        graph.get(4).add(new Edge(5, 5));
        graph.get(5).add(new Edge(4, 5));
        graph.get(3).add(new Edge(5, 2));
        graph.get(5).add(new Edge(3, 2));

        // Test Prim's Algorithm
        System.out.println("Testing Prim-Jarnik Algorithm:");
        prim(0, vertices, graph);
    }
}
