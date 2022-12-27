package lesson_30_regex.task_3;

/*
 * Реализуйте программу, принимающую с клавиатуры строку, содержащую слова.
 * Выведите в консоль количество уникальных слов в строке.
 * Теперь слова в исходном массиве могут быть разделены несколькими пробелами,
 * а также знаками табуляции и иными пробельными символами.
 * Словами считаются лишь подстроки, состоящие из буквенных символов
 * или содержащие в середине слова один или несколько дефисов, но не более одного подряд.
 * При наличии в исходной строке невалидных символов или некорректном использовании допустимых,
 * должно быть выброшено исключение.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.regex.Pattern;

public class Task {
    private static final Pattern PATTERN = Pattern.compile("[A-Za-z]+(-?[A-Za-z]+)*");

    public static void main(String[] args) {
        System.out.println(getUniqueWordsCount(getInput()));
    }

    private static int getUniqueWordsCount(String input) {
        int count = 0;

        String fullString = input.trim().toLowerCase().replaceAll("(\\s)+", " ");
        String[] words = fullString.split(" ");
        StringJoiner joiner = new StringJoiner(", ");

        for (String word : words) {
            if (isValidWord(word) && !joiner.toString().contains(word)) {
                joiner.add(word);
                count++;
            }
        }
        //System.out.println(joiner); //log
        return count;
    }

    private static boolean isValidWord(String str) {
        if (PATTERN.matcher(str).matches()) {
            return true;
        }
        throw new InvalidWordException();
    }

    private static String getInput() {
        System.out.print("(text) <== ");
        String input = "";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            input = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return input;
    }
}
