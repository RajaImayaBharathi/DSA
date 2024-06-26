import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();

        int[] burstTime = new int[n];
        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];
        System.out.println("Enter the burst time of processes:");
        for (int i = 0; i < n; i++) {
            burstTime[i] = scanner.nextInt();
        }
        waitingTime[0] = 0;
        turnaroundTime[0] = burstTime[0];
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;

        for (int i = 1; i < n; i++) {
            waitingTime[i] = burstTime[i - 1] + waitingTime[i - 1];
            turnaroundTime[i] = turnaroundTime[i - 1] + burstTime[i];
            totalWaitingTime += waitingTime[i - 1];
            totalTurnaroundTime += turnaroundTime[i - 1];
        }

        totalWaitingTime += waitingTime[n - 1];
        totalTurnaroundTime += turnaroundTime[n - 1];

        double averageWaitingTime = (double) totalWaitingTime / n;
        double averageTurnaroundTime = (double) totalTurnaroundTime / n;
        System.out.println("\nbt\t wt\t tt");
        for (int i = 0; i < n; i++) {
            System.out.println(burstTime[i] + "\t " + waitingTime[i] + "\t " + turnaroundTime[i]);
        }

        System.out.printf("Average Waiting Time: %.2f\n", averageWaitingTime);
        System.out.printf("Average Turnaround Time: %.2f\n", averageTurnaroundTime);

        scanner.close();
    }
}
