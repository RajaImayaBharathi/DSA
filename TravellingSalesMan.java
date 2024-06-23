import java.util.Arrays;

public class Main {

    // Function to solve the Traveling Salesman Problem using dynamic programming with memoization
    static int tsp(int[][] graph, int mask, int pos, int n, int[][] dp) {
        // If all cities have been visited, return the cost of returning to the starting city
        if (mask == (1 << n) - 1) {
            return graph[pos][0];
        }

        // If this sub-problem has already been solved, return the stored result
        if (dp[mask][pos] != -1) {
            return dp[mask][pos];
        }

        // Initialize minimum cost to a large value
        int minCost = Integer.MAX_VALUE;

        // Try to go to every other city from the current city
        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) { // If the city hasn't been visited
                int newCost = graph[pos][city] + tsp(graph, mask | (1 << city), city, n, dp);
                minCost = Math.min(minCost, newCost);
            }
        }

        // Store the result in dp table and return the minimum cost
        return dp[mask][pos] = minCost;
    }

    // Function to initialize memoization table and solve TSP using dynamic programming
    static int solveTSP(int[][] graph) {
        int n = graph.length;
        // dp[mask][pos] will store the minimum cost to visit all cities in 'mask' starting from 'pos'
        int[][] dp = new int[1 << n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return tsp(graph, 1, 0, n, dp); // Start from city 0 (the first city)
    }

    public static void main(String[] args) {
        // Example graph representing distances between cities (0-indexed)
        int[][] graph = {
            { 0, 10, 15, 20 },
            { 10, 0, 35, 25 },
            { 15, 35, 0, 30 },
            { 20, 25, 30, 0 }
        };

        int minCost = solveTSP(graph);
        System.out.println("Minimum cost to visit all cities: " + minCost);
    }
}
