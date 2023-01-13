package lesson_37_arraylist.task_1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CounterService service = new CounterService();

        makeMockCounters(service);
        makeMockValues(service);

        printCountersValue(service.getAllCounters());
    }

    private static void makeMockCounters(CounterService service) {
        Counter gas = new Counter("Gas", 4242, "m\u00B3");
        Counter coldWater = new Counter("Cold Water", 1000, "m\u00B3");
        Counter hotWater = new Counter("Hot Water", 500, "m\u00B3");
        Counter electricity = new Counter("Electricity", 7070, "kW*h");

        service.addCounters(gas, coldWater, hotWater, electricity);

        Counter electricity2 = new Counter("Electricity", 777, "kW*h");
        service.addCounter(electricity2);
    }

    private static void makeMockValues(CounterService service) {
        service.increaseValue("Gas", 42);
        service.increaseValue("Hot Water", 77);
        service.increaseValue("Cold Water", 5);
        service.increaseValue("Electricity", 9);

        service.increment("electricity");

        service.resetValue("cold water");
        service.increaseValue("cold water", 42);

        service.increaseValue("Money", 1000);
    }

    private static void printCountersValue(List<Counter> counters) {
        System.out.println("===========================");
        for (Counter c : counters) {
            System.out.printf("%13s : %s\n", c.getName(), c.getValueAndUnit());
        }
        System.out.println("===========================");
    }
}
