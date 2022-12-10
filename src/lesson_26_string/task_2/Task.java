package lesson_26_string.task_2;

/*
 * Реализуйте программу, принимающую с клавиатуры строку, содержащую слова, разделенные пробелом.
 * Выведите в консоль количество уникальных слов в строке. Учтите, что строка может начинаться с пробела.
 * Для упрощения допустим, что в строке не могут использоваться символы, отличные от пробела или русских/английский букв.
 * Помните, что слово может быть введено в разных регистрах.
 */

import java.util.Scanner;

public class Task {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        String line = getInput().trim().toLowerCase();
        String[] words = line.split(" ");

        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (String word : words) {
            if (!builder.toString().contains(word)) {
                count++;
                builder.append(word);
                builder.append(" ");
            }
        }

        System.out.println("amount words = " + count);
    }

    private static String getInput() {
        System.out.print("(input) <== ");
        return SCANNER.nextLine();
    }
}
