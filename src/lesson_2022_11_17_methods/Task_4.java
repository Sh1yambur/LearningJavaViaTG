package lesson_2022_11_17_methods;

/*
 * Вычислите результат выражения, используя рекурсивный алгоритм.
 * n — число, введенное с клавиатуры.
 * Для N < 1 — вывести соответствующее сообщение в консоль и завершить выполнение программы.
 *
 * Выражение: √(1 + √(2 + ... + √n)))
 */

public class Task_4 {
    public static void execute(){
        System.out.println("Expected: " + Math.sqrt(1 + Math.sqrt(2 + Math.sqrt(3 + Math.sqrt(4)))));
        System.out.println("Actual:   " + getRootsOneUpToN(4));

        System.out.println("Expected: " + Math.sqrt(2 + Math.sqrt(3 + Math.sqrt(4 + Math.sqrt(5)))));
        System.out.println("Actual:   " + getRoots(2, 5));
    }

    private static double getRootsOneUpToN(int num){
        return getRoots(1, num);

//        double result = 0.0;
//        for (int i = num; i >= 1; i--) {
//            result = Math.sqrt(result + i);
//        }
//        return result;
    }

    private static double getRoots(int min, int max){
        if(min == max) return Math.sqrt(min);
        return Math.sqrt(min + getRoots(min + 1, max));

//        double result = 0.0;
//        for (int i = max; i >= min; i--) {
//            result = Math.sqrt(result + i);
//        }
//        return result;
    }
}