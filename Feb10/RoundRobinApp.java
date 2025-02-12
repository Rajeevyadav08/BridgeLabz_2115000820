package Feb10;
import java.util.Scanner;

class Process {
    int processId;
    int burstTime;
    int priority;
    Process next;

    Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;

    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    public void removeProcess(int processId) {
        if (head == null) return;

        Process temp = head, prev = null;
        do {
            if (temp.processId == processId) {
                if (temp == head && temp == tail) {
                    head = tail = null;
                } else if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    prev.next = head;
                    tail = prev;
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Process with ID " + processId + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Process with ID " + processId + " not found.");
    }

    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int totalTime = 0;
        int processCount = 0;
        Process temp = head;

        while (true) {
            boolean allCompleted = true;
            Process current = temp;

            do {
                if (current.burstTime > 0) {
                    allCompleted = false;
                    int executionTime = Math.min(timeQuantum, current.burstTime);
                    System.out.println("Executing Process ID " + current.processId + " for " + executionTime + " units.");
                    current.burstTime -= executionTime;
                    totalTime += executionTime;
                }
                current = current.next;
            } while (current != temp);

            if (allCompleted) break;

            temp = temp.next;
        }

        System.out.println("Total time taken: " + totalTime + " units.");
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

public class RoundRobinApp {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nRound Robin Scheduler Menu");
            System.out.println("1. Add Process");
            System.out.println("2. Remove Process by ID");
            System.out.println("3. Simulate Round Robin Scheduling");
            System.out.println("4. Display All Processes");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Process ID: ");
                int processId = sc.nextInt();
                System.out.print("Enter Burst Time: ");
                int burstTime = sc.nextInt();
                System.out.print("Enter Priority: ");
                int priority = sc.nextInt();
                scheduler.addProcess(processId, burstTime, priority);
            } else if (choice == 2) {
                System.out.print("Enter Process ID to Remove: ");
                int processId = sc.nextInt();
                scheduler.removeProcess(processId);
            } else if (choice == 3) {
                System.out.print("Enter Time Quantum: ");
                int timeQuantum = sc.nextInt();
                scheduler.simulateRoundRobin(timeQuantum);
            } else if (choice == 4) {
                scheduler.displayProcesses();
            } else if (choice == 5) {
                System.out.println("Exiting...");
                sc.close();
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

