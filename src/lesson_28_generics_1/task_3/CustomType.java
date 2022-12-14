package lesson_28_generics_1.task_3;

public class CustomType<T> {
    private T[] values;

    public CustomType(T[] values) {
        this.values = values;
    }

    public T findValue(T value) {
        for (T element : values) {
            if (element.equals(value)) {
                return element;
            }
        }
        throw new RuntimeException("Value not found");
    }
}
