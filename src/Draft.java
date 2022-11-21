public class Draft {
    int getX() {
        return x;
    }

    int y = getX();
    int x = 42;

    public static void main(String[] args) {
        Draft d = new Draft();
        System.out.printf("%d, %d", d.x, d.y);
    }
}
