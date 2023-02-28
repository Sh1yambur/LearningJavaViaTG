package lesson_50_stream_1.task_1.optional;

import java.util.*;

// OPTIONAL
// https://www.codingame.com/playgrounds/20782/java-guild-meeting-52018/optionals---practiceЗ

public class PhoneBook {

    private static final HashMap<String, String> PHONE_NUMBERS = new HashMap<String, String>() {
        {
            put("Jos de Vos", "016/161616");
            put("An de Toekan", "016/161617");
            put("Kris de Vis", "016/161618");
        }
    };

    private HashMap<String, String> phoneBookEntries = PHONE_NUMBERS;

    PhoneBook() {
    }

    public HashMap<String, String> getPhoneBookEntries() {
        return phoneBookEntries;
    }

    // Exercise 1
     public Optional<String> findPhoneNumberByName(String name) {
        return PHONE_NUMBERS.entrySet().stream()
                .filter(e -> e.getKey().equals(name))
                .map(Map.Entry::getValue)
                .findFirst();
    }

    // Exercise 1
    public Optional<String> findNameByPhoneNumber(String phoneNumber) {
        return PHONE_NUMBERS.entrySet().stream()
                .filter(e -> e.getValue().equals(phoneNumber))
                .map(Map.Entry::getKey)
                .findFirst();
    }

    @Override
    public String toString() {
        System.out.println("Hello from PhoneBook's toString method");
        return "PhoneBook{" +
                "phoneBookEntries=" + phoneBookEntries +
                '}';
    }
}
