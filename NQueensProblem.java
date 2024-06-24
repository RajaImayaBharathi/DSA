import java.util.*;
public class Main {
    static int N = 4; // Size of the chessboard (4x4 for 4-Queens problem)
    static int[] queens = new int[N]; // To store column positions of queens
    // Function to print the board
    static void printBoard(int[] queens) {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (queens[row] == col) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    // Function to check if placing a queen at (row, col) is safe
    static boolean isSafe(int row, int col) {
        // Check if no two queens share the same column
        for (int i = 0; i < row; i++) {
            if (queens[i] == col) {
                return false;
            }
            // Check diagonals: if the difference in rows equals the difference in columns
            if (Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
    // Function to solve N-Queens problem using backtracking
    static void solveNQueens(int row) {
        if (row == N) {
            // All queens are placed successfully
            printBoard(queens);
            return;
        }
        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                queens[row] = col; // Place queen at this position
                solveNQueens(row + 1); // Recur to place the rest of the queens
                queens[row] = -1; // Backtrack: Remove queen from this position
            }
        }
    }
    public static void main(String[] args) {
        Arrays.fill(queens, -1); // Initialize queens array with -1 (no queens placed initially)
        solveNQueens(0); // Start solving from the first row (row 0)
    }
}
