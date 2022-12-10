package lesson_25_nested_classes.task_1_inner;

public class RegularShape {

    private final int dimension;

    public RegularShape() {
        this.dimension = 0;
    }

    public RegularShape(int dimension) {
        this.dimension = dimension;
    }

    public int getDimension() {
        return this.dimension;
    }

    public void draw() {
        System.out.println("Unknown shape");
    }

    class Triangle extends RegularShape {

        public Triangle(int dimensions) {
            super(dimensions);
        }

        @Override
        public void draw() {
            // instead of the logic of the shape formation, the line will be printed
            System.out.printf("Triangle /%d\\\n", this.getDimension());
        }
    }

    class Square extends RegularShape {

        public Square(int dimension) {
            super(dimension);
        }

        @Override
        public void draw() {
            // instead of the logic of the shape formation, the line will be printed
            System.out.printf("Square |%d|\n", this.getDimension());
        }
    }
}
