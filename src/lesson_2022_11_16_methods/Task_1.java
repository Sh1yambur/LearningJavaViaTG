package lesson_2022_11_16_methods;

import java.util.Scanner;

/*
 * Вынести в отдельный метод использование switch-case.
 * Также вынести в отдельный метод использование  System.out.println
 */
public class Task_1 {
    public static void execute() {
        Scanner scanner = new Scanner(System.in);
        print("Enter string: ");
        String s = scanner.nextLine();
        scanner.close();

        showAnswer(s);
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static void showAnswer(String input) {
        switch (input) {
            case "Hi":
                print("Hello");
                break;

            case "Bye":
                print("Good bye");
                break;

            case "How are you":
                print("How are your doing");
                break;

            default:
                print("Unknown message");
        }
    }
}
