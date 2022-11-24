package lesson_13_inheritance.task_2;

public class Task {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();

        Animal[] animals = {dog, cat, cow};

        for(Animal a : animals) a.say();
    }
}