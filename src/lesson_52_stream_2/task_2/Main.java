package lesson_52_stream_2.task_2;

/*
 * Реализуйте программу, выводящую в консоль все даты текущего месяца. Например:
 * 01.02.2023
 * 02.02.2023
 * ...
 * 28.02.2023
 *
 * Вариант 1: используя limit();
 * Вариант 2: НЕ используя limit().
 */

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        Month currentMonth = LocalDate.now().getMonth();
        LocalDate firstDate = LocalDate.now().withDayOfMonth(1);

        // with limit()
        Stream.iterate(firstDate, date -> date.plusDays(1))
                .limit(currentMonth.maxLength())
                .map(d -> d.format(formatter))
                .forEach(System.out::println);


        // without limit()
        IntStream.rangeClosed(1, currentMonth.maxLength())
                .mapToObj(n -> LocalDate.now().withDayOfMonth(n))
                .map(d -> d.format(formatter))
                .forEach(System.out::println);
    }
}
