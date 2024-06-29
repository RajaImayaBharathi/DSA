import java.util.*;
class Graph {
    private int vertices;
    private List<List<Node>> adjacencyList;
    class Node {
        int vertex, weight
        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }
    public void addEdge(int source, int destination, int weight) {
        adjacencyList.get(source).add(new Node(destination, weight));
        adjacencyList.get(destination).add(new Node(source, weight));
    }

    public void dijkstra(int startVertex) {
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        pq.add(new Node(startVertex, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int currentVertex = node.vertex;

            for (Node neighbor : adjacencyList.get(currentVertex)) {
                int newDist = distances[currentVertex] + neighbor.weight;
                if (newDist < distances[neighbor.vertex]) {
                    distances[neighbor.vertex] = newDist;
                    pq.add(new Node(neighbor.vertex, newDist));
                }
            }
        }

        printShortestPaths(distances, startVertex);
    }

    private void printShortestPaths(int[] distances, int startVertex) {
        System.out.println("Shortest paths from vertex " + startVertex + " to all other vertices:");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Vertex " + i + " : Distance " + distances[i]);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        Graph graph = new Graph(vertices);
        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();
        System.out.println("Enter the edges in the format: source destination weight");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(source, destination, weight);
        }
        System.out.print("Enter the start vertex for Dijkstra's algorithm: ");
        /*Graph graph = new Graph(6);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
        graph.dijkstra(0);*/
        int startVertex = scanner.nextInt();
        graph.dijkstra(startVertex);
    }
}
