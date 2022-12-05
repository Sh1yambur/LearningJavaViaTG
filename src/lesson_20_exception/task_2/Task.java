package lesson_20_exception.task_2;

import java.util.Scanner;

public class Task {
    private static final Scanner SC = new Scanner(System.in);
    private static final Answerable[] messages = {new Hi(), new Bye(), new How()};

    public static void main(String[] args) {
        while (true) {
            String input = getInput();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("==> exit");
                return;
            }
            System.out.println(getAnswer(input));
        }
    }

    private static String getInput() {
        System.out.print("<== ");
        String input = SC.nextLine();
        if (input.equalsIgnoreCase("exit")) {
            return input;
        }

        for (Answerable msg : messages) {
            if (input.equalsIgnoreCase(msg.getQuestion())) {
                return input;
            }
        }

        throw new InputValidationException(String.format("\"%s\" is wrong input", input));
    }

    private static String getAnswer(String input) {
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
