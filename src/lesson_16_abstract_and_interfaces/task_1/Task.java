package lesson_16_abstract_and_interfaces.task_1;

public class Task {
    public static void main(String[] args) {
        RegularShape[] shapes = {new Triangle(3), new Square(4)};
        for (RegularShape shape : shapes) {
            shape.draw();
        }
    }
}
