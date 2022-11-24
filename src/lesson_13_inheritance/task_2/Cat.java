package lesson_13_inheritance.task_2;

public class Cat extends Animal{
    public void meow(){
        System.out.println("meow");
    }

    @Override
    public void say() {
        meow();
    }
}
