package lesson_40_queue_2.task_1;

/*
 * Реализуйте класс Задание. Он должен содержать поле Название, состав остальных полей - на ваше усмотрение.
 * Реализуйте сервис, хранящий задания. Он должен иметь методы для добавления заданий и их "выполнения".
 * Задания должны обрабатываться в порядке очереди.
 * Критерием выполнения задания будем считать выведение в консоль фразы "Задание %название задания% выполнено!".
 * Также добавьте вывод сообщения в консоль о том, что задание (с указанием названия) добавлено.
 */

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        TaskService service = new TaskService();
        service.execute();

        for (int i = 0; i < 5; i++) {
            int index = new Random().nextInt(10);
            service.add(new Task("<(%s)>".formatted(index)));
        }

        service.execute();
        service.execute();
        service.execute();
        service.execute();
        service.execute();
        service.execute();
    }
}
