package lesson_13_inheritance.task_2;

public class Cow extends Animal{
    public void moo(){
        System.out.println("moo");
    }

    @Override
    public void say() {
        moo();
    }
}
