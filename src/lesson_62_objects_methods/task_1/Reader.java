package lesson_62_objects_methods.task_1;

public class Reader implements Runnable {
    private final Message message;

    public Reader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        while (message.isActive()){
            message.read();
        }
    }
}
