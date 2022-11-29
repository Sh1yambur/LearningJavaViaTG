package lesson_17_enum.task_3;

import java.util.Scanner;

public class Task {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        RegularShape.printShape(readInputType(), readInputDimension());
    }

    private static String readInputType() {
        System.out.print("(type) <== ");
        return SC.nextLine();
    }

    private static int readInputDimension() {
        System.out.print("(dimension) <== ");
        return SC.nextInt();
    }
}