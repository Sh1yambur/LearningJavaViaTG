package lesson_16_abstract_and_interfaces.task_2;

public class Bye implements Answerable {
    private final String question;

    public Bye() {
        question = "Bye";
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String getAnswer() {
        return "Good bye";
    }
}
