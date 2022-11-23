package lesson_12_modificators.com.walking.counterAggregation;

public class Main {
    public static void main(String[] args) {
        makeMockCounters();
        makeMockValues();
        printCountersValue(CounterService.getAllCounters());
    }

    private static void makeMockCounters() {
        Counter gas = new Counter("Gas", "m\u00B3");
        Counter coldWater = new Counter("Cold Water", "m\u00B3");
        Counter hotWater = new Counter("Hot Water", "m\u00B3");
        Counter electricity = new Counter("Electricity", "kW*h");

        CounterService.addCounters(gas, coldWater, hotWater, electricity);

        Counter electricity2 = new Counter("Electricity", "kW*h");
        CounterService.addCounter(electricity2);
    }

    private static void makeMockValues() {
        CounterService.increaseValue("Gas", 4242);
        CounterService.increaseValue("Hot Water", 7700);
        CounterService.increaseValue("Cold Water", 555);
        CounterService.increaseValue("Electricity", 999);

        CounterService.plusOneToValue("electricity");

        CounterService.resetValue("cold water");
        CounterService.increaseValue("cold water", 42);

        CounterService.increaseValue("Money", 1000);
    }

    private static void printCountersValue(Counter[] counters) {
        System.out.println("===========================");
        for (Counter c : counters) {
            System.out.printf("%13s : %s\n", c.getName(), c.getValueAndUnit());
        }
        System.out.println("===========================");
    }
}
