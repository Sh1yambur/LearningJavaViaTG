package lesson_62_objects_methods.task_2;

import java.util.Random;

public class Supplier {
    private static final int LIMIT = 2;
    private final Random random = new Random();
    private final Store store;
    private final String name;
    private static int number = 1;

    private int undeliveredGoods;

    public Supplier(Store store) {
        this.name = "Supplier_" + number;
        number++;
        this.store = store;
    }

    public void deliver() {
        if (undeliveredGoods == 0) {
            undeliveredGoods = random.nextInt(1, store.getMaxCapacity() / LIMIT);
        }

        undeliveredGoods = store.addGoods(name, undeliveredGoods);
    }
}