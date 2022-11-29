package lesson_16_abstract_and_interfaces.task_1;

public abstract class RegularShape {
    int dimension;

    public RegularShape(int dimension) {
        this.dimension = dimension;
    }

    public abstract void draw();
}
