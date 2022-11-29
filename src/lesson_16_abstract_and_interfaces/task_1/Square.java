package lesson_16_abstract_and_interfaces.task_1;

public class Square extends RegularShape{

    public Square(int dimension) {
        super(dimension);
    }

    @Override
    public void draw() {
        System.out.println("Draw Square with edge size " + this.dimension);
    }
}
