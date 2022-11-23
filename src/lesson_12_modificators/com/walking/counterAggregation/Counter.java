package lesson_12_modificators.com.walking.counterAggregation;

public class Counter {
    private final String name;
    private int value;
    private final String unit;

    public Counter(String counterName, String unitName) {
        this.name = counterName;
        this.unit = unitName;
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
