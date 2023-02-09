package lesson_41_set.task_1;

import java.util.LinkedHashSet;

public class TaskService {
    LinkedHashSet<Task> taskQueue = new LinkedHashSet<>();

    public void add(Task task) {
        taskQueue.add(task);
        log(task.name(), "added.");
    }

    public void execute() {
        for (Task task : taskQueue) {
            log(task.name(), "executed!");
            taskQueue.remove(task);
            return;
        }
    }

    private void log(String taskName, String msg) {
        System.out.printf("==> Task %s %s%n", taskName, msg);
    }
}
