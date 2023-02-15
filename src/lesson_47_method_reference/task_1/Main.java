package lesson_47_method_reference.task_1;

/*
 * Создайте произвольный список элементов.
 * Выведите каждый из элементов в консоль.
 * Параметр forEach() опишите как method reference.
 */

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List.of("One", "Two", "Three").forEach(System.out::println);
    }
}
