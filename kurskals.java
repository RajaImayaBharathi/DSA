import java.util.*;
class Edge implements Comparable<Edge> {
    int source, destination, weight;
    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    @Override
    public int compareTo(Edge otherEdge) {
        return this.weight - otherEdge.weight;
    }
}
class Subset {
    int parent, rank;
}
class KruskalMST {
    int vertices, edges;
    Edge[] edgeList;
    // Constructor to initialize the graph with vertices and edges
    public KruskalMST(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        edgeList = new Edge[edges];
    }
    // Utility function to find the set of an element i (uses path compression)
    int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }
    // Utility function to unite two subsets x and y (uses union by rank)
    void union(Subset[] subsets, int x, int y) {
        int rootX = find(subsets, x);
        int rootY = find(subsets, y);

        if (subsets[rootX].rank < subsets[rootY].rank) {
            subsets[rootX].parent = rootY;
        } else if (subsets[rootX].rank > subsets[rootY].rank) {
            subsets[rootY].parent = rootX;
        } else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }
    // Function to construct the MST using Kruskal's algorithm
    public void kruskalMST() {
        Edge[] result = new Edge[vertices];
        int e = 0;  // An index variable for the result array
        // Step 1: Sort all the edges in non-decreasing order of their weight
        Arrays.sort(edgeList);
        Subset[] subsets = new Subset[vertices];
        for (int v = 0; v < vertices; ++v) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        int i = 0;  // An index variable for sorted edges
        while (e < vertices - 1) {
            // Step 2: Pick the smallest edge and increment the index for next iteration
            Edge nextEdge = edgeList[i++];
            int x = find(subsets, nextEdge.source);
            int y = find(subsets, nextEdge.destination);
            // If including this edge does not cause a cycle, include it in the result
            // and move to the next edge
            if (x != y) {
                result[e++] = nextEdge;
                union(subsets, x, y);
            }
        }
        // Print the constructed MST
        System.out.println("Following are the edges in the constructed MST");
        int minimumCost = 0;
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].source + " -- " + result[i].destination + " == " + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree: " + minimumCost);
    }
}
public class Main{
    public static void main(String[] args) {
        int vertices = 4;  // Number of vertices in graph
        int edges = 5;     // Number of edges in graph
        KruskalMST graph = new KruskalMST(vertices, edges);

        // Add edges with their weights
        graph.edgeList[0] = new Edge(0, 1, 10);
        graph.edgeList[1] = new Edge(0, 2, 6);
        graph.edgeList[2] = new Edge(0, 3, 5);
        graph.edgeList[3] = new Edge(1, 3, 15);
        graph.edgeList[4] = new Edge(2, 3, 4);

        // Function call
        graph.kruskalMST();
    }
}
