package lesson_16_abstract_and_interfaces.task_1;

public class Square extends RegularShape{

    public Square(int dimension) {
        super(dimension);
    }

    @Override
    public void draw() {
        System.out.printf("Square with side's size %d is drawn\n", this.getDimension());
    }
}
