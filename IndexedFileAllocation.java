import java.util.*;
public class Main{
    private static final int MAX_BLOCKS = 10;
    private static boolean[] freeBlocks = new boolean[MAX_BLOCKS];
    private static String[] fileNames = new String[MAX_BLOCKS];
    private static int[][] fileBlocks = new int[MAX_BLOCKS][MAX_BLOCKS];
    private static int[] fileBlockCount = new int[MAX_BLOCKS];
    private static int fileCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        // Initialize all blocks as free
        for (int i = 0; i < MAX_BLOCKS; i++) {
            freeBlocks[i] = true;
        }

        while (choice != 4) {
            System.out.println("\n1. Create File \t 2. Allocate Blocks \t 3. View Allocation \t 4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    createFile(scanner);
                    break;
                case 2:
                    allocateBlocks(scanner);
                    break;
                case 3:
                    viewAllocation();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter again.");
            }
        }
        scanner.close();
    }

    private static void createFile(Scanner scanner) {
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();
        boolean exists = false;
        for (int i = 0; i < fileCount; i++) {
            if (fileNames[i].equals(fileName)) {
                exists = true;
                break;
            }
        }
        if (exists) {
            System.out.println("File already exists!");
        } else {
            fileNames[fileCount] = fileName;
            fileBlockCount[fileCount] = 0;
            fileCount++;
            System.out.println("File created successfully.");
        }
    }

    private static void allocateBlocks(Scanner scanner) {
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();
        int fileIndex = -1;
        for (int i = 0; i < fileCount; i++) {
            if (fileNames[i].equals(fileName)) {
                fileIndex = i;
                break;
            }
        }
        if (fileIndex == -1) {
            System.out.println("File does not exist!");
            return;
        }

        System.out.print("Enter number of blocks to allocate: ");
        int numBlocks = scanner.nextInt();

        int allocated = 0;
        for (int i = 0; i < MAX_BLOCKS && allocated < numBlocks; i++) {
            if (freeBlocks[i]) {
                freeBlocks[i] = false;
                fileBlocks[fileIndex][fileBlockCount[fileIndex]] = i;
                fileBlockCount[fileIndex]++;
                allocated++;
            }
        }

        if (allocated == numBlocks) {
            System.out.println("Blocks allocated successfully.");
        } else {
            System.out.println("Not enough free blocks available.");
            // Revert allocation if not enough blocks
            for (int i = 0; i < allocated; i++) {
                int block = fileBlocks[fileIndex][fileBlockCount[fileIndex] - 1];
                freeBlocks[block] = true;
                fileBlockCount[fileIndex]--;
            }
        }
    }

    private static void viewAllocation() {
        for (int i = 0; i < fileCount; i++) {
            System.out.print("File: " + fileNames[i] + " - Blocks: ");
            for (int j = 0; j < fileBlockCount[i]; j++) {
                System.out.print(fileBlocks[i][j] + " ");
            }
            System.out.println();
        }
    }
}
