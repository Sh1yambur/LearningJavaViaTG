package lesson_62_objects_methods.task_2.service;

import lesson_62_objects_methods.task_2.utility.ThreadKiller;
import lesson_62_objects_methods.task_2.model.Store;
import lesson_62_objects_methods.task_2.model.Supplier;

public class SupplierService implements Runnable {
    private final Supplier supplier;
    private final ThreadKiller threadKiller;


    public SupplierService(Store store, ThreadKiller threadKiller) {
        this.supplier = new Supplier(store);
        this.threadKiller = threadKiller;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (threadKiller.isAlive()) {
            supplier.deliver();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
