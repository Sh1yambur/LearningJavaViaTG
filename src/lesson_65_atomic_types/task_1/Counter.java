package lesson_65_atomic_types.task_1;

public class Counter {
    private final String name;
    private int value;

    public Counter(String name) {
        this.name = name;
    }

    public int incrementAt(int n) {
        value += n;
        return value;
    }

    public int decrementAt(int n) {
        if (value - n > 0) {
            value -= n;
        } else {
            reset();
        }
        return value;
    }

    public int reset() {
        value = 0;
        return value;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[%-20s](%8d)".formatted(name, value);
    }
}
