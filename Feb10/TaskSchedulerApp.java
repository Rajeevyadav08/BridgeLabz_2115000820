package Feb10;

import java.util.Scanner;
class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head = null;
    private Task current = null;

    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }
    }

    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }

    public void addAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position <= 1) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task temp = head;
        int count = 1;

        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        newTask.next = temp.next;
        temp.next = newTask;
    }

    public void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }

        Task temp = head, prev = null;
        do {
            if (temp.taskId == taskId) {
                if (temp == head) {
                    if (head.next == head) {
                        head = null;
                    } else {
                        Task last = head;
                        while (last.next != head) {
                            last = last.next;
                        }
                        head = head.next;
                        last.next = head;
                    }
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Task with ID " + taskId + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task with ID " + taskId + " not found.");
    }

    public void viewAndMoveToNext() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        if (current == null) {
            current = head;
        }

        System.out.println("Current Task: " + current.taskName + " (ID: " + current.taskId + ", Priority: " + current.priority + ", Due Date: " + current.dueDate + ")");
        current = current.next;
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        Task temp = head;
        do {
            System.out.println(temp.taskName + " (ID: " + temp.taskId + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate + ")");
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println(temp.taskName + " (ID: " + temp.taskId + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate + ")");
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with Priority " + priority + ".");
        }
    }
}

public class TaskSchedulerApp {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask Scheduler Menu");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Specific Position");
            System.out.println("4. Remove Task by Task ID");
            System.out.println("5. View Current Task and Move to Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search Task by Priority");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 1) {
                System.out.print("Enter Task ID: ");
                int taskId = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Task Name: ");
                String taskName = sc.nextLine();
                System.out.print("Enter Priority: ");
                int priority = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Due Date: ");
                String dueDate = sc.nextLine();
                scheduler.addAtBeginning(taskId, taskName, priority, dueDate);
            } else if (choice == 2) {
                System.out.print("Enter Task ID: ");
                int taskId = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Task Name: ");
                String taskName = sc.nextLine();
                System.out.print("Enter Priority: ");
                int priority = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Due Date: ");
                String dueDate = sc.nextLine();
                scheduler.addAtEnd(taskId, taskName, priority, dueDate);
            } else if (choice == 3) {
                System.out.print("Enter Task ID: ");
                int taskId = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Task Name: ");
                String taskName = sc.nextLine();
                System.out.print("Enter Priority: ");
                int priority = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Due Date: ");
                String dueDate = sc.nextLine();
                System.out.print("Enter Position: ");
                int position = sc.nextInt();
                scheduler.addAtPosition(taskId, taskName, priority, dueDate, position);
            } else if (choice == 4) {
                System.out.print("Enter Task ID to Remove: ");
                int taskId = sc.nextInt();
                scheduler.removeByTaskId(taskId);
            } else if (choice == 5) {
                scheduler.viewAndMoveToNext();
            } else if (choice == 6) {
                scheduler.displayAllTasks();
            } else if (choice == 7) {
                System.out.print("Enter Priority to Search: ");
                int priority = sc.nextInt();
                scheduler.searchByPriority(priority);
            } else if (choice == 8) {
                System.out.println("Exiting...");
                sc.close();
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
