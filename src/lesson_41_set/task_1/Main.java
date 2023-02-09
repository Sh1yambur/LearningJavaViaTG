package lesson_41_set.task_1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        TaskService service = new TaskService();
        service.execute();

        for (int i = 0; i < 5; i++) {
            int index = new Random().nextInt(100);
            service.add(new Task("<(%s)>".formatted(index)));
        }

        service.execute();
        service.execute();
        service.add(new Task("<(042)>"));
        service.add(new Task("<(043)>"));

        service.execute();
        service.execute();
        service.execute();
        service.execute();
        service.execute();
    }
}
