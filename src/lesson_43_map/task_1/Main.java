package lesson_43_map.task_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.regex.Pattern;

public class Main {
    private static final Pattern PATTERN = Pattern.compile("^[A-Za-z]+(-?[A-Za-z]+)*$");
    private static final String ANY_WHITESPACES = "(\\s)+";
    private static final String ONE_WHITESPACE = " ";

    public static void main(String[] args) {
        getUniqueWords(getInput()).forEach((k, v) -> System.out.printf("%s : %s%n", k, v));
    }

    private static HashMap<String, Integer> getUniqueWords(String input) {
        HashMap<String, Integer> map = new HashMap<>();

        String fullString = input.trim().toLowerCase().replaceAll(ANY_WHITESPACES, ONE_WHITESPACE);
        String[] words = fullString.split(ONE_WHITESPACE);

        for (String word : words) {
            if (isValidWord(word)) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
        }

        return map;
    }

    private static boolean isValidWord(String str) {
        if (PATTERN.matcher(str).matches()) {
            return true;
        } else {
            throw new InputMismatchException();
        }
    }

    private static String getInput() {
        System.out.print("(text) <== ");
        String input;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            input = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return input;
    }
}
