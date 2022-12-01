package lesson_13_inheritance.task_2;

public class Cat extends Animal {
    public static final String TYPE = "Cat";

    public Cat() {
        super(TYPE, "meow");
    }

    public void meow() {
        super.say();
    }
}
