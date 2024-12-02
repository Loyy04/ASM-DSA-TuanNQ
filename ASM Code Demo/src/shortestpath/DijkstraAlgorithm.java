package shortestpath;
import java.util.*;

public class DijkstraAlgorithm {
    static class Node implements Comparable<Node> {
        int vertex, weight;
        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }

    public static void dijkstra(int src, int n, List<List<Node>> graph) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            for (Node neighbor : graph.get(current.vertex)) {
                if (dist[current.vertex] + neighbor.weight < dist[neighbor.vertex]) {
                    dist[neighbor.vertex] = dist[current.vertex] + neighbor.weight;
                    pq.add(new Node(neighbor.vertex, dist[neighbor.vertex]));
                }
            }
        }

        System.out.println("Shortest distances from source: " + Arrays.toString(dist));
    }

    public static void main(String[] args) {
        int vertices = 5;
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) graph.add(new ArrayList<>());

        graph.get(0).add(new Node(1, 2));
        graph.get(0).add(new Node(2, 4));
        graph.get(1).add(new Node(2, 1));
        graph.get(1).add(new Node(3, 7));
        graph.get(2).add(new Node(4, 3));

        dijkstra(0, vertices, graph);
    }
}
