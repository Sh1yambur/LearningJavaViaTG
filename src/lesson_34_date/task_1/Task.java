package lesson_34_date.task_1;

/*
 * Реализуйте метод, возвращающий объект LocalDateTime на основании переданной строки.
 * Пример входящей строки: 20.12.2022 20:16:00.
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    public static void main(String[] args) {
        LocalDateTime dateTime = makeDateTimeObj("20.12.2022 20:16:00");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss EEEE d MMMM yyyy G");
        System.out.println(dateTime.format(formatter));
    }

    private static LocalDateTime makeDateTimeObj(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        return LocalDateTime.parse(input, formatter);
    }
}
