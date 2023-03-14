package lesson_52_stream_2.task_3;

/*
 * Реализуйте метод, возвращающий Stream<String> из дат месяца, номер которого был передан параметром.
 * Выведите все даты года в консоль. Избегайте дублирования кода.
 *
 * Вариант 1: каждый Stream, возвращенный из метода, должен быть сохранен в отдельную переменную.
 * Подсказка:  https://pastebin.com/rJ3uRWC1
 *
 * Вариант 2(*): в main() Stream должен быть лишь 1. Требует использования flatMap().
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // #1 (drug trip style)
        Stream<String> jan = getDates(1);
        Stream<String> feb = getDates(2);
        Stream<String> mar = getDates(3);
        Stream<String> apr = getDates(4);

        Stream.concat(jan,
                Stream.concat(feb,
                        Stream.concat(mar, apr)
                )
        ).forEach(System.out::println);

        // #2
        /*Stream.iterate(1, i -> i <= 12, i -> ++i)
                .flatMap(Main::getDates)
                .forEach(System.out::println);*/
    }

    private static Stream<String> getDates(int monthNum) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.now().withMonth(monthNum).withDayOfMonth(1);

        return Stream.iterate(date, d -> d.plusDays(1))
                .limit(date.getMonth().maxLength())
                .map(d -> d.format(formatter));
    }
}
