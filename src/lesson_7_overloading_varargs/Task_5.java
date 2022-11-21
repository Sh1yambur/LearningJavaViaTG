package lesson_7_overloading_varargs;

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
        System.out.println(Arrays.toString(getPrimes(10)));
        System.out.println(getSumPrimes(getPrimes(10)));
    }

    private static int getSumPrimes(int[] array) {
        int result = 0;
        for (int value : array) result += value;
        return result;
    }

    private static int[] getPrimes(int limit) {
        int[] result = new int[limit];

        int num = 2;
        for (int i = 0; i < result.length; i++) {
            while (!isPrime(num)) num++;
            result[i] = num;
            num++;
        }
        return result;
    }

    private static boolean isPrime(int num) {
        return !isNotPrime(num, 2);
    }

    private static boolean isNotPrime(int num, int divisor) {
        if (divisor == num) return false;
        boolean notPrime = num % divisor == 0;
        return notPrime || isNotPrime(num, divisor + 1);
    }

//    /**
//     * Recursion integer indicator of prime number.
//     *
//     * @param num     number for checking on prime-number
//     * @param divisor current divisor (2..num-1)
//     * @return 0 if num is prime, more 0 if num is not prime
//     */
//    private static int checkPrime(int num, int divisor) {
//        if (divisor == num) return 0;
//        int prime = num % divisor == 0 ? 1 : 0;
//        return prime + checkPrime(num, divisor + 1);
//    }
}
