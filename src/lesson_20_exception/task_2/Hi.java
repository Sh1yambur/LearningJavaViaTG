package lesson_20_exception.task_2;

public class Hi implements Answerable {
    private final String question;

    public Hi() {
        question = "Hi";
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String getAnswer() {
        return "Hello";
    }
}
