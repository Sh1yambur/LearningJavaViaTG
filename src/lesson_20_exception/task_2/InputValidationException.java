package lesson_20_exception.task_2;

public class InputValidationException extends IllegalArgumentException {
    public InputValidationException(String message) {
        super(message);
    }
}
