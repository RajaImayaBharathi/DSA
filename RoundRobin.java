import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Process {
    int id;
    int burstTime;
    int remainingTime;
    int arrivalTime;
    int waitingTime;
    int turnaroundTime;

    public Process(int id, int burstTime, int arrivalTime) {
        this.id = id;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.arrivalTime = arrivalTime;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();
        System.out.print("Enter the time quantum: ");
        int quantum = scanner.nextInt();
        Queue<Process> processQueue = new LinkedList<>();
        Queue<Process> readyQueue = new LinkedList<>();
        Process[] processes = new Process[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter burst time for process " + (i + 1) + ": ");
            int burstTime = scanner.nextInt();
            System.out.print("Enter arrival time for process " + (i + 1) + ": ");
            int arrivalTime = scanner.nextInt();
            processes[i] = new Process(i + 1, burstTime, arrivalTime);
            processQueue.add(processes[i]);
        }
        int currentTime = 0;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        while (!processQueue.isEmpty() || !readyQueue.isEmpty()) {
            while (!processQueue.isEmpty() && processQueue.peek().arrivalTime <= currentTime) {
                readyQueue.add(processQueue.poll());
            }

            if (readyQueue.isEmpty()) {
                currentTime++;
                continue;
            }
            Process currentProcess = readyQueue.poll();
            if (currentProcess.remainingTime > quantum) {
                currentTime += quantum;
                currentProcess.remainingTime -= quantum;
                readyQueue.add(currentProcess);
            } else {
                currentTime += currentProcess.remainingTime;
                currentProcess.remainingTime = 0;
                currentProcess.turnaroundTime = currentTime - currentProcess.arrivalTime;
                currentProcess.waitingTime = currentProcess.turnaroundTime - currentProcess.burstTime;
                totalWaitingTime += currentProcess.waitingTime;
                totalTurnaroundTime += currentProcess.turnaroundTime;
            }
        }
        System.out.println("Process\tBurst Time\tArrival Time\tWaiting Time\tTurnAround Time");
        for (Process p : processes) {
            System.out.println(p.id + "\t\t" + p.burstTime + "\t\t" + p.arrivalTime + "\t\t" + p.waitingTime + "\t\t" + p.turnaroundTime);
        }

        double averageWaitingTime = (double) totalWaitingTime / n;
        double averageTurnaroundTime = (double) totalTurnaroundTime / n;

        System.out.println("\nAverage Waiting Time: " + averageWaitingTime);
        System.out.println("Average Turnaround Time: " + averageTurnaroundTime);

        scanner.close();
    }
}
