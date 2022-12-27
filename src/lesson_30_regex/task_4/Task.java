package lesson_30_regex.task_4;

/*
 * Реализуйте программу, разбивающую исходный текст на составные части.
 * Текст – на абзацы (разделены ‘\n’), абзацы на предложения (разделены "."/ "?"/ "?!"/ "!"/ "…").
 * Предложения на слова (разделены пробелами, но также могут использоваться знаки препинания ","/ "-", ":").
 * После этого выведите на экран исходный текст.
 * Предложения допустимо разделить точками, слова – пробелами без сохранения знаков пунктуации внутри предложения.
 * Сохранение изначальной пунктуации, на мой взгляд, излишне усложнит задачу и сдвинет акцент с практики регулярных выражений.
 * Подумайте, как наиболее корректно декомпозировать ваше решение.
 *
 * В качестве совета: попробуйте разные подходы для решения задачи,
 * нет необходимости реализовать наиболее оптимальным способом.
 * Например, одним из вариантов упрощения исходной задачи может стать избавление от лишних символов
 * или их замена одним определенным через метод replaceAll() класса String.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringJoiner;

public class Task {
    private static final File FILE = new File("./resource/task_30/text.txt");
    private static final String TEXT = readTextFromFile();

    private static final String PARAGRAPH_SPLIT = System.lineSeparator();
    private static final String SENTENCE_SPLIT = "[.]|[?]|!|[?!]|[.]{3}";
    private static final String WORD_SPLIT = "(, )|( - )|(: )";

    public static void main(String[] args) {
        System.out.println(getNormalizeText(TEXT));
    }

    private static String getNormalizeText(String text) {
        StringBuilder builder = new StringBuilder();

        String[] paragraphs = text.split(PARAGRAPH_SPLIT);

        for (String prg : paragraphs) {
            String[] sentences = prg.split(SENTENCE_SPLIT);

            for (String snt : sentences) {
                String[] words = snt.trim().split(WORD_SPLIT);

                for (int i = 0; i < words.length; i++) {
                    builder.append(words[i]);

                    if (i == words.length - 1) {
                        builder.append(". ");
                    } else {
                        builder.append(" ");
                    }
                }
            }
        }

        return builder.toString();
    }

    private static String readTextFromFile() {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String str;

            while ((str = reader.readLine()) != null) {
                joiner.add(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return joiner.toString();
    }
}
