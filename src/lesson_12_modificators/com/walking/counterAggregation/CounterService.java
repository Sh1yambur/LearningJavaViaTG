package lesson_12_modificators.com.walking.counterAggregation;

import java.util.Arrays;

public class CounterService {
    // log messages
    private static final boolean NEED_LOG = true;
    private static final String ADD_NEW = "Added new counter \"%s\"(%s)";
    private static final String ALREADY_CONTENTS = "(!) Counter with name \"%s\" already contents in counter's list!";
    private static final String NOT_FOUND = "(!) Counter with name \"%s\" not found in counter's list!";
    private static final String NEW_VALUE = "\"%s\" value changed. New value: %s";

    private Counter[] counters = new Counter[0];

    public Counter[] getAllCounters() {
        return counters;
    }

    public void addCounter(Counter newCounter) {
        if (newCounter != null) {
            if (!isContents(newCounter)) {
                int oldLength = counters.length;
                counters = Arrays.copyOf(counters, oldLength + 1);
                counters[counters.length - 1] = newCounter;
                println(String.format(ADD_NEW, newCounter.getName(), newCounter.getValueAndUnit()));
            } else {
                println(String.format(ALREADY_CONTENTS, newCounter.getName()));
            }
        }
    }

    public void addCounters(Counter... newCounters) {
        if (newCounters != null) {
            for (Counter c : newCounters) {
                addCounter(c);
            }
        }
    }

    public Counter getCounter(String counterName) {
        Counter result = null;

        if (counterName != null) {
            for (Counter c : getAllCounters()) {
                if (c.getName().equalsIgnoreCase(counterName)) {
                    result = c;
                }
            }
        }

        if (result == null) println(String.format(NOT_FOUND, counterName));

        return result;
    }

    public void increaseValue(String counterName, int increment) {
        Counter counter = getCounter(counterName);

        if (counter != null) {
            int oldValue = counter.getValue();
            counter.setValue(oldValue + increment);
            println(String.format(NEW_VALUE, counter.getName(), counter.getValueAndUnit()));
        }
    }

    public void increment(String counterName) {
        increaseValue(counterName, 1);
    }

    public void resetValue(String counterName) {
        if (counterName != null) {
            Counter counter = getCounter(counterName);
            counter.setValue(0);
            println(String.format(NEW_VALUE, counter.getName(), counter.getValueAndUnit()));
        }
    }

    private boolean isContents(Counter counter) {
        boolean result = false;
        for (Counter c : getAllCounters()) {
            if (c.getName().equals(counter.getName())) {
                result = true;
                return result;
            }
        }
        return result;
    }

    private void println(String message) {
        if (NEED_LOG) System.out.println(message);
    }
}
