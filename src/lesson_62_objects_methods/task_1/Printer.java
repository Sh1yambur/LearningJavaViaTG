package lesson_62_objects_methods.task_1;

public class Printer implements Runnable {
    private final Message message;

    public Printer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        while (message.isActive()) {
            message.print();
        }
    }
}
