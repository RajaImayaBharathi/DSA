import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Process {
    int id;
    int burstTime;
    int priority;
    int waitingTime;
    int turnaroundTime;

    public Process(int id, int burstTime, int priority) {
        this.id = id;
        this.burstTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Number of processes
        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();

        Process[] processes = new Process[n];

        // Reading burst times and priorities
        for (int i = 0; i < n; i++) {
            System.out.print("Enter burst time for process " + (i + 1) + ": ");
            int burstTime = scanner.nextInt();
            System.out.print("Enter priority for process " + (i + 1) + ": ");
            int priority = scanner.nextInt();
            processes[i] = new Process(i + 1, burstTime, priority);
        }

        // Sort processes based on priority
        Arrays.sort(processes, Comparator.comparingInt(p -> p.priority));

        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;

        // Calculate waiting time and turnaround time
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                processes[i].waitingTime = 0;
            } else {
                processes[i].waitingTime = processes[i - 1].waitingTime + processes[i - 1].burstTime;
            }
            processes[i].turnaroundTime = processes[i].waitingTime + processes[i].burstTime;

            totalWaitingTime += processes[i].waitingTime;
            totalTurnaroundTime += processes[i].turnaroundTime;
        }

        double averageWaitingTime = (double) totalWaitingTime / n;
        double averageTurnaroundTime = (double) totalTurnaroundTime / n;

        // Print the results
        System.out.println("Process\tBurst Time\tPriority\tWaiting Time\tTurnAround Time");
        for (Process p : processes) {
            System.out.println(p.id + "\t\t" + p.burstTime + "\t\t" + p.priority + "\t\t" + p.waitingTime + "\t\t" + p.turnaroundTime);
        }

        System.out.printf("Average Waiting Time: %.2f\n", averageWaitingTime);
        System.out.printf("Average Turnaround Time: %.2f\n", averageTurnaroundTime);

        scanner.close();
    }
}
