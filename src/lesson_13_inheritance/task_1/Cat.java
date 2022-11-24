package lesson_13_inheritance.task_1;

class Cat extends Animal {

    private Cat() {
    }

    public Cat(String color) {
        this();
        System.out.printf("I'm a %s cat\n", color);
    }
}
