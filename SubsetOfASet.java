import java.util.*;
public class Main {

    // Function to find if there exists a subset with the given target sum
    static boolean findSubsetWithTargetSum(int[] nums, int target) {
        // Using a dynamic programming approach with a boolean array to track possible sums
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Base case: subset with sum 0 exists (empty subset)
        // Iterate through each element in the set
        for (int num : nums) {
            // Traverse dp array from back to front to avoid overwriting
            for (int j = target; j >= num; j--) {
                if (dp[j - num]) {
                    dp[j] = true; // Marking current sum as possible if a subset exists for j - num
                }
            }
        }
        return dp[target]; // Return true if subset with target sum exists
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input the number of elements in the set
        System.out.print("Enter the number of elements in the set: ");
        int n = scanner.nextInt();
        // Input the elements of the set
        System.out.print("Enter the elements of the set: ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        // Input the target sum
        System.out.print("Enter the target sum: ");
        int target = scanner.nextInt();
        // Find if there exists a subset with the target sum
        boolean found = findSubsetWithTargetSum(nums, target);
        // Output the result
        if (found) {
            System.out.println("Found a subset with the target sum.");
        } else {
            System.out.println("No subset found with the target sum.");
        }
    }
}
