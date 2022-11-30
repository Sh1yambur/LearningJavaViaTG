package lesson_16_abstract_and_interfaces.task_2;

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
