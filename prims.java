import java.util.*;
class Graph {
    private int vertices;
    private List<List<Node>> adjacencyList;
    // Node class representing a graph node with a vertex and a weight
    class Node implements Comparable<Node> {
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }

    // Constructor to initialize the graph with a given number of vertices
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int source, int destination, int weight) {
        adjacencyList.get(source).add(new Node(destination, weight));
        adjacencyList.get(destination).add(new Node(source, weight)); // For undirected graph
    }

    // Method to implement Prim's algorithm
    public void primMST() {
        boolean[] visited = new boolean[vertices];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] parent = new int[vertices];
        int[] key = new int[vertices];
        Arrays.fill(key, Integer.MAX_VALUE);

        pq.add(new Node(0, 0));
        key[0] = 0;
        parent[0] = -1;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.vertex;
            visited[u] = true;
            for (Node neighbor : adjacencyList.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (!visited[v] && weight < key[v]) {
                    key[v] = weight;
                    pq.add(new Node(v, key[v]));
                    parent[v] = u;
                }
            }
        }
        printMST(parent);
    }
    // Method to print the MST
    private void printMST(int[] parent) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < vertices; i++) {
            int weight = 0;
            for (Node node : adjacencyList.get(i)) {
                if (node.vertex == parent[i]) {
                    weight = node.weight;
                    break;
                }
            }
            System.out.println(parent[i] + " - " + i + "\t" + weight);
        }
    }
}
public class Main{
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        graph.primMST();
    }
}
