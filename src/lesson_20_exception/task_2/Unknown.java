package lesson_20_exception.task_2;

public class Unknown implements Answerable {
    @Override
    public String getQuestion() {
        return "";
    }

    @Override
    public String getAnswer() {
        return "Unknown message";
    }
}
