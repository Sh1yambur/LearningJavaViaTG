package lesson_28_generics_1.task_3;

/*
 * Реализовать класс для работы с массивом.
 * Разработать метод, производящий поиск значения в массиве.
 * Если значение не найдено — выбрасывать исключение.
 * Если найдено — возвращать его.
 */

public class Task {
    public static void main(String[] args) {
        String[] values = new String[]{"one", "two", "42"};
        CustomType<String> customType = new CustomType<>(values);

        System.out.println(customType.findValue("42"));
        System.out.println(customType.findValue("three"));
    }
}
