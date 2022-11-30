package lesson_07_overloading_varargs;

import java.util.Arrays;

/*
 * Вычислить и записать в массив первые 10 простых чисел.
 * Простое число – положительное целое число, которое делится без остатка лишь на себя и на 1.
 * 1 не является простым числом.
 * Вывести в консоль сумму всех элементов полученного массива.
 * Нахождение простых чисел и вычисление суммы реализовать, используя рекурсивные методы.
 */

public class Task_5 {
    public static void execute() {
        System.out.println(Arrays.toString(getPrimesArray(10)));
        System.out.println(getSumPrimes(getPrimesArray(10)));
    }

    private static int getSumPrimes(int[] array) {
        int result = 0;
        for (int value : array) result += value;
        return result;
    }

    private static int[] getPrimesArray(int limit) {
        int[] result = new int[limit];

        int number = 2;
        for (int i = 0; i < result.length; i++) {
            while (isNotPrime(number)) number++;
            result[i] = number;
            number++;
        }
        return result;
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
