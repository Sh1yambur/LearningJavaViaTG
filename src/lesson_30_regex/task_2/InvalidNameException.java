package lesson_30_regex.task_2;

public class InvalidNameException extends RuntimeException{
    public InvalidNameException() {
        super("Name is invalid");
    }
}
