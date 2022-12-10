package lesson_25_nested_classes.task_2_static_nested;

public class Animal {
    public void say() {
        System.out.println("Unknown animal");
    }

    static class Cat extends Animal {
        @Override
        public void say() {
            System.out.println("meow");
        }
    }

    static class Cow extends Animal {
        @Override
        public void say() {
            System.out.println("moo");
        }
    }

    static class Dog extends Animal {
        @Override
        public void say() {
            System.out.println("woof");
        }
    }
}
