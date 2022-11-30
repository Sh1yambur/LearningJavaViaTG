package lesson_06_methods;


import java.util.Scanner;

/*
 * Вынести в отдельный метод метод логику, которая отрабатывает, когда первое число кратно и двум, и трем.
 */
public class Task_2 {
    public static void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a = scanner.nextInt();
        System.out.print("Enter b: ");
        int b = scanner.nextInt();
        scanner.close();

        if (a % 2 == 0 || b % 3 == 0) {
            System.out.println(a == b);
        }

        if (a % 2 == 0 && a % 3 == 0) {    // Данную проверку можно оптимизировать как a % 6 == 0
            printResultDivideTo2and3(a, b);
        }
    }

    private static void printResultDivideTo2and3(int a, int b){
        double result = Math.pow(a, b);

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            System.out.println("Результат выражения слишком большой!");
        } else {
            System.out.println((int) result);
        }
    }
}
