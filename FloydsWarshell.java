import java.util.Arrays;
class FloydWarshall {
    final static int INF = 99999; // Using a large number to represent infinity
    // Function to implement Floyd-Warshall algorithm
    void floydWarshall(int graph[][]) {
        int vertices = graph.length;
        int dist[][] = new int[vertices][vertices];
        // Initialize the solution matrix same as input graph matrix
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                dist[i][j] = graph[i][j];
            }
        }
        // Add all vertices one by one to the set of intermediate vertices.
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        printSolution(dist);
    }
    // Function to print the shortest distance matrix
    void printSolution(int dist[][]) {
        System.out.println("The following matrix shows the shortest distances between every pair of vertices:");
        for (int i = 0; i < dist.length; ++i) {
            for (int j = 0; j < dist.length; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
public class Main{
    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();
        int graph[][] = { 
            { 0, 5, FloydWarshall.INF, 10 },
            { FloydWarshall.INF, 0, 3, FloydWarshall.INF },
            { FloydWarshall.INF, FloydWarshall.INF, 0, 1 },
            { FloydWarshall.INF, FloydWarshall.INF, FloydWarshall.INF, 0 }
        };
        fw.floydWarshall(graph);
    }
}
