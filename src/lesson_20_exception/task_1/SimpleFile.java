package lesson_20_exception.task_1;

import java.util.Random;

public class SimpleFile {
    private final String name;
    private final int size;
    private final Type type;

    public SimpleFile(String name, Type type) {
        this.name = name;
        this.type = type;
        this.size = new Random().nextInt(1000);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("\"%s\"(%s, %dkb)", name, type.toString().toLowerCase(), size);
    }
}
