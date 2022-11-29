package lesson_17_enum.task_3;

public enum RegularShape {
    TRIANGLE {
        @Override
        public void printShape(int dimension) {
            // some logic of shape printing
            System.out.printf("*** I'm\n** Triangle with\n* side's dimension %d", dimension);
        }
    },

    SQUARE {
        @Override
        public void printShape(int dimension) {
            // some logic of shape printing
            System.out.printf("*** I'm\n** Square with\n* side's dimension %d", dimension);
        }
    };

    public abstract void printShape(int dimension);

    public static void printShape(String type, int dimension) {
        for (RegularShape shape : RegularShape.values()) {
            if (shape.name().equalsIgnoreCase(type)) {
                shape.printShape(dimension);
                return;
            }
        }
        System.out.println("Unknown shape type");
    }
}
