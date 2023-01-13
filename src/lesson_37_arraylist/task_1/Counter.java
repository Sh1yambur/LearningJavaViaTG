package lesson_37_arraylist.task_1;

public class Counter {
    private final String name;
    private int value;
    private final String unit;

    public Counter(String name, int value, String unit) {
        this.name = name;
        this.value = value;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getValueAndUnit() {
        return String.format("%s %s", value, unit);
    }
}
