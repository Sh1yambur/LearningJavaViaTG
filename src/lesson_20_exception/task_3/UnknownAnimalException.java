package lesson_20_exception.task_3;

public class UnknownAnimalException extends RuntimeException {
    public UnknownAnimalException(String s) {
        super(s);
    }
}
