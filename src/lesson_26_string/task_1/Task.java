package lesson_26_string.task_1;

public class Task {
    public static void main(String[] args) {
        System.out.println(makeRectangle(8, 5));
    }

    private static String makeRectangle(int width, int height) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < height; i++) {
            builder.append(makeLine(width, i == 0 || i == height - 1));
            builder.append("\n");
        }

        return builder.toString();
    }

    private static String makeLine(int width, boolean isTopOrBottom) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < width; i++) {
            if (i == 0 || i == width - 1) {
                builder.append(isTopOrBottom ? "+" : "|");
            } else {
                builder.append(isTopOrBottom ? "-" : " ");
            }
        }

        return builder.toString();
    }
}
