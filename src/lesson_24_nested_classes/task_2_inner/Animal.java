package lesson_24_nested_classes.task_2_inner;

public class Animal {
    public void say(){
        System.out.println("Unknown animal");
    }

    class Cat extends Animal{
        @Override
        public void say() {
            System.out.println("meow");
        }
    }

    class Cow extends Animal{
        @Override
        public void say() {
            System.out.println("moo");
        }
    }

    class Dog extends Animal{
        @Override
        public void say() {
            System.out.println("woof");
        }
    }
}
