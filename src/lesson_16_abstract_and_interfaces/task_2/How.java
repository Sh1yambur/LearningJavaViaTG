package lesson_16_abstract_and_interfaces.task_2;

public class How implements Answerable {
    private final String question;

    public How() {
        question = "How are you";
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String getAnswer() {
        return "How are you doing";
    }
}
