package lesson_12_modificators.com.walking.counterAggregation;

import java.util.Arrays;

public class CounterService {
    // log messages
    private static final boolean NEED_LOG = true;
    private static final String ALREADY_CONTENTS = "(!) Counter with name \"%s\" already contents in counter's list!";
    private static final String NOT_FOUND = "(!) Counter with name \"%s\" not found in counter's list!";
    private static final String NEW_VALUE = "\"%s\" value changed. New value: %s";

    private static Counter[] COUNTERS = new Counter[0];

    public static Counter[] getAllCounters() {
        return COUNTERS;
    }

    public static void addCounter(Counter newCounter) {
        if (newCounter != null) {
            if (!isContents(newCounter)) {
                int oldLength = COUNTERS.length;
                COUNTERS = Arrays.copyOf(COUNTERS, oldLength + 1);
                COUNTERS[COUNTERS.length - 1] = newCounter;
            } else {
                println(String.format(ALREADY_CONTENTS, newCounter.getName()));
            }
        }
    }

    public static void addCounters(Counter... newCounters) {
        if (newCounters != null) {
            for (Counter c : newCounters) {
                addCounter(c);
            }
        }
    }

    public static Counter getCounter(String counterName) {
        Counter result = null;

        if (counterName != null) {
            for (Counter c : getAllCounters()) {
                if (c.getName().equalsIgnoreCase(counterName)) result = c;
            }
        }

        if (result == null) println(String.format(NOT_FOUND, counterName));

        return result;
    }

    public static void increaseValue(String counterName, int increment) {
        Counter counter = null;

        if (counterName != null) {
            counter = getCounter(counterName);
        }

        if (counter != null) {
            int oldValue = counter.getValue();
            counter.setValue(oldValue + increment);
            println(String.format(NEW_VALUE, counter.getName(), counter.getValueAndUnit()));
        }
    }

    public static void plusOneToValue(String counterName) {
        increaseValue(counterName, 1);
    }

    public static void resetValue(String counterName) {
        if (counterName != null) {
            Counter counter = getCounter(counterName);
            counter.setValue(0);
            println(String.format(NEW_VALUE, counter.getName(), counter.getValueAndUnit()));
        }
    }

    private static boolean isContents(Counter counter) {
        boolean result = false;
        for (Counter c : getAllCounters()) {
            if (c.getName().equals(counter.getName())) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static void println(String message) {
        if (NEED_LOG) System.out.println(message);
    }
}
