package lesson_13_inheritance.task_2;

public class Dog extends Animal{
    public void woof(){
        System.out.println("woof");
    }

    @Override
    public void say() {
        woof();
    }
}
