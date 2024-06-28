import java.util.Scanner;

class File {
    String name;
    int[] blocks;
    int size;
    int allocatedBlocks;

    File(String name, int size) {
        this.name = name;
        this.size = size;
        this.blocks = new int[size];
        this.allocatedBlocks = 0;
    }
}

public class SimpleSequentialFileAllocation {
    private static final int MAX_BLOCKS = 100;
    private static boolean[] freeBlocks = new boolean[MAX_BLOCKS];
    private static File[] files = new File[MAX_BLOCKS];
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
            if (files[i].name.equals(fileName)) {
                exists = true;
                break;
            }
        }
        if (exists) {
            System.out.println("File already exists!");
        } else {
            System.out.print("Enter file size (number of blocks): ");
            int size = scanner.nextInt();
            files[fileCount] = new File(fileName, size);
            fileCount++;
            System.out.println("File created successfully.");
        }
    }

    private static void allocateBlocks(Scanner scanner) {
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();
        int fileIndex = -1;
        for (int i = 0; i < fileCount; i++) {
            if (files[i].name.equals(fileName)) {
                fileIndex = i;
                break;
            }
        }
        if (fileIndex == -1) {
            System.out.println("File does not exist!");
            return;
        }

        int remainingBlocks = files[fileIndex].size - files[fileIndex].allocatedBlocks;
        if (remainingBlocks <= 0) {
            System.out.println("File has already been allocated maximum blocks.");
            return;
        }

        System.out.print("Enter starting block index (0 to " + (MAX_BLOCKS - 1) + "): ");
        int startBlock = scanner.nextInt();
        if (startBlock < 0 || startBlock >= MAX_BLOCKS) {
            System.out.println("Invalid starting block index.");
            return;
        }

        int allocateSize = Math.min(remainingBlocks, MAX_BLOCKS - startBlock);
        for (int i = startBlock; i < startBlock + allocateSize; i++) {
            if (freeBlocks[i]) {
                freeBlocks[i] = false;
                files[fileIndex].blocks[files[fileIndex].allocatedBlocks] = i;
                files[fileIndex].allocatedBlocks++;
            } else {
                System.out.println("Block " + i + " is already allocated.");
            }
        }

        System.out.println("Blocks allocated successfully.");
    }

    private static void viewAllocation() {
        for (int i = 0; i < fileCount; i++) {
            System.out.print("File: " + files[i].name + " - Blocks: ");
            for (int j = 0; j < files[i].allocatedBlocks; j++) {
                System.out.print(files[i].blocks[j] + " ");
            }
            System.out.println();
        }
    }
}
