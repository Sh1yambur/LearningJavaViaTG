package lesson_24_nested_classes.task_1_anonimous;

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

        RegularShape triangle = new RegularShape(dim) {
            @Override
            public void draw() {
                // instead of the logic of the shape formation, the line will be printed
                System.out.printf("Triangle /%d\\\n", this.getDimension());
            }
        };

        RegularShape square = new RegularShape(dim) {
            @Override
            public void draw() {
                // instead of the logic of the shape formation, the line will be printed
                System.out.printf("Square |%d|\n", this.getDimension());
            }
        };

        RegularShape unknownShape = new RegularShape(dim);

        switch (type) {
            case "triangle" -> triangle.draw();
            case "square" -> square.draw();
            default -> unknownShape.draw();
        }
    }
}
