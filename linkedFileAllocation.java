import java.util.Scanner;

class Node {
    int blockNumber;
    Node next;

    Node(int blockNumber) {
        this.blockNumber = blockNumber;
        this.next = null;
    }
}

class File {
    String name;
    Node head;

    File(String name) {
        this.name = name;
        this.head = null;
    }
}

public class Main {
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
            files[fileCount] = new File(fileName);
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

        System.out.print("Enter number of blocks to allocate: ");
        int numBlocks = scanner.nextInt();

        int allocated = 0;
        Node lastNode = null;
        for (int i = 0; i < MAX_BLOCKS && allocated < numBlocks; i++) {
            if (freeBlocks[i]) {
                freeBlocks[i] = false;
                Node newNode = new Node(i);
                if (files[fileIndex].head == null) {
                    files[fileIndex].head = newNode;
                } else {
                    lastNode.next = newNode;
                }
                lastNode = newNode;
                allocated++;
            }
        }

        if (allocated == numBlocks) {
            System.out.println("Blocks allocated successfully.");
        } else {
            System.out.println("Not enough free blocks available.");
            // Revert allocation if not enough blocks
            Node currentNode = files[fileIndex].head;
            while (currentNode != null) {
                freeBlocks[currentNode.blockNumber] = true;
                currentNode = currentNode.next;
            }
            files[fileIndex].head = null;
        }
    }

    private static void viewAllocation() {
        for (int i = 0; i < fileCount; i++) {
            System.out.print("File: " + files[i].name + " - Blocks: ");
            Node currentNode = files[i].head;
            while (currentNode != null) {
                System.out.print(currentNode.blockNumber + " ");
                currentNode = currentNode.next;
            }
            System.out.println();
        }
    }
}
