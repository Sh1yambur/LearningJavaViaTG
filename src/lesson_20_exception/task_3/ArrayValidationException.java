package lesson_20_exception.task_3;

public class ArrayValidationException extends NullPointerException {
    public ArrayValidationException(String s) {
        super(s);
    }
}
