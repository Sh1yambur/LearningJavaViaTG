package lesson_65_atomic_types.task_2;

/*
 * Реализуйте метод, возвращающий число элементов равных N в двумерном массиве целых чисел.
 * Массив и N должны передаваться как параметры метода.
 * Каждый одномерный массив должен быть обработан в своем потоке.
 */

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        int[][] array = {
                {1, 5, 1, 6, 7},
                {2, 5, 1, 6, 8, 1},
                {1, 1, 1, 1, 1, 1}
        };

        System.out.println(getNumCount(array, 1));
    }

    static int getNumCount(int[][] array, int targetNum) {
        AtomicInteger counter = new AtomicInteger();

        for (int[] arr : array) {
            Thread t = new Thread(() -> {
                for (int i : arr) {
                    if (i == targetNum) {
                        counter.getAndIncrement();
                    }
                }
            });

            t.start();

            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return counter.get();
    }
}
