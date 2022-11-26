package lesson_14_polymorphism.task_1;

public class Triangle extends RegularShape {
    private static final String SIDE_L = "/";
    private static final String SIDE_R = "\\";
    private static final String SIDE_D = "--";
    private static final String BLANK = "  ";


    public Triangle(int sideDimension) {
        super(sideDimension);
    }

    @Override
    public void draw() {
        printTriangle();
    }

    private static void print(String el) {
        System.out.print(el);
    }

    private void printTriangle() {
        for (int vrt = 0; vrt < edgeDimension; vrt++) {
            for (int hrz = 1; hrz < edgeDimension - vrt; hrz++) {
                print(BLANK);
            }
            if (vrt != edgeDimension) print(SIDE_L);

            for (int hrz = edgeDimension - vrt * 2; hrz < edgeDimension; hrz++) {
                print(BLANK);
            }
            if (vrt != edgeDimension) print(SIDE_R);

            print("\n");

            if (vrt == edgeDimension - 1) {
                for (int i = 0; i < edgeDimension; i++) {
                    print(SIDE_D);
                    if (i < edgeDimension - 1) print(BLANK);
                }
            }
        }
    }
}