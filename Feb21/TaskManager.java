package Feb21;

public class TaskManager {
    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000); // Simulating a long-running task
        return "Task Completed";
    }
}
