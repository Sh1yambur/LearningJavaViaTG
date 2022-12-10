package lesson_24_nested_classes.task_1_inner;

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

        RegularShape triangle = new RegularShape().new Triangle(dim);
        RegularShape square = new RegularShape().new Square(dim);

        switch (type) {
            case "triangle" -> triangle.draw();
            case "square" -> square.draw();
            default -> System.out.println("Unknown shape");
        }
    }
}
