package lesson_30_regex.task_2;

/*
 * Реализуйте метод для работы с ФИО.
 * Входным параметром должна являться строка, содержащая русскоязычное ФИО.
 * Фамилия, имя и отчество должны начинаться с прописной буквы и быть разделены пробелами.
 * Фамилия может быть двойной и писаться через дефис (каждая часть фамилии начинается с прописной буквы).
 * Если строка валидна – верните ФИО, обернутое в класс «Полное имя», содержащий фамилию, имя и отчество.
 * Если невалидна – бросьте из метода исключение, указывающее на ошибку валидации.
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {
    private static final Scanner SC = new Scanner(System.in);
    private static final String REGEX = "^[А-Я][а-я]+(-[А-Я][а-я]+)? ([А-Я][а-я]+)? ([А-Я][а-я]+)?$";

    public static void main(String[] args) {
        System.out.println(getFullName(getInput()));
    }

    private static String getInput() {
        System.out.print("(full name) <== ");
        return SC.nextLine().trim();
    }

    private static FullName getFullName(String input) {
        // replacing two or more spaces between words to one space
        String name = input.replaceAll("( )+", " ");

        if (checkName(name)){
            String[] nameParts = name.split(" ");
            return new FullName(nameParts[0], nameParts[1], nameParts[2]);
        } else {
            throw new WrongNameException();
        }
    }

    private static boolean checkName(String name) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(name);

        return matcher.matches();
    }
}
