package lesson_9_fields_static_final;

import java.util.Scanner;

public class Task_1 {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static final String INPUT_WIDTH = "Input width: ";
    public static final String INPUT_HEIGHT = "Input height: ";

    public static final String CORNER = "+";
    public static final String HORIZONTAL_EDGE = "===";
    public static final String VERTICAL_EDGE = "|";
    public static final String ENTRAILS = "***";

    public static void execute() {
        int width = inputSize(INPUT_WIDTH);
        int height = inputSize(INPUT_HEIGHT);
        printRectangle(width, height);
    }

    private static int inputSize(String input) {
        print(input);
        return SCANNER.nextInt();
    }

    private static void printRectangle(int width, int height) {
        for (int i = 0; i < height; i++) {
            printLine(width, i == 0 || i == height - 1);
            print("\n");
        }
    }

    private static void printLine(int width, boolean isTopOrBottom) {
        String edge = isTopOrBottom ? CORNER : VERTICAL_EDGE;
        String inside = isTopOrBottom ? HORIZONTAL_EDGE : ENTRAILS;

        for (int i = 0; i < width; i++) {
            if (i == 0 || i == width - 1) print(edge);
            else print(inside);
        }
    }

    private static void print(Object line) {
        System.out.print(line.toString());
    }
}
