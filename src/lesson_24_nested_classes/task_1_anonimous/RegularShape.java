package lesson_24_nested_classes.task_1_anonimous;

public class RegularShape {

    private final int dimension;

    public RegularShape(int dimension) {
        this.dimension = dimension;
    }

    public int getDimension() {
        return this.dimension;
    }

    public void draw(){
        System.out.println("Unknown shape");
    };
}
