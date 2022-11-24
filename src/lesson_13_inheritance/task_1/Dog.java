package lesson_13_inheritance.task_1;

class Dog extends Animal {

    private Dog() {
    }

    public Dog(String color) {
        this();
        System.out.printf("I'm a %s dog\n", color);
    }
}
