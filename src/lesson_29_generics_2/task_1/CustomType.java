package lesson_29_generics_2.task_1;

public class CustomType<T> {
    private final T value;

    public CustomType(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
