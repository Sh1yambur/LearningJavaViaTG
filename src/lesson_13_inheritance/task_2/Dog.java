package lesson_13_inheritance.task_2;

public class Dog extends Animal {
    public static final String TYPE = "Dog";

    public Dog() {
        super(TYPE, "woof");
    }

    public void woof() {
        super.say();
    }
}
