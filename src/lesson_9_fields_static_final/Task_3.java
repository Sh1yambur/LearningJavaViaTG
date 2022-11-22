package lesson_9_fields_static_final;

/*
 * Используя задачу l7t5:
 * 1. Вынесите поиск простых чисел в отдельный класс.
 * 2. Реализуйте возможность вывода на экран суммы N первых простых чисел, где N – число, введенное пользователем с клавиатуры;
 * 3. Вынесите нужные вам переменные в поля класса. Если необходимо – сделайте их константами уровня класса или объекта.
 * Помните, константа ссылочного типа гарантирует неизменность ссылки, а не содержимого объекта. Массив – ссылочный тип.
 *
 * Примечание: это одна задача, а не различные варианты
 */

import java.util.Arrays;
import java.util.Scanner;

public class Task_3 {
    public static void execute() {
        PrimeNumbers.printSumPrimes();
    }
}

class PrimeNumbers {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String INPUT_STR = "Input amount numbers to sum: ";
    public static final String OUT_SUM_STR = "Sum of first %s prime numbers: %d\n";
    public static final String OUT_ARRAY_STR = "First %d prime numbers: %s\n";

    private static int[] primesArray;

    public static void printSumPrimes() {
        int limit = inputLimit();
        primesArray = new int[limit];
        fillPrimesArray();

        print(String.format(OUT_ARRAY_STR, limit, getStringFromArray()));
        print(String.format(OUT_SUM_STR, limit, getSumPrimesInArray()));
    }

    private static int inputLimit() {
        print(INPUT_STR);
        return SCANNER.nextInt();
    }

    private static void print(Object msg) {
        System.out.print(msg.toString());
    }

    private static String getStringFromArray() {
        String arrayStr = Arrays.toString(primesArray);
        return arrayStr.substring(1, arrayStr.length() - 1);
    }

    private static int getSumPrimesInArray() {
        int result = 0;
        for (int value : primesArray) result += value;
        return result;
    }

    private static void fillPrimesArray() {
        int number = 2;
        for (int i = 0; i < primesArray.length; i++) {
            while (isNotPrime(number)) number++;
            primesArray[i] = number;
            number++;
        }
    }

    private static boolean isNotPrime(int number) {
        return isNotPrime(number, 2);
    }

    private static boolean isNotPrime(int number, int divisor) {
        if (divisor == number) return false;
        boolean notPrime = number % divisor == 0;
        return notPrime || isNotPrime(number, divisor + 1);
    }
}
