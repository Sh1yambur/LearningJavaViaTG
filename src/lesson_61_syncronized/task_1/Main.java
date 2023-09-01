package lesson_61_syncronized.task_1;

public class Main {
    private static final CarService SERVICE = new CarService();

    public static void main(String[] args) throws InterruptedException {
        //SERVICE.add(new Car("Lada Granta", "Silver", 2012));
        //SERVICE.add(new Car("Lada Priora", "Green", 2018));
        //SERVICE.add(new Car("Lada Kalina", "Black", 2016));
        System.out.println(SERVICE);

        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(() -> {
                SERVICE.add(new Car("Lada Granta", "Silver", 2012));
                SERVICE.add(new Car("Lada Priora", "Green", 2018));
                SERVICE.add(new Car("Lada Kalina", "Black", 2016));
            });
            t.start();
        }

        Thread.sleep(100);
        System.out.println(SERVICE);
    }
}
