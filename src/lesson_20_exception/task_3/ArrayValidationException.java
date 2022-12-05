package lesson_20_exception.task_3;

public class ArrayValidationException extends RuntimeException {
    public ArrayValidationException(int index) {
        super(String.format("Element by index %d is NULL", index));
    }
}
