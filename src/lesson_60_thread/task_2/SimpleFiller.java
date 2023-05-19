package lesson_60_thread.task_2;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class SimpleFiller{
    public int[][] array;
    public Random random = new Random();
    public long fillTime;

    public SimpleFiller(int height, int width) {
        array = new int[height][width];
        long start = System.currentTimeMillis();
        fill();
        fillTime = System.currentTimeMillis() - start;
    }

    public void fill() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(1,11);
            }
        }
    }

    public void printFillTime() {
        System.out.println(this.getClass().getSimpleName() + " fill time: " + fillTime);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(this.getClass().getSimpleName() + " [\n");


        for (int[] arr : array) {
            builder.append("\t");
            builder.append(
                    Arrays.stream(arr)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(", "))
            );
            builder.append("\n");
        }
        builder.append("]");

        return builder.toString();
    }
}
