package lesson_13_inheritance.task_2;

public class Cow extends Animal {
    public static final String TYPE = "Cow";

    public Cow() {
        super(TYPE, "moo");
    }

    public void moo() {
        super.say();
    }
}
