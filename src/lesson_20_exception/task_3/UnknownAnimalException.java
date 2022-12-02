package lesson_20_exception.task_3;

public class UnknownAnimalException extends ClassNotFoundException {
    public UnknownAnimalException(String s) {
        super(s);
    }
}
