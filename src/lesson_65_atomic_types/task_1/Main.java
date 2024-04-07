package lesson_65_atomic_types.task_1;

import java.util.Arrays;

public class Main {
    static Counter[] counterArray = {
            new Counter("water hot"),
            new Counter("water hot"),
            new Counter("water cold"),
            new Counter("gas"),
            new Counter("electricity day"),
            new Counter("electricity night")
    };

    static CounterService service = new CounterService();

    public static void main(String[] args) {
        counterArray[0].incrementAt(42);
        counterArray[2].incrementAt(7);
        counterArray[2].decrementAt(6);

        addAllCounters();
        service.printAllCounter();
    }

    static void addAllCounters() {
        Arrays.stream(counterArray).forEach(service::add);
    }
}
