package lesson_2022_11_16_methods;

public class Task_3 {
    public static void execute() {
        printRectangle(1, 1);
    }

    private static void printRectangle(int width, int height) {
        for (int i = 0; i < height; i++) {
            printLine(width, i == 0 || i == height - 1);
            System.out.println();
        }
    }

    private static void printLine(int width, boolean isTopOrBottom) {
        String edge = isTopOrBottom ? "+" : "|";
        String inside = isTopOrBottom ? "-" : " ";

        for (int i = 0; i < width; i++) {
            if (i == 0 || i == width - 1) System.out.print(edge);
            else System.out.print(inside);
        }
    }
}
