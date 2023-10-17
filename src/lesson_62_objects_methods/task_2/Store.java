package lesson_62_objects_methods.task_2;

public class Store {
    private final int maxCapacity;
    private int quantityOfGoods;
    private boolean isReceiving = true;

    public Store(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getFreeSpace() {
        return maxCapacity - quantityOfGoods;
    }

    public synchronized boolean getGoods(String name, int pcs) {
        while (quantityOfGoods == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        boolean isGoodsReceived = false;
        if (pcs <= quantityOfGoods) {
            quantityOfGoods -= pcs;
            isGoodsReceived = true;

            Logger.log(name, Logger.GET_MSG.formatted(pcs, 0, quantityOfGoods));
        } else {
            Logger.log(name, Logger.GET_MSG.formatted(0, pcs, quantityOfGoods));
        }

        updateReceiving();
        return isGoodsReceived;
    }

    public synchronized int addGoods(String name, int pcs) {
        while (!isReceiving) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        int refundGoods = 0;

        if (getFreeSpace() >= pcs) {
            quantityOfGoods += pcs;

            Logger.log(name, Logger.ADD_MSG.formatted(pcs, 0, quantityOfGoods));
        } else {
            refundGoods = pcs - getFreeSpace();
            quantityOfGoods += getFreeSpace();

            Logger.log(name, Logger.ADD_MSG.formatted(pcs - refundGoods, refundGoods, quantityOfGoods));
        }

        updateReceiving();
        notifyAll();

        return refundGoods;
    }

    private void updateReceiving() {
        if (getFreeSpace() == 0) {
            isReceiving = false;
        }

        if (getFreeSpace() > (maxCapacity * 0.75) && !isReceiving) {
            isReceiving = true;
            notifyAll();
        }
    }
}
