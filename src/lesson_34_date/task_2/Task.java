package lesson_34_date.task_2;

/*
 * Реализуйте программу, выводящую в консоль сообщение,
 * являются ли введенные с клавиатуры дата и время больше или меньше текущего.
 * Формат вводимых даты и времени: 20.12.2022 20:16:00
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        LocalDateTime inputTime = makeDateTimeObj(getInput());
        LocalDateTime nowTime = LocalDateTime.now();

        String result;
        if (inputTime.isAfter(nowTime)) {
            result = "AFTER";
        } else if (inputTime.isBefore(nowTime)) {
            result = "BEFORE";
        } else {
            result = "NOW";
        }

        System.out.println("Input time is " + result);
    }

    private static LocalDateTime makeDateTimeObj(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        return LocalDateTime.parse(input, formatter);
    }

    private static String getInput() {
        System.out.print("(date time) <== ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        return input;
    }
}
