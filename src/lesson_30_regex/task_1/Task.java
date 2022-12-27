package lesson_30_regex.task_1;

/*
 * Реализуйте boolean-метод, валидирующий входящую строку.
 * Метод должен возвращать true, если строка соответствует номеру мобильного телефона
 * (в качестве примера привожу номер для РФ, вы можете выбрать любой другой, но со схожей маской).
 * Маска корректного номера: +7 (XXX) XXX-XX-XX, где "X" – цифра от 0 до 9.
 * Обратите внимание на наличие скобок и пробелов.
 *
 * Вариант с усложнением (*): решите ту же задачу, но символы скобок, дефиса и пробелов – опциональны
 * (каждый из них может или присутствовать, как на оригинальной маске, так и отсутствовать вовсе,
 * возможность частичного использования или использования символов-разделителей в другом порядке считаем невалидным).
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {
    public static void main(String[] args) {
        System.out.println(isPhoneNumber("+7 (900) 123-45-67")); // ==> true
        System.out.println(isPhoneNumber("+9 (900) 123-45-67")); // ==> false
        System.out.println(isPhoneNumber("+7 900 123-45-67")); // ==> true
        System.out.println(isPhoneNumber("+7 900 12345678")); // ==> false
        System.out.println(isPhoneNumber("+79001234567")); // ==> true
        System.out.println(isPhoneNumber("79001234567")); // ==> false
        System.out.println(isPhoneNumber("+7(900)1234567")); // ==> true
    }

    // hard way solution
    private static boolean isPhoneNumber(String number) {
        String regex = "^(\\+7)( )?[(]?\\d{3}[)]?( )?\\d{3}( ?-?)?\\d{2}( ?-?)?\\d{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);

        return matcher.matches();
    }
}
