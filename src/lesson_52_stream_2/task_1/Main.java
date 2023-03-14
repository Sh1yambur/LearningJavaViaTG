package lesson_52_stream_2.task_1;

import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        guessNum(5);
        guessNum(2);
        guessNum(10);

        SC.close();
    }

    private static void guessNum(int num) {
        if (num <= 0) {
            System.out.println("Number should be more zero");
            return;
        }

        int prompt = num * 2 - num + 7;
        System.out.println("Guess number more 0 and less " + prompt);

        // task solution
        Stream.generate(SC::nextLine)
                .takeWhile(s -> !s.equalsIgnoreCase(String.valueOf(num)))
                .forEach(x -> System.out.println(x + " is wrong. Not guess"));

        System.out.printf("%d is right! You awesome :)%n", num);
    }
}
