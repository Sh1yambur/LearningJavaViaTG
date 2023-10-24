package lesson_64_thread_methods.task_1;

/*
 * Напишите программу из 10 последовательно запускающихся потоков.
 * Каждый из этих потоков должен выводить в консоль сообщение вида «%Имя потока% запущен и не спешит»,
 * вызывать yield(), а после выводить сообщение «%Имя потока% завершен».
 * Обратите внимание на порядок вывода. Как он изменится, если убрать yield()?
 * Как изменится ситуация, если паре потоков выставить приоритет 10?
 */

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                String name = Thread.currentThread().getName();
                System.out.println(name + " is running and not in a hurry");
                Thread.yield();
                System.out.println(name + " is finished");
            });

            if (i > 7) {
                t.setPriority(10);
            }
            t.start();
        }
    }
}
