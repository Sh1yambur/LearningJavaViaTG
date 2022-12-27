package lesson_30_regex.task_3;

public class InvalidWordException extends RuntimeException{
    public InvalidWordException() {
        super("Word(s) is invalid.");
    }
}
