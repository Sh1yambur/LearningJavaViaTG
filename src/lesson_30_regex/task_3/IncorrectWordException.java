package lesson_30_regex.task_3;

public class IncorrectWordException extends RuntimeException{
    public IncorrectWordException() {
        super("Word(s) is incorrect.");
    }
}
