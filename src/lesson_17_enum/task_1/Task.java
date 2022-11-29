package lesson_17_enum.task_1;

import java.util.Scanner;

public class Task {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("==> " + Message.findAnswer(readInput()));
        SC.close();
    }

    private static String readInput() {
        System.out.print("<== ");
        return SC.nextLine();
    }
}