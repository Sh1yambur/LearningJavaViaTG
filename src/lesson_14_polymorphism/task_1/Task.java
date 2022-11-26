package lesson_14_polymorphism.task_1;

import java.util.Scanner;

public class Task {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        getShape(askShapeType(), askDimension()).draw();
    }

    private static int askShapeType() {
        System.out.println("Input num for print the shape");
        System.out.print("(3 for Triangle, 4 for Square): ");

        int input = SC.nextInt();
        while (input < 3 || input > 4) {
            System.out.print("Incorrect input! Try again: ");
            input = SC.nextInt();
        }
        return input;
    }

    private static int askDimension() {
        System.out.print("Input edge's dimension: ");
        return SC.nextInt();
    }

    private static RegularShape getShape(int type, int dim) {
        return switch (type) {
            case 3 -> new Triangle(dim);
            case 4 -> new Square(dim);
            default -> null;
        };
    }
}
