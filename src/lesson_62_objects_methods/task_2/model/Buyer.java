package lesson_62_objects_methods.task_2.model;

import lesson_62_objects_methods.task_2.utility.Randomizer;

public class Buyer {
    private static final int LIMIT = 4;
    private final Store store;
    private final String name;
    private static int number = 1;

    private int lastBought;
    private boolean isBoughtSuccessfully;

    public Buyer(Store store) {
        this.name = "Buyer_" + number;
        number++;
        this.store = store;
    }

    public void buy() {
        if (!isBoughtSuccessfully) {
            lastBought -= 1;
        }

        if (lastBought <= 0 || isBoughtSuccessfully) {
            lastBought = Randomizer.get(1, store.getMaxCapacity() / LIMIT);
        }

        isBoughtSuccessfully = store.getGoods(name, lastBought);
    }
}
