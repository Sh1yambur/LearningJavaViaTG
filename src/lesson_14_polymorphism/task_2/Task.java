package lesson_14_polymorphism.task_2;

public class Task {
    public static void main(String[] args) {
        Animal[] animals = {new Dog(), new Cat(), new Cow()};

        for (Animal a : animals) a.say();
    }
}