import java.util.*;
public class Main {
    static int V; // Number of vertices in the graph
    static List<List<Integer>> graph; // Adjacency list representation of the graph
    // Function to check if vertex v can be added at position pos in the Hamiltonian cycle
    static boolean isSafe(int v, int pos, int[] path, boolean[] visited) {
        // Check if this vertex is an adjacent vertex of the previously added vertex
        if (!graph.get(path[pos - 1]).contains(v))
            return false;
        // Check if the vertex has already been include
        if (visited[v])
            return false;
        return true;
    }  
    // Function to recursively find all Hamiltonian cycles in the graph
    static boolean hamiltonianCycleUtil(int[] path, int pos, boolean[] visited) {
        // Base case: If all vertices are included in the Hamiltonian cycle
        if (pos == V) {
            // And if there is an edge from the last included vertex to the first vertex
            if (graph.get(path[pos - 1]).contains(path[0])) {
                printPath(path);
                return true;
            } else {
                return false;
            }
        }
        // Try different vertices as the next candidate in Hamiltonian cycle
        for (int v = 1; v < V; v++) {
            if (isSafe(v, pos, path, visited)) {
                path[pos] = v;
                visited[v] = true;
                // Recur to construct the rest of the path
                if (hamiltonianCycleUtil(path, pos + 1, visited))
                    return true;
                // If adding vertex v doesn't lead to a solution, backtrack
                visited[v] = false;
            }
        }
        return false;
    }
    // Function to find all Hamiltonian cycles in the graph
    static void hamiltonianCycles(List<List<Integer>> g) {
        V = g.size();
        graph = g;
        int[] path = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(path, -1);
        Arrays.fill(visited, false);
        // Starting from vertex 0 as the first vertex of the Hamiltonian cycle
        path[0] = 0;
        visited[0] = true;
        if (!hamiltonianCycleUtil(path, 1, visited)) {
            System.out.println("No Hamiltonian cycle exists.");
        }
    }
    // Function to print the Hamiltonian cycle path
    static void printPath(int[] path) {
        System.out.print("Hamiltonian Cycle: ");
        for (int vertex : path) {
            System.out.print(vertex + " ");
        }
        System.out.print(path[0] + "\n"); // Complete the cycle by printing the first vertex again
    }
    public static void main(String[] args) {
        // Example graph represented as adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(Arrays.asList(0, 1, 2, 3)); // Node 0 is connected to nodes 1, 2, and 3
        graph.add(Arrays.asList(0, 2, 3));    // Node 1 is connected to nodes 0, 2, and 3
        graph.add(Arrays.asList(0, 1, 3));    // Node 2 is connected to nodes 0, 1, and 3
        graph.add(Arrays.asList(0, 1, 2));    // Node 3 is connected to nodes 0, 1, and 2
        hamiltonianCycles(graph);
    }
}
