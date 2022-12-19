package lesson_30_regex.task_2;

public class WrongNameException extends RuntimeException{
    public WrongNameException() {
        super("Name is wrong");
    }
}
