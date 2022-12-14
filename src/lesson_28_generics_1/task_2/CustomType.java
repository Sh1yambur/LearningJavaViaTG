package lesson_28_generics_1.task_2;

public class CustomType<T> {
    private T value;

    public CustomType(T value) {
        this.value = value;
    }

    public boolean isNull() {
        return value == null;
    }
}
