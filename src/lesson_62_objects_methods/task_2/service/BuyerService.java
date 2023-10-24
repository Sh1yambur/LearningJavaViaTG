package lesson_62_objects_methods.task_2.service;

import lesson_62_objects_methods.task_2.utility.ThreadKiller;
import lesson_62_objects_methods.task_2.model.Buyer;
import lesson_62_objects_methods.task_2.model.Store;

public class BuyerService implements Runnable {
    private final Buyer buyer;
    private final ThreadKiller threadKiller;

    public BuyerService(Store store, ThreadKiller threadKiller) {
        this.buyer = new Buyer(store);
        this.threadKiller = threadKiller;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (threadKiller.isAlive()) {
            buyer.buy();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
