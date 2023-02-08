package lesson_40_queue_2.task_1;

public class TaskService {
    private Task[] taskQueue = new Task[3];

    public void add(Task task) {
        if (taskQueue[taskQueue.length - 1] != null) {
            grow();
        }

        for (int i = 0; i < taskQueue.length; i++) {
            if (taskQueue[i] == null) {
                taskQueue[i] = task;
                log("Task %s added".formatted(task.name()));
                return;
            }
        }
    }

    public void execute() {
        if (taskQueue[0] != null) {
            log("Task %s executed!".formatted(taskQueue[0].name()));
            trimFirst();
        }
    }

    private void log(String msg) {
        System.out.printf("==> %s%n", msg);
    }

    private void trimFirst() {
        System.arraycopy(taskQueue, 1, taskQueue, 0, taskQueue.length - 1);
    }

    private void grow() {
        Task[] growTaskQueue = new Task[taskQueue.length + (taskQueue.length / 2)];
        System.arraycopy(taskQueue, 0, growTaskQueue, 0, taskQueue.length);
        taskQueue = growTaskQueue;
    }
}
