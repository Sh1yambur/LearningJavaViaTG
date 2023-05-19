package lesson_60_thread.task_2;

public class Main {
    private static final int HEIGHT = 1000;
    private static final int WIDTH = 3000;

    private static final boolean PRINT = false;

    public static void main(String[] args) {
        if (PRINT) {
            System.out.println(new SimpleFiller(HEIGHT, WIDTH) + "\n");
            System.out.println(new ThreadFiller(HEIGHT, WIDTH) + "\n");
            System.out.println(new DynamicThreadFiller(HEIGHT, WIDTH));
        }

        new SimpleFiller(HEIGHT, WIDTH).printFillTime();
        new ThreadFiller(HEIGHT, WIDTH).printFillTime();
        new DynamicThreadFiller(HEIGHT, WIDTH).printFillTime();
    }
}
