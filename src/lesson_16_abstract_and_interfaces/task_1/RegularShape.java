package lesson_16_abstract_and_interfaces.task_1;

public abstract class RegularShape {
    private final int dimension;

    public RegularShape(int dimension) {
        this.dimension = dimension;
    }

    public int getDimension() {
        return this.dimension;
    }

    public abstract void draw();
}
