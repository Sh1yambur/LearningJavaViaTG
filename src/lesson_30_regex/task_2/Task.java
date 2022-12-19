package lesson_30_regex.task_2;

/*
 * Реализуйте метод для работы с ФИО.
 * Входным параметром должна являться строка, содержащая русскоязычное ФИО.
 * Фамилия, имя и отчество должны начинаться с прописной буквы и быть разделены пробелами.
 * Фамилия может быть двойной и писаться через дефис (каждая часть фамилии начинается с прописной буквы).
 * Если строка валидна – верните ФИО, обернутое в класс «Полное имя», содержащий фамилию, имя и отчество.
 * Если невалидна – бросьте из метода исключение, указывающее на ошибку валидации.
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(getFullName(getInput()));
    }

    private static String getInput() {
        System.out.print("(full name) <== ");
        return SC.nextLine().trim();
    }

    private static FullName getFullName(String input) {
        // replacing two or more spaces between words to one space
        String[] nameParts = input.replaceAll("(\s)+", " ").split(" ");
        System.out.println(Arrays.toString(nameParts));
        if (nameParts.length != 3) {
            throw new WrongNameException();
        }

        return new FullName(
                checkName(nameParts[0], NameType.FIRST),
                checkName(nameParts[1], NameType.SECOND),
                checkName(nameParts[2], NameType.LAST)
        );
    }

    private static String checkName(String namePart, NameType nameType) {
        String regex = "";
        switch (nameType) {
            case FIRST -> regex = ""; // todo
            case SECOND -> regex = ""; // todo
            case LAST -> regex = ""; // todo
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(namePart);

        if (matcher.matches()) {
            return namePart;
        } else {
            throw new WrongNameException();
        }
    }
}
