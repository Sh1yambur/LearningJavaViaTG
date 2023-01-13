package lesson_37_arraylist.task_1;

import java.util.ArrayList;

public class CounterService {
    // log messages
    private static final boolean NEED_LOG = true;

    private static final String ADD_NEW = "Added new counter \"%s\"(%s)";
    private static final String NEW_VALUE = "\"%s\" value changed. New value: %s";
    private static final String ALREADY_CONTENTS = "<!> Counter with name \"%s\" already contents in counter's list!";
    private static final String NOT_FOUND = "<!> Counter with name \"%s\" not found in counter's list!";
    private static final String INCORRECT_VALUE = "<!> Value must be positive!";

    private final ArrayList<Counter> countersList = new ArrayList<>();

    public ArrayList<Counter> getAllCounters() {
        return countersList;
    }

    public void addCounter(Counter newCounter) {
        if (countersList.contains(newCounter) || isNameContents(newCounter.getName())) {
            log(ALREADY_CONTENTS.formatted(newCounter.getName()));
        } else {
            countersList.add(newCounter);
            log(ADD_NEW.formatted(newCounter.getName(), newCounter.getValueAndUnit()));
        }
    }

    public void addCounters(Counter... newCounters) {
        for (Counter cnt : newCounters) {
            addCounter(cnt);
        }
    }

    public Counter getCounter(String counterName) {
        for (Counter cnt : countersList) {
            if (cnt.getName().equalsIgnoreCase(counterName)) {
                return cnt;
            }
        }
        log(NOT_FOUND.formatted(counterName));

        return null;
    }

    public void increaseValue(String counterName, int increment) {
        if (increment < 0) {
            log(INCORRECT_VALUE);
            return;
        }

        Counter target = getCounter(counterName);
        if (target != null) {
            target.setValue(target.getValue() + increment);
            log(NEW_VALUE.formatted(counterName, target.getValueAndUnit()));
        }
    }

    public void increment(String counterName) {
        increaseValue(counterName, 1);
    }

    public void resetValue(String counterName) {
        Counter target = getCounter(counterName);
        if (target != null) {
            target.setValue(0);
            log(NEW_VALUE.formatted(counterName, target.getValueAndUnit()));
        }
    }

    private boolean isNameContents(String name) {
        for (Counter cnt : countersList) {
            if (cnt.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }

        return false;
    }

    private void log(String message) {
        if (NEED_LOG) {
            System.out.println("==> " + message);
        }
    }
}
