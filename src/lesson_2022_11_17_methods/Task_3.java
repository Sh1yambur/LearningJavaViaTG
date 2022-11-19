package lesson_2022_11_17_methods;

/*
 * Вычислите факториал введенного с клавиатуры целого числа, используя рекурсивный алгоритм.
 */
public class Task_3 {
    public static void execute() {
        printFactInLoop(25);
    }

    // todo: rewrite to BigInteger
    private static long getFactorial(int num) {
        if (num <= 1) return 1;
        return num * getFactorial(num - 1);
    }

    private static void printFactInLoop(int iteration) {
        for (int i = 0; i < iteration; i++) {
            long fact = getFactorial(i);
            if (fact < 0) {
                System.out.printf("Factorial %d out of Long-value\n", i);
                break;
            }
            System.out.printf("Factorial %d is %d\n", i, getFactorial(i));
        }
    }
}
