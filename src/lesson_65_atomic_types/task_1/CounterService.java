package lesson_65_atomic_types.task_1;

import java.util.concurrent.ConcurrentHashMap;

public class CounterService {
    private final ConcurrentHashMap<String, Counter> counterMap = new ConcurrentHashMap<>();

    public void add(Counter counter) {
        if (counterMap.containsKey(counter.getName())) {
            System.out.printf("\"%s\" already exist%n", counter.getName());
        } else {
            counterMap.put(counter.getName(), counter);
        }
    }

    public Counter get(String name) {
        return counterMap.get(name);
    }

    public void remove(String name) {
        counterMap.remove(name);
    }

    public void printAllCounter() {
        counterMap.forEach((k, v) -> System.out.println(v));
    }
}
