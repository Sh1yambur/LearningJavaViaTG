package lesson_25_nested_classes.task_1_static_nested;

import java.util.Scanner;

public class Task {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        printShape(getInput("type shape"), getInput("edge size"));
    }

    private static String getInput(String msg) {
        System.out.printf("(%s) <== ", msg);
        return SC.nextLine();
    }

    private static void printShape(String type, String dimensions) {
        int dim = Integer.parseInt(dimensions);

        switch (type) {
            case "triangle" -> new RegularShape.Triangle(dim).draw();
            case "square" -> new RegularShape.Square(dim).draw();
            default -> new RegularShape(dim).draw();
        }
    }
}
