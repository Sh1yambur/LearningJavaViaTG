package lesson_14_polymorphism.task_1;

public class Square extends RegularShape {
    private static final String SIDE_V = "|";
    private static final String SIDE_H = " - ";
    private static final String BLANK = "   ";
    private static final String CORNER = "+";

    public Square(int sideDimension) {
        super(sideDimension);
    }

    @Override
    public void draw() {
        printSquare();
    }

    private void printSquare() {
        for (int i = 0; i < edgeDimension; i++) {
            printLine(i == 0 || i == edgeDimension - 1);
            System.out.println();
        }
    }

    private void printLine(boolean isTopOrBottom) {
        String edge = isTopOrBottom ? CORNER : SIDE_V;
        String inside = isTopOrBottom ? SIDE_H : BLANK;

        for (int i = 0; i < edgeDimension; i++) {
            if (i == 0 || i == edgeDimension - 1) System.out.print(edge);
            else System.out.print(inside);
        }
    }
}
