package lesson_62_objects_methods.task_2.utility;

import java.util.Random;

public class Randomizer {
    private static final Random RANDOM = new Random();

    public static int get(int origin, int bound) {
        return RANDOM.nextInt(origin, bound);
    }
}
