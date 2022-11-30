package lesson_16_abstract_and_interfaces.task_2;

import java.util.Scanner;

public class Task {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        Answerable[] messages = {new Hi(), new Bye(), new How()};
        System.out.println(getAnswer(messages, getInput()));
    }

    private static String getInput() {
        System.out.print("<== ");
        return SC.nextLine();
    }

    private static String getAnswer(Answerable[] messages, String input) {
        String result = null;
        for (Answerable message : messages) {
            if (input.equalsIgnoreCase(message.getQuestion())) {
                result = message.getAnswer();
            }
        }
        if (result == null) {
            result = new Unknown().getAnswer();
        }
        return "==> " + result;
    }
}
