package lesson_16_abstract_and_interfaces.task_1;

public class Triangle extends RegularShape {

    public Triangle(int dimension) {
        super(dimension);
    }

    @Override
    public void draw() {
        System.out.printf("Triangle with side's size %d is drawn\n", this.getDimension());
    }
}
